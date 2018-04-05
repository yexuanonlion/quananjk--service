package com.zxf.androidAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zxf.dao.AlarmRecordDao;
import com.zxf.po.AlarmRecord;
import com.zxf.web.BaseAction;

public class AndroidIosAlarmRecordAction extends BaseAction{
	private String tag;
	private String time;
	private String pageNum;
	
	

	AlarmRecordDao alarmRecordDao = new AlarmRecordDao();
	
	public void showAlarmRecordByTag(){
		try {
			this.httpResponse.setContentType("text/json;charset=utf-8");
			this.httpResponse.setCharacterEncoding("UTF-8");
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			List<AlarmRecord> alarmRecordList = alarmRecordDao.getAlarmRecordByTag(tag,Integer.parseInt(pageNum));
			
			for(int i=0;i<alarmRecordList.size();i++){
				Map<String,Object> newsMap = new HashMap<String, Object>();
				newsMap.put("id",alarmRecordList.get(i).getId() );
				newsMap.put("tag", alarmRecordList.get(i).getTag());
				newsMap.put("time", alarmRecordList.get(i).getTime());
				newsMap.put("content", alarmRecordList.get(i).getContent());
				jsonArray.put(newsMap);
			}
			jsonObject.put("alarmRecordList", jsonArray);	
			System.out.println(jsonObject.toString());
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void showAlarmRecordByTagAndTime(){
		try {
			this.httpResponse.setContentType("text/json;charset=utf-8");
			this.httpResponse.setCharacterEncoding("UTF-8");
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			List<AlarmRecord> alarmRecordList = alarmRecordDao.getAlarmRecordByTagAndTime(tag, time, Integer.parseInt(pageNum));
			
			for(int i=0;i<alarmRecordList.size();i++){
				Map<String,Object> newsMap = new HashMap<String, Object>();
				newsMap.put("id",alarmRecordList.get(i).getId() );
				newsMap.put("tag", alarmRecordList.get(i).getTag());
				newsMap.put("time", alarmRecordList.get(i).getTime());
				newsMap.put("content", alarmRecordList.get(i).getContent());
				jsonArray.put(newsMap);
			}
			jsonObject.put("alarmRecordList", jsonArray);	
			System.out.println(jsonObject.toString());
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
}
