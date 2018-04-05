package com.zxf.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements ServletResponseAware,ServletRequestAware,SessionAware,RequestAware{
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse httpResponse;
	protected Map<String,Object> request;
	protected Map<String,Object> session;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpRequest = arg0;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.httpResponse = arg0;
		
	}

}
