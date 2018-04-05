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
			<form class="stdform" action="upload.action" method="post" enctype="multipart/form-data">
            	<input type="file" name="file"/>	
            	<input type="submit" class="reset radius2" value="上传"/>
            </form>
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
                            <th class="head0">apk名称</th>
                            <th class="head1">apk版本</th>
                            <th class="head0">上传时间</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th class="head0">apk名称</th>
                            <th class="head1">apk版本</th>
                            <th class="head0">上传时间</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <s:iterator value="fileList" var="uploadFiles">
                        <tr>
                            <td class="center"><s:property value="#uploadFiles.fileName" /></td>
                            <td class="center"><s:property value="#uploadFiles.fileVersion" /></td>
                            <td class="center"><s:property value="#uploadFiles.upLoadTime" /></td>
                        </tr>
                        </s:iterator>
                        
                        
                        
                    </tbody>
                </table>
            <p>
            	<span id = "mesage" style="color: red" name="errorMesage"><s:property value="upFileMessage"/></span>
            </p>
              
        </div><!--subcontent-->
     </div>
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>

</html>



  	
