<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>山西全安新技术开发有限公司-手机监控后台管理系统</title>
	<link rel="stylesheet" href="./css/style.default.css" type="text/css" />
	<script type="text/javascript" src="./js/plugins/jquery-1.5.2.min.js"></script>
	<script type="text/javascript" src="./js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="./js/plugins/jquery.cookie.js"></script>
	<script type="text/javascript" src="./js/plugins/fullcalendar.min.js"></script>
	<script type="text/javascript" src="./js/custom/general.js"></script>
	<script type="text/javascript" src="./js/custom/calendar.js"></script>
	<script type="text/javascript">
		var nameflg = false;
		jQuery(function(){
			jQuery("#txtUserName").blur(function(){
				nameflg = false;
				var name = jQuery("#txtUserName").val();
				//用户名限制为3-16个由字母数字下划线组成的字符串
				var nameNorm = /^[a-zA-Z0-9_]{3,16}$/;
				if(name==""){
					jQuery("#mesage").html("用户名不能为空!");
					return;
				}
				if(!nameNorm.test(name)){
		        	jQuery("#mesage").html("用户名格式不正确!");
		        	return;
		      	}
				jQuery.post(
					"validUser.action",
					{"username":name},
					function(data){
						if(data){
							jQuery("#mesage").html("该用户名可以使用！");
							nameflg = true;
						}else{
							jQuery("#mesage").html("该用户名已经被使用！");
						}
					}
				);
			});
		});
		var passwordflg = false;
		jQuery(function(){
			jQuery("#txtPassword").blur(function(){
				passwordflg = false;
				var pas = jQuery("#txtPassword").val();
				var pasNorm = /^[A-Za-z0-9]{6,20}$/;
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
					jQuery("#mesahe").html("联系人电话不能为空！");
					return;
				}else{
					phonflg = true;
				}
			});
		});
		
		jQuery(function(){
			jQuery("form").submit(function(){
				if(nameflg&&passwordflg&&phonflg){
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
  		<h1 class="pagetitle">添加新用户</h1>
  	</div>
    <div id="contentwrapper" class="contentwrapper">
    	<div id="basicform" class="subcontent">           
        	<div class="contenttitle2">
            	<h3>添加新的管理员或者煤矿用户</h3>
            </div><!--contenttitle-->
			<form class="stdform" action="addUser.action" method="post">
				<p>
                	<label>用户名</label>
                	<span class="field">
                		<input id = "txtUserName" type="text" name="username" class="longinput" placeholder="请输入新的用户名（注用户名由3-16位字母加数字组成）"/>
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
                		<select name="colname">
                			<s:iterator value="colnames" id="collist">
                				<option><s:property /></option>
                			</s:iterator>
                		</select>
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
                	<input id="submitButton" type="submit" class="reset radius2" value="提交"/>
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