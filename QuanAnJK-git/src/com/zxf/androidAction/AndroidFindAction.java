package com.zxf.androidAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zxf.dao.SensorDao;
import com.zxf.dao.UserDao;
import com.zxf.po.Sensor;
import com.zxf.web.BaseAction;

public class AndroidFindAction extends BaseAction{
	private String username;
	SensorDao sensorDao = new SensorDao();
	UserDao userDao = new UserDao();
	
	public void findSensorsByColName(){
		System.out.println(username);
		try{
			this.httpResponse.setContentType("text/json;charset=utf-8");
			this.httpResponse.setCharacterEncoding("UTF-8");
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			List<Sensor> sensors = sensorDao.findSensorByColname(userDao.findUserByUsername(username).getCollierieName());
			for(int i=0;i<sensors.size();i++){
				Map<String,Object> sensorMap = new HashMap<String, Object>();
				sensorMap.put("id", sensors.get(i).getSensorNumber());
				sensorMap.put("position", sensors.get(i).getSensorPosition());
				sensorMap.put("work", sensors.get(i).getSensorWorkingCondition());
				sensorMap.put("alerttime", sensors.get(i).getSensorTime());
				sensorMap.put("powertime", sensors.get(i).getPowerTime());
				jsonArray.put(sensorMap);
			}
			jsonObject.put("sensorlist", jsonArray);
			System.out.println(jsonObject.toString());
			
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
