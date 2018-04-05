package com.zxf.web;

import java.util.ArrayList;
import java.util.List;

import com.zxf.dao.CollierieDao;
import com.zxf.po.Collierie;

public class QueryCollierieAction extends BaseAction{
	private String colname;
	private List<Collierie> collist;
	CollierieDao dao = new CollierieDao();
	
	public String queryAll() throws Exception{
		collist = new ArrayList<Collierie>();
		collist = dao.findAllCollierie();
		return "success";
	}
	public String queryOne() throws Exception{
		collist = new ArrayList<Collierie>();
		collist.add(dao.findCollierieByColname(colname));
		return "success";
	}
	
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public List<Collierie> getCollist() {
		return collist;
	}
	public void setCollist(List<Collierie> collist) {
		this.collist = collist;
	}
	
	
}
