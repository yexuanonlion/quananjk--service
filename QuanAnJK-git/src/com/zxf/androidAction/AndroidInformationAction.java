package com.zxf.androidAction;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.zxf.dao.InformationDao;
import com.zxf.po.Information;
import com.zxf.web.BaseAction;

public class AndroidInformationAction extends BaseAction{
	private int id;
	
	InformationDao infDao = new InformationDao();
	
	public void showInformation(){
		try{
			this.httpResponse.setContentType("text/json;charset=utf-8");
			this.httpResponse.setCharacterEncoding("UTF-8");
			JSONObject jsonObject = new JSONObject();
			Information information = infDao.findInformationById(id);
			Map<String,Object> informationMap = new HashMap<String, Object>();
			informationMap.put("id",information.getId() );
			informationMap.put("titleName", information.getTitleName());
			informationMap.put("content", information.getContent());
			
			jsonObject.put("information", informationMap);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
