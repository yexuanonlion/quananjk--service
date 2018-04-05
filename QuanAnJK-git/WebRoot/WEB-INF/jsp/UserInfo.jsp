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
		var nameflg = false;
		jQuery(function(){
			jQuery("#checkUser").blur(function(){
				nameflg = false;
				var name = jQuery("#checkUser").val();
				if(name==""){
					alert("查询内容不能为空");
					return;
				}
				jQuery.post(
					"validUser.action",
					{"username":name},
					function(data){
						if(data){
							alert("您查询的内容不存在");	
						}else{
							nameflg = true;
						}
					}
				);
			});
		});
		
		jQuery(function(){
			jQuery("form").submit(function(){
				
				if(nameflg){
					return true;
				}else{
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
  		<h1 class="pagetitle">用户查询</h1>
  	</div>
    <div id="contentwrapper" class="contentwrapper">
    	<div id="basicform" class="subcontent">           
        	<div class="contenttitle2">
            	<h3>用户管理与修改</h3>
            	<form class="stdform" action="findByUserName.action" method="post">
            		<input id="checkUser" type="text" name="username" class="longinput"/>
            		<input type="submit" class="reset radius2" value="查询"/>
            	</form>
            </div><!--contenttitle-->
			<table cellpadding="0" cellspacing="0" border="0" class="stdtable">
                    <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">编号ID</th>
                            <th class="head1">用户名</th>
                            <th class="head0">密码</th>
                            <th class="head1">所在煤矿</th>
                            <th class="head0">联系方式</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th class="head0">编号ID</th>
                            <th class="head1">用户名</th>
                            <th class="head0">密码</th>
                            <th class="head1">所在煤矿</th>
                            <th class="head0">联系方式</th>
                            <th class="head1">操作</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <s:iterator value="userlist" var="users">
                        <tr>
                            <td class="center"><s:property value="#users.id" /></td>
                            <td class="center"><s:property value="#users.username" /></td>
                            <td class="center"><s:property value="#users.password" /></td>
                            <td class="center"><s:property value="#users.collierieName" /></td>
                            <td class="center"><s:property value="#users.phoneNumber" /></td>
                            <td class="center"><a href="reviseu.action?id=${users.id}"><font color="red">修改</font></a>/<a href="deleteu.action?id=${users.id}"><font color="red">删除</font></a></td>
                        </tr>
                        </s:iterator>
                    </tbody>
                </table>
        </div><!--subcontent-->
     </div>
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>

</html>


