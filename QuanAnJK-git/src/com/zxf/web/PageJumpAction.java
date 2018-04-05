package com.zxf.web;

import java.util.List;

import com.zxf.dao.CollierieDao;
import com.zxf.dao.UpLoadDao;
import com.zxf.po.UpLoadFile;

public class PageJumpAction {
	private List<String> colnames;//煤矿列表
	private List<UpLoadFile> fileList;//apk信息列表
	UpLoadDao fileDao = new UpLoadDao();
	CollierieDao coldao = new CollierieDao();
	public String addUserJump() throws Exception{
		colnames = coldao.findAllColnam();
		return "success";
	}
	
	public String infoUserJump(){
		return "success";
	}
	public String addColJump(){
		return "success";
	}
	public String infoColJump(){
		return "success";
	}
	public String uploadJump() throws Exception{
		fileList = fileDao.showFiles();
		return "success";
	}
	
	public String explainJump(){
		return "success";
	}
	
	public String infoSenJump() throws Exception{
		colnames = coldao.findAllColnam();
		return "success";
	}
	
	
	public List<String> getColnames() {
		return colnames;
	}
	public void setColnames(List<String> colnames) {
		this.colnames = colnames;
	}

	public List<UpLoadFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<UpLoadFile> fileList) {
		this.fileList = fileList;
	}
	
}
