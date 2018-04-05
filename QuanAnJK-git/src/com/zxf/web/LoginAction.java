package com.zxf.web;

import com.zxf.dao.UserDao;
import com.zxf.po.User;

public class LoginAction extends BaseAction{
	private String username;
	private String password;
	UserDao userDao = new UserDao();
	
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
	

	public String login() throws Exception{
		if(username.length()>0&&password.length()>0){
			User user = userDao.findUserByUsername(username);
			if(user!=null){
				if(user.getPassword().equals(password)){
					if(user.getCollierieName().equals("管理员")){
						session.put("userInfo", user);
						return "success";
					}else {
						session.put("errorLoginInfo", "该用户没有登录权限");
						return "fail";
					}
					
				}else{
					session.put("errorLoginInfo", "密码不正确");
					return "fail";
				}
			}else {
				session.put("errorLoginInfo", "该用户不存在");
				return "fail";
			}
		}else{
			session.put("errorLoginInfo", "账号或密码不能为空");
			return "fail";
		}
	}
}
