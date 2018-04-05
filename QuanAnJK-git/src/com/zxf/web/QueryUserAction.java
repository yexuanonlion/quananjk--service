package com.zxf.web;
import java.util.ArrayList;
import java.util.List;

import com.zxf.dao.UserDao;
import com.zxf.po.User;
public class QueryUserAction extends BaseAction{
	private List<User> userlist;
	private String username;
	UserDao dao = new UserDao();
	
	public String queryALL() throws Exception{
		userlist = new ArrayList<User>();
		userlist = dao.findAllUser();
		return "success";
	}
	public String queryOne() throws Exception{
		userlist = new ArrayList<User>();
		User user = dao.findUserByUsername(username);
		userlist.add(user);
		return "success";
	}
	
	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
