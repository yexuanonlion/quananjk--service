package com.zxf.jpush;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import com.zxf.dao.AlarmRecordDao;
import com.zxf.dao.PushDao;
import com.zxf.po.AlarmRecord;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JPushSigletonUtil {
	
	
	private LinkedHashMap<String,String> oldMessage = new LinkedHashMap<String, String>();
	
	PushDao pushDao = new PushDao();
	
	static AlarmRecordDao alarmRecordDao = new AlarmRecordDao();

	
	/* 单例模式-饿汉模式 start */
	// 定义一个私有的构造方法
	private JPushSigletonUtil(){}
	// 将自身的实例对象设置为一个属性,并加上Static和final修饰符
	private static final JPushSigletonUtil instance = new JPushSigletonUtil(); 
	// 静态方法返回该类的实例
    public static JPushSigletonUtil getInstancei() {  
        return instance;  
    }  
	/* 单例模式end */
    
    public void pushMesssage(){
    	LinkedHashMap<String,String> newMessage = (LinkedHashMap<String, String>) pushDao.pushMessage();
    	Set<String> newkeys = newMessage.keySet();
		Iterator<String> keyItem = newkeys.iterator();
		ArrayList<String> newkeyList = new ArrayList<String>();
		while(keyItem.hasNext()){
			newkeyList.add(keyItem.next());
		}
		
    	if(oldMessage.size() != 0){
			if(newMessage.equals(oldMessage)){
				//新消息map与旧消息map完全相同的话则不推送消息
				System.out.println("内容相同不推送");
			}else{
				//根据Key键对比新旧map的value值，值相等不推送，不替换，新值为0的话不推送，不替换，除此推送替换value值
				if(newMessage.size() == oldMessage.size()){
					for(int j=0;j<newkeyList.size();j++){
						String key = newkeyList.get(j);
						if(newMessage.get(key) != "0"){
							if(newMessage.get(key).equals(oldMessage.get(key))){
								System.out.println("内容相同不推送");
							}else{
								oldMessage.put(key, newMessage.get(key));
								push(key,newMessage.get(key));
							}
						}
					}
					
				}else{
					for(int i=0;i<newkeyList.size();i++){
						if(newMessage.get(newkeyList.get(i)) != "0"){
							push(newkeyList.get(i),newMessage.get(newkeyList.get(i)));
						}
					}
					oldMessage = newMessage;
				}	
			}
		}else{
			for(int i=0;i<newkeyList.size();i++){
				if(newMessage.get(newkeyList.get(i)) != "0"){
					push(newkeyList.get(i),newMessage.get(newkeyList.get(i)));
				}
			}
			oldMessage = newMessage;
		}
		

    }
    
    private static void push(String tag,String pushMessage){
    	DateFormat format=new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
    	Date date = new Date();
		String time = format.format(date);
		String alarmContent = pushMessage;
    	pushMessage = "报警时间："+ time + pushMessage;
		
		String masterSecret = "14770a9c659978cb3744c4d2";
		String appKey = "6c42ec422de3dcaf826100c3";
		JPushClient jpushClient = new JPushClient(masterSecret, appKey);
		
		PushPayload payLoad = PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())//设置接受的平台 
				.setAudience(Audience.tag(tag))//Audience设置为all，说明采用广播方式推送，所有用户都可以接收到  
				.setNotification(Notification.alert(pushMessage))
				//.setMessage(Message.content(pushMessage))
				.setOptions(Options.newBuilder().setTimeToLive(3600).build())//设置离线消息保留一天
				.build();
		
		
		try {
			PushResult result = jpushClient.sendPush(payLoad);
			System.out.println("success");
			System.out.println(result.msg_id);
			System.out.println(result.sendno);
			
			//记录推送的报警消息
			AlarmRecord alarmRecord = new AlarmRecord();
			alarmRecord.setTag(tag);
			alarmRecord.setTime(time);
			alarmRecord.setContent(alarmContent);
			alarmRecordDao.saveAlarmRecord(alarmRecord);
			
			
		} catch (APIConnectionException | APIRequestException e) {
			// TODO Auto-generated catch block
			System.out.println("连接响应请求错误");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
