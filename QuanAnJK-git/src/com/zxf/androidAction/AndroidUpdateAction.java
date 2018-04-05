package com.zxf.androidAction;

import java.util.HashMap;
import java.util.Map;
import com.zxf.dao.UpLoadDao;
import com.zxf.po.UpLoadFile;
import com.zxf.web.BaseAction;

public class AndroidUpdateAction extends BaseAction{
	UpLoadDao uploadDao = new UpLoadDao();
	
	public void returnFileInfo() throws Exception{
		
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		Map<String,String> json = new HashMap<String, String>();
		
		UpLoadFile file = uploadDao.findLastFile();
		
		/*
		if(file!=null){
			json.put("message",URLEncoder.encode(file.getFileName()+"&"+file.getFileVersion(), "utf-8"));
		}else{
			json.put("message", URLEncoder.encode("0&0","utf-8"));
		}
		*/
		if(file!=null){
			json.put("message",file.getFileName()+"&"+file.getFileVersion());
		}else{
			json.put("message", "0&0");
		}
		System.out.println(json.toString());
		byte[] jsonBytes = json.toString().getBytes("utf-8");
		httpResponse.setContentLength(jsonBytes.length);
		httpResponse.getOutputStream().write(jsonBytes);
		httpResponse.getOutputStream().flush();
		httpResponse.getOutputStream().close();
	}
}
