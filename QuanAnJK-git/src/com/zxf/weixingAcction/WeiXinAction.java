package com.zxf.weixingAcction;


import java.util.List;
import org.json.JSONObject;

import com.zxf.dao.AccidentCaseDao;
import com.zxf.dao.ModelSelectionDao;
import com.zxf.po.AccidentCase;
import com.zxf.web.BaseAction;

public class WeiXinAction extends BaseAction{
	private String year;
	private String month;
	private String day;
	private String time;
	private double basesize;
	private int flag;
	
	AccidentCaseDao accidentCaseDao = new AccidentCaseDao();
	ModelSelectionDao modelSelectionDao = new ModelSelectionDao();
	
	public WeiXinAction(){}
	
	//获取所有在记录的年份
	public void showYearList(){
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		JSONObject jsonObject = new JSONObject();
		try {
			List<Integer> yearList = accidentCaseDao.findAllYear();
			jsonObject.put("yearList", yearList);
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//获取年份对应的在记录的月
	public void showMonthList(){
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		JSONObject jsonObject = new JSONObject();
		try {
			List<Integer> monthList = accidentCaseDao.findAllMonthByYear(year);
			jsonObject.put("monthList", monthList);
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取月份在记录的月份
	public void showDayList(){
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		JSONObject jsonObject = new JSONObject();
		try {
			List<Integer> dayList = accidentCaseDao.findAllDayByYearAndMonth(year, month);
			jsonObject.put("dayList", dayList);
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取年月日对应的数据
	public void showAccidentCase(){
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		JSONObject jsonObject = new JSONObject();
		try {
			AccidentCase accidentCase = accidentCaseDao.findAccidentCaseByTime(time);
			jsonObject.put("accidentCase", accidentCase.getContent());
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取所需要的防松锁的型号
	public void showFSSModel(){
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		JSONObject jsonObject = new JSONObject();
		try {
			String rst = modelSelectionDao.findSize(flag, basesize);
			jsonObject.put("resultString", rst);
			byte[] jsonBytes = jsonObject.toString().getBytes("utf-8");
			httpResponse.setContentLength(jsonBytes.length);
			httpResponse.getOutputStream().write(jsonBytes);
			httpResponse.getOutputStream().flush();
			httpResponse.getOutputStream().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getBasesize() {
		return basesize;
	}

	public void setBasesize(double basesize) {
		this.basesize = basesize;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
