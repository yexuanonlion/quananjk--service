package com.zxf.web;

import java.util.List;

import com.zxf.dao.InformationDao;
import com.zxf.po.Information;

public class InformationAction {
	private int id;
	private String content;
	private Information information;
	private List<Information> informationList;
	
	InformationDao informationDao = new InformationDao();
	
	public InformationAction(){}
	
	//显示公司信息
	public String showCompanyInformation() throws Exception{
		informationList = informationDao.showCompanyInformation();
		return "success";
	}
	//显示产品信息列表
	public String showProductInformation() throws Exception{
		informationList = informationDao.showProductInformation();
		return "success";
	}
	
	//更新信息
	public String updateInformation() throws Exception{
		informationDao.updateInformation(content, id);
		return "success";
	}
	
	//跳转到更新页面
	public String updateJump() throws Exception{
		information = informationDao.findInformationById(id);
		return "success";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Information> getInformationList() {
		return informationList;
	}

	public void setInformationList(List<Information> informationList) {
		this.informationList = informationList;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}
	
	
}
