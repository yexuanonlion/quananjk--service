package com.zxf.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;
import com.zxf.util.DBUtil;

public class PushDao {
	
	public Map<String,String> pushMessage(){
		Connection conn = null;
		LinkedHashMap<String,String> messageMap = new LinkedHashMap<String,String>();
		List<String> tables = new ArrayList<String>();
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement prep = (PreparedStatement) conn.prepareStatement("select stablename from collierie");
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				tables.add(rst.getString("stablename"));
			}
			for(int i=0;i<tables.size();i++){
				List<String> messageList = new ArrayList<String>();
				String sql = "select * from "+tables.get(i)+" where senworking not in ('合盖','合盖后','复电|有电','复电|停电','断电|停电')";
				PreparedStatement prep2 = (PreparedStatement) conn.prepareStatement(sql);
				ResultSet rst2 = prep2.executeQuery();
				while(rst2.next()){
					String mes = "位于"+rst2.getString("senposition")+"，编号为"+rst2.getString("sennumber")+"的传感器"+rst2.getString("senworking");
					messageList.add(mes);
				}
				if(messageList.size()!=0){
					messageMap.put(tables.get(i), messageList.toString());					
				}else{
					messageMap.put(tables.get(i), "0");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return messageMap;
	}
}
