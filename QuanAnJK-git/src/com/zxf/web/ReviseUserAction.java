package com.zxf.web;

import com.zxf.dao.UserDao;
import com.zxf.po.User;

public class ReviseUserAction extends BaseAction{
	private String username;
	private String password;
	private String colname;
	private String phonumber;
	UserDao dao = new UserDao();
	
	public String reviseUser() throws Exception{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setCollierieName(colname);
		user.setPhoneNumber(phonumber);
		dao.updateUser(user);
		return "success";
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
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}


	public String getPhonumber() {
		return phonumber;
	}


	public void setPhonumber(String phonumber) {
		this.phonumber = phonumber;
	}
	
	
	
}
