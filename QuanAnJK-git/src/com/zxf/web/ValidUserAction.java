package com.zxf.web;

import com.zxf.dao.UserDao;
import com.zxf.po.User;

public class ValidUserAction extends BaseAction{
	private String username;
	private boolean usernameOk = false;
	UserDao dao = new UserDao();
	
	public String valid() throws Exception{
		User user = dao.findUserByUsername(username);
		if(user == null){
			usernameOk = true;
		}else{
			usernameOk = false;
		}
		return "success";
	}
	
	public boolean isUsernameOk() {
		return usernameOk;
	}
	public void setUsernameOk(boolean usernameOk) {
		this.usernameOk = usernameOk;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
