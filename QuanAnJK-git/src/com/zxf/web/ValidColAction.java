package com.zxf.web;

import com.zxf.dao.CollierieDao;
import com.zxf.po.Collierie;

public class ValidColAction extends BaseAction{
	private String colname;
	private String tableName;
	private boolean tablenameOk = false;
	private boolean colnameOk = false;
	CollierieDao dao = new CollierieDao();
	
	public String valid() throws Exception{
		
		Collierie col = dao.findCollierieByColname(colname);
		
		if(col==null){
			colnameOk = true;
		}else{
			colnameOk = false;
			System.out.println(col.getCollierieName());
		}
		
		return "success";
	}
	
	public String validTable() throws Exception{
		Collierie col = dao.findCollierieByTableName(tableName);
		if(col==null){
			tablenameOk = true;
		}else{
			tablenameOk = false;
		}
		return "success";
	}
	
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public boolean isColnameOk() {
		return colnameOk;
	}
	public void setColnameOk(boolean colnameOk) {
		this.colnameOk = colnameOk;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isTablenameOk() {
		return tablenameOk;
	}

	public void setTablenameOk(boolean tablenameOk) {
		this.tablenameOk = tablenameOk;
	}
	
}
