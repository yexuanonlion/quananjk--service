package com.zxf.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zxf.po.User;


public class LoginInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession session = request.getSession(false);
		boolean flag = false;
		if(session!=null){
			User user = (User)session.getAttribute("userInfo");
			if(user!=null){
				flag = true;
			}
		}
		if(flag){
			return invocation.invoke();
		}else{
			response.sendRedirect("/QuanAnJK/Login.jsp");
		}
		return null;
		
	}
	

}
