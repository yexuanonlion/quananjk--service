package com.zxf.web;

import com.zxf.dao.CollierieDao;
import com.zxf.dao.UserDao;

public class DeleteAction {
	private int id;
	UserDao userdao = new UserDao();
	CollierieDao coldao = new CollierieDao();
	public String deleteUser() throws Exception{
		userdao.deleteUser(id);
		return "success";
	}
	public String deleteCol() throws Exception{
		coldao.deleteCollierie(id);
		return "success";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
