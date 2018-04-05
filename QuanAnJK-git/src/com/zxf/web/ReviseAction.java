package com.zxf.web;

import com.zxf.dao.CollierieDao;
import com.zxf.dao.UserDao;
import com.zxf.po.Collierie;
import com.zxf.po.User;

public class ReviseAction {
	private int id;
	private User user = new User();
	private Collierie col = new Collierie();
	UserDao userdao = new UserDao();
	CollierieDao coldao = new CollierieDao();
	public String reviseUser() throws Exception{
		user = userdao.findUserById(id);
		return "success";
	}
	
	public String reviseCol() throws Exception{
		col = coldao.findCollierieById(id);
		return "success";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collierie getCol() {
		return col;
	}
	public void setCol(Collierie col) {
		this.col = col;
	}
	
}
