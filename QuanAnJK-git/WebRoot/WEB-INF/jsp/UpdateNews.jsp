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
	<script type="text/javascript">
		var titleflg = false;
		jQuery(function() {
			jQuery("#txtTitle").blur(function(){
				titleflg = false;
				var title = jQuery("#txtTitle").val();
				if(title==""){
					return;
				}else{
					titleflg = true;
				}
			});
		});
		
		var pubflg = false;
		jQuery(function(){
			jQuery("#txtPublisher").blur(function(){
				pubflg = false;
				var publisher = jQuery("#txtPublisher").val();
				if(publisher==""){
					return;
				}else{
					pubflg = true;
				}
			});
		});
		var proflg = false;
		jQuery(function(){
			proflg = false;
			jQuery("#txtProfile").blur(function(){
				var profile = jQuery("#txtProfile").val();
				if(profile==""){
					return;
				}else{
					proflg = true;
				}
			});
		});
		
		var conflg = false;
		jQuery(function(){
			var editor = new UE.ui.Editor();
  			editor.render("newsEditor");
  			jQuery("form").submit(function(){
  				if(editor.hasContents()){
  					conflg = true;
  				}
  				if(titleflg&&pubflg&&proflg&&conflg){
					return true;
				}else{
					alert("所填内容不能为空，请检查您填写的表单");
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
  				<h1 class="pagetitle">新闻修改</h1>
  			</div>
    		<div id="contentwrapper" class="contentwrapper">
    			<div id="basicform" class="subcontent">           
        			<div class="contenttitle2">
            			<h3>修改已有新闻内容</h3>
            		</div><!--contenttitle-->
					<form class="stdform" action="updateNews.action?id=${news.id}" method="post">
						<p>
                			<label>标题</label>
                			<span class="field">
                				<input id="txtTitle" type="text" name="title" class="longinput" value="${news.title}"/>
                			</span>
                		</p>
                		<p>
                			<label>来源</label>
                			<span class="field">
                				<input id="txtPublisher" type="text" name="publisher" class="longinput"  value="${news.publisher}"/>
                			</span>
                		</p>
                		<p>
                			<label>简介</label>
                			<span class="field">
                				<textarea id="txtProfile" name="profile" rows="2"  style="width: 80%">${news.profile}</textarea><br/>
                			</span>
                		</p>
                		
                		<p>
                			<label>内容</label>
                			<span class="field">
                				<textarea name="content" id="newsEditor" style="width: 80%">${news.content}</textarea><br/>
  								<!--  
  								<script type="text/javascript">
  									var editor = new UE.ui.Editor();
  									editor.render("newsEditor");
  								</script>
  								-->
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



  	
