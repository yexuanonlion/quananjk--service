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
		var colnameflg = false;
		jQuery(function() {
			jQuery("#txtCol").blur(function(){
				colnameflg = false;
				var name = jQuery("#txtCol").val();
				if(name==""){
					jQuery("#mesage").html("煤矿名不能为空!");
					return;
				}
				jQuery.post("validCol.action",
				{"colname":name},
				function(data){
					if(data){
						jQuery("#mesage").html("该煤矿名可以使用！");
						colnameflg = true;
					}else{
						colnameflg = false;
						jQuery("#mesage").html("该煤矿名已被使用，请选择其他煤矿名！");
					}
				});
			});
		});
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
		var tableflag = false;
		jQuery(function(){
			tableflag = false;
			jQuery("#txtTable").blur(function(){
				var tablename = jQuery("#txtTable").val();
				var tableNorm = /[a-z]/;
				if(tablename==""){
					jQuery("#mesage").html("分配的表明不能为空！");
					return;
				}
				if(!tableNorm.test(tablename)){
		        	jQuery("#mesage").html("表明格式不正确!");
		        	return;
		      	}
		      	jQuery.post(
		      		"validTable.action",
					{"tableName":tablename},
					function(data){
						if(data){
							jQuery("#mesage").html("该表名可以使用！");
							tableflag = true;
						}else{
							jQuery("#mesage").html("该表名已经被使用！");
						}
					}
		      	);
			});
		});
		jQuery(function(){
			jQuery("form").submit(function(){
				if(colnameflg&&posflg&&linkflg&&phonflg&&tableflag){
					return true;
				}else{
					jQuery("#mesage").html("表单数据未通过检查！");
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
  				<h1 class="pagetitle">添加新煤矿</h1>
  			</div>
    		<div id="contentwrapper" class="contentwrapper">
    			<div id="basicform" class="subcontent">           
        			<div class="contenttitle2">
            			<h3>添加使用“三开一防”传感器的煤矿用户</h3>
            		</div><!--contenttitle-->
					<form class="stdform" action="addCol.action" method="post">
						<p>
                			<label>煤矿名</label>
                			<span class="field">
                				<input id="txtCol" type="text" name="colname" class="longinput" placeholder="请输入新的煤矿名称"/>
                			</span>
                		</p>
                		<p>
                			<label>煤矿所在地</label>
                			<span class="field">
                				<input id="txtPos" type="text" name="colPos" class="longinput" placeholder="请输入煤矿详细地址"/>
                			</span>
                		</p>
                		<p>
                			<label>联系人</label>
                			<span class="field"><input id="txtLink" type="text" name="linkman" class="longinput" placeholder="请输入煤矿相关负责人名称"/></span>
                		</p>
                		<p>
                			<label>联系电话</label>
                			<span class="field">
                				<input id="txtPhon" type="text" name="phone" class="longinput" placeholder="请输入煤矿相关负责人联系电话"/>
                			</span>
                		</p>
                		<p>
                			<label>分配数据表</label>
                			<span class="field">
                				<input id="txtTable" type="text" name="tablename" class="logininput" placeholder="请为该煤矿分配数据表，且表明只能由小写字母[a-z]组成"/>
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



  	
