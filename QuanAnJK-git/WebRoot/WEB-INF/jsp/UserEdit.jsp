<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>山西全安新技术开发有限公司-手机监控后台管理系统</title>
	<link rel="stylesheet" href="/css/style.default.css" type="text/css" />
	<script type="text/javascript" src="/js/plugins/jquery-1.5.2.min.js"></script>
	<script type="text/javascript" src="/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="/js/plugins/jquery.cookie.js"></script>
	<script type="text/javascript" src="/js/plugins/fullcalendar.min.js"></script>
	<script type="text/javascript" src="/js/custom/general.js"></script>
	<script type="text/javascript" src="/js/custom/calendar.js"></script>
	<script type="text/javascript">
		var passwordflg = false;
		jQuery(function(){
			jQuery("#txtPassword").blur(function(){
				passwordflg = false;
				var pas = jQuery("#txtPassword").val();
				var pasNorm = /^[a-zA-Z0-9_]{3,16}$/;
				if(pas==""){
					jQuery("#mesage").html("密码不能为空！");
					return;
				}
				if(pasNorm.test(pas)){
					passwordflg = true;
				}else{
					jQuery("#mesage").html("密码格式不正确！");
					return;
				}
			});
		});
		
		var phonflg = false;
		jQuery(function(){
			phonflg = false;
			jQuery("#txtPhon").blur(function(){
				var phonnum = jQuery("#txtPhon").val();
				if(phonnum==""){
					jQuery("#mesage").html("联系人电话不能为空！");
					return;
				}else{
					phonflg = true;
				}
			});
		});
		
		jQuery(function(){
			jQuery("form").submit(function(){
				if(passwordflg&&phonflg){
					return true;
				}else{
					alert("表单数据未通过检查！");
					return false;
				}
			});
		});
	</script>
  </head>
  
  <body class="withvernav">
	<div class="bodywrapper">
    	<!--topheader-->
    	<%@include file="../jsp/common/head.jsp"%>
    	<!--/topheader-->
    	<!--leftmenu-->
    	<%@include file="../jsp/common/sidebar.jsp"%>
    	<!--/leftmenu-->
        
    <div class="centercontent" id="center">
          	<div class="pageheader">
  		<h1 class="pagetitle">用户信息修改</h1>
  	</div>
    <div id="contentwrapper" class="contentwrapper">
    	<div id="basicform" class="subcontent">           
        	<div class="contenttitle2">
            	<h3>修改用户名密码或者基本信息</h3>
            </div><!--contenttitle-->
			<form class="stdform" action="reviseUser.action" method="post">
				<p>
                	<label>用户名</label>
                	<span class="field">
                		<input id = "txtUserName" type="text" name="username" class="longinput" readonly="readonly" value="${user.username}"/>
                	</span>
                	
                </p>
                <p>
                	<label>密码</label>
                	<span class="field">
                		<input id="txtPassword" type="password" name="password" class="longinput" placeholder="请输入密码（数字+字母）"/>
                	</span>
                </p>
                <p>
                	<label>所在矿名</label>
                	<span class="field">
                		<input id="txtColName" type="text" name="colname" class="longinput" readonly="readonly" value="${user.collierieName}"/>
                	</span>
                </p>
                <p>
                	<label>联系方式</label>
                	<span class="field">
                		<input id="txtPhon" type="text" name="phonumber" class="longinput" placeholder="请输入可以及时联系到您的手机号码"/>
                	</span>
                </p>
				<br clear="all"/>
                        
                <p class="stdformbutton">
                	<input type="submit" class="reset radius2" value="提交"/>
                    <input type="reset" class="reset radius2" value="重置"/>
                </p>
              </form>
              <br/>
              <p>
              	<span id = "mesage" style="color: red" name="errorMesage"></span>
              </p>
        </div><!--subcontent-->
     </div>
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>

</html>


