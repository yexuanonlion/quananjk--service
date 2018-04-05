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
		
		var posflg = false;
		jQuery(function(){
			jQuery("#txtPos").blur(function(){
				posflg = false;
				var pas = jQuery("#txtPos").val();
				
				if(pas==""){
					jQuery("#mesage").html("煤矿地理位置不能为空！");
					return;
				}else{
					posflg = true;
				}
			});
		});
		var linkflg = false;
		jQuery(function(){
			linkflg = false;
			jQuery("#txtLink").blur(function(){
				var colname = jQuery("#txtLink").val();
				if(colname==""){
					jQuery("#mesage").html("煤矿联系人不能为空！");
					return;
				}else{
					linkflg = true;
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
				if(posflg&&linkflg&&phonflg){
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
  		<h1 class="pagetitle">煤矿信息修改</h1>
  	</div>
    <div id="contentwrapper" class="contentwrapper">
    	<div id="basicform" class="subcontent">           
        	<div class="contenttitle2">
            	<h3>修改用煤矿的基本信息</h3>
            </div><!--contenttitle-->
			<form class="stdform" action="reviseCollierie.action" method="post">
				<p>
                	<label>煤矿名</label>
                	<span class="field">
                		<input type="text" name="colname" class="longinput" value="${col.collierieName}" readonly="readonly"/>
                	</span>
                	
                </p>
                <p>
                	<label>煤矿位置</label>
                	<span class="field">
                		<input id="txtPos" type="text" name="colposition" class="longinput" placeholder="请输入新的煤矿位置"/>
                	</span>
                </p>
                <p>
                	<label>联系人</label>
                	<span class="field">
                		<input id="txtLink" type="text" name="linkman" class="longinput" placeholder="请输入新的联系人"/>
                	</span>
                </p>
                <p>
                	<label>联系方式</label>
                	<span class="field">
                		<input id="txtPhon" type="text" name="phonenumber" class="longinput" placeholder="请输入新的联系方式"/>
                	</span>
                </p>
                <p>
                	<label>表名</label>
                	<span class="field">
                		<input type="text" name="tablename" class="longinput" value="${col.tableName}" readonly="readonly"/>
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


  	
