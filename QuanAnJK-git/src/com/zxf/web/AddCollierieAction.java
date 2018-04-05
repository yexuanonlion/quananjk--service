package com.zxf.web;

import com.zxf.dao.CollierieDao;
import com.zxf.po.Collierie;

public class AddCollierieAction extends BaseAction{
	private String colname;
	private String colPos;
	private String linkman;
	private String phone;
	private String tablename;
	CollierieDao dao = new CollierieDao();
	Collierie col;
	public String addCollierie() throws Exception{
		col = new Collierie();
		col.setCollierieName(colname);
		col.setPosition(colPos);
		col.setLinkman(linkman);
		col.setPhoneNumber(phone);
		col.setTableName(tablename);
		dao.saveCollierie(col);
		dao.creatTableForCol(tablename);
		return "success";
	}
	
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getColPos() {
		return colPos;
	}
	public void setColPos(String colPos) {
		this.colPos = colPos;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	
}
