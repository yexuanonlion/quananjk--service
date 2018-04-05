package com.zxf.androidAction;

import java.util.HashMap;
import java.util.Map;

import com.zxf.dao.UserDao;
import com.zxf.web.BaseAction;

public class AndroidChangePassword extends BaseAction{
	private String username;
	private String password;
	UserDao userDao = new UserDao();
	
	public void changePassword() throws Exception{
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		Map<String,String> json = new HashMap<String, String>();
		
		json.put("changePasswordMessage", userDao.changePassword(username, password));
		byte[] jsonBytes = json.toString().getBytes("utf-8");
		httpResponse.setContentLength(jsonBytes.length);
		httpResponse.getOutputStream().write(jsonBytes);
		httpResponse.getOutputStream().flush();
		httpResponse.getOutputStream().close();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
