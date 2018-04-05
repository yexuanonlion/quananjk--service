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
	<!-- uEditor -->
	<link rel="stylesheet" type="text/css" href="./ueditor/themes/default/css/ueditor.css"/>
	<script type="text/javascript" src="./ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="./ueditor/ueditor.all.min.js"></script>
	<!-- uEditor -->

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
  				<h1 class="pagetitle">信息修改</h1>
  			</div>
    		<div id="contentwrapper" class="contentwrapper">
    			<div id="basicform" class="subcontent">           
        			<div class="contenttitle2">
            			<h3>公司、产品信息修改更新</h3>
            		</div><!--contenttitle-->
					<form class="stdform" action="updateInformation.action?id=${information.id}" method="post">
						<p>
                			<label>标题</label>
                			<span class="field">
                				<input id="txtTitle" type="text" name="titleName" class="longinput" value="${information.titleName}" readonly="readonly"/>
                			</span>
                		</p>
                		<p>
                			<label>上次修改时间</label>
                			<span class="field">
                				<input id="txtTime" type="text" name="updateTime" class="longinput"  value="${information.updateTime}" readonly="readonly"/>
                			</span>
                		</p>
                		
                		<p>
                			<label>内容</label>
                			<span class="field">
                				<textarea name="content" id="informationEditor" style="width: 80%">${information.content}</textarea><br/>
  								<script type="text/javascript">
  									var editor = new UE.ui.Editor();
  									editor.render("informationEditor");
  								</script>
                			</span>
                		</p>
                		
						<br clear="all"/>
                        
                		<p class="stdformbutton">
                			<input id="submitButton" type="submit" class="reset radius2" value="提交"/>
                    		<input type="reset" class="reset radius2" value="重置"/>
                		</p>
              	</form>
              	<br/>
              		
        		</div><!--subcontent-->
     		</div>
		</div><!-- centercontent -->
	</div><!--bodywrapper-->

</body>

</html>



  	
