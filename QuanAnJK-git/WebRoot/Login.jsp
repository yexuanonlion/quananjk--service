<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>山西全安新技术开发有限公司-手机监控后台管理系统</title>
	<link rel="stylesheet" href="css/style.default.css" type="text/css" />
  </head>
  
  <body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo">山西全安新技术开发有限公司</h1>
				<span class="slogan">手机监控后台管理系统</span>
            </div><!--logo-->
            <br clear="all" /><br />
            
            <div>
				<div><h4 align="center"><font color="red">${errorLoginInfo}</font></h4></div>
            </div><!--nopassword-->

            <form id="login" action="login.action" method="post">
            	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="username" id="username" />
                    </div>
                </div>
                
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" />
                    </div>
                </div>
                <button>登录</button>
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->


</body>

</html>
