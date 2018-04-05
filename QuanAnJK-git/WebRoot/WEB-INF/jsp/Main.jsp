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
  				<h1 class="pagetitle">系统使用说明</h1>
  			</div>
    		<div id="contentwrapper" class="contentwrapper">
    			<div id="basicform" class="subcontent">           
        			<div class="contenttitle2">
            			<h3>手机监控平台后台管理系统使用详解</h3>
            		</div><!--contenttitle-->
					<p>因系统特殊性请参照以下步骤进行操作</p>
					<h2>1.添加新煤矿用户并为该煤矿指派传感器数据库</h2>
					<br/>
					<p>如下图所示依次填写，注意根据提示填写，其中分配的数据表名要与阳光三级监控中上传插件配置的表名一致。</p>
					<img src="./images/shuomi/w1.png" />
					<p>当配置成功后会转到煤矿用户信息页面，在这里可以查看所有的煤矿用户以及管理员用户，以及对已有煤矿用户进行修改或删除。</p>
					<img src="./images/shuomi/w2.png" />
					<h2>2.为新添加的煤矿用户指派用户账号及密码</h2>
					<p>接着进行第二步，为刚刚添加的煤矿用户指派用户名以及密码，只有指派了用户名与密码该煤矿才可以通过手机监控平台查看井下传感器工作状态</p>
					<img src="./images/shuomi/w3.png" />
					<p>指派提交后会跳转到用户管理界面，这里可以对已有的用户进行查询，修改，删除等工作。</p>
					<img src="./images/shuomi/w6.png" />
					<br/>
            		<h2>3.传感器查询界面</h2>
            		<p>拥有管理员权限的用户可以在此处查看所有煤用户井下的传感器工作状态。</p>
            		<img src="./images/shuomi/w4.png" />
            		<br/>
            		<h2>4.新版手机监控系统APK上传界面</h2>
            		<p>这里可以上传最新版本的手机监控系统，以供手机平台用户通过自动更新功能来下载最新版本的手机监控系统。</p>
            		<img src="./images/shuomi/w5.png" />
        		</div><!--subcontent-->
     		</div>
		</div><!-- centercontent -->
    </div><!--bodywrapper-->
</body>

</html>



  	
