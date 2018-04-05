package com.zxf.web;

import com.zxf.dao.CollierieDao;
import com.zxf.po.Collierie;

public class ReviseCollierieAction extends BaseAction{
	private String colname;
	private String colposition;
	private String linkman;
	private String phonenumber;
	CollierieDao dao = new CollierieDao();
	
	public String reviseCollierie() throws Exception{
		Collierie col = new Collierie();
		col.setCollierieName(colname);
		col.setPosition(colposition);
		col.setLinkman(linkman);
		col.setPhoneNumber(phonenumber);
		dao.updateCollierie(col);
		return "success";
	}
	
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getColposition() {
		return colposition;
	}
	public void setColposition(String colposition) {
		this.colposition = colposition;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
