package com.zxf.androidAction;

import java.util.HashMap;
import java.util.Map;
import com.zxf.dao.UserDao;
import com.zxf.po.User;
import com.zxf.web.BaseAction;

public class AndroidLoginAction extends BaseAction{
	private String username;
	private String password;
	UserDao userDao = new UserDao();
	public void login() throws Exception{
		this.httpResponse.setContentType("text/json;charset=utf-8");
		this.httpResponse.setCharacterEncoding("utf-8");
		Map<String,String> json = new HashMap<String, String>();
		System.out.println("请求过来的用户名为："+username +"；密码为："+ password);
		User user = userDao.findUserByUsername(username);
		if(user!=null){
			if(user.getPassword().equals(password)){
				//登录成功
				String tag = userDao.findTableNameAndColnameByUsername(username);
				tag = "1&"+tag;
				//json.put("message", URLEncoder.encode(tag,"utf-8"));
				json.put("message", tag);
			}else{
				//密码错误
				json.put("message", "2");
			}
		}else {
			//账号错误
			json.put("message", "3");	
		}
		byte[] jsonBytes = json.toString().getBytes("utf-8");
		httpResponse.setContentLength(jsonBytes.length);
		httpResponse.getOutputStream().write(jsonBytes);
		httpResponse.getOutputStream().flush();
		httpResponse.getOutputStream().close();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
