<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="vernav2 iconmenu">
	<ul>
    	<li><a href="explainJump.action" class="buttons">系统使用说明</a></li>
        <li><a href="#addons" class="buttons">煤矿管理</a>
        	<span class="arrow"></span>
            <ul id="addons">
               	<li><a href="addCollierieJump.action">添加新煤矿</a></li>
                <li><a href="infoCollierieJump.action">煤矿修改及查询</a></li>
            </ul>
        </li>
        <li><a href="#formsub" class="buttons">用户管理</a>
        	<span class="arrow"></span>
            <ul id="formsub">
               	<li><a href="addUserJump.action">添加新用户</a></li>
                <li><a href="infoUserJump.action">用户修改及查询</a></li>
            </ul>
        </li>
        <li><a href="infoSensorJump.action" class="buttons">传感器查询</a></li>
        <li><a href="#error" class="buttons">新闻管理</a>
        	<span class="arrow"></span>
            <ul id="error">
               	<li><a href="newsListJump.action">新闻列表</a></li>
                <li><a href="addNewsJump.action">添加新闻</a></li>
            </ul>
        </li>
        <li><a href="#information" class="buttons">公司|产品信息管理</a>
        	<span class="arrow"></span>
            <ul id="information">
               	<li><a href="companyJump.action">公司信息</a></li>
                <li><a href="productJump.action">产品信息</a></li>
            </ul>
        </li>
        <li><a href="uploadJump.action" class="buttons">新APP上传</a></li>       
    </ul>
    <a class="togglemenu"></a>
    <br /><br />
</div><!--leftmenu-->