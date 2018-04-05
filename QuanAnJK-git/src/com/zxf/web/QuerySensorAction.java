package com.zxf.web;

import java.util.ArrayList;
import java.util.List;

import com.zxf.dao.CollierieDao;
import com.zxf.dao.SensorDao;
import com.zxf.po.Sensor;

public class QuerySensorAction extends BaseAction{
	private String colName;
	private List<Sensor> sensorlist;
	private boolean colNameOk = false;
	private List<String> colnames;
	SensorDao dao = new SensorDao();
	CollierieDao coldao = new CollierieDao();
	public String queryByColname() throws Exception{
		colnames = coldao.findAllColnam();
		sensorlist = new ArrayList<Sensor>();
		sensorlist = dao.findSensorByColname(colName);
		return "success";
	}
	
	public String validColName() throws Exception{
		if(dao.vaildColname(colName)){
			setColNameOk(true);
		}else {
			setColNameOk(false);
		}
		return "success";
	}
	
	
	
	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public List<Sensor> getSensorlist() {
		return sensorlist;
	}
	public void setSensorlist(List<Sensor> sensorlist) {
		this.sensorlist = sensorlist;
	}

	public boolean isColNameOk() {
		return colNameOk;
	}

	public void setColNameOk(boolean colNameOk) {
		this.colNameOk = colNameOk;
	}

	public List<String> getColnames() {
		return colnames;
	}

	public void setColnames(List<String> colnames) {
		this.colnames = colnames;
	}
	
	
}
