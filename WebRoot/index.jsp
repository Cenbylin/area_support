<%@ page language="java" import="java.util.*,com.areasupport.support.ConfigLoader" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Area Support 省市区三级联动数据库 外供调用 工程范例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="Area Support Info. Powered by Cenbylin">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>Area Support 省市区三级联动数据库 外供调用 工程范例</h1>
    <h2>webservice测试</h2>
    address:&nbsp;<a href='<%=ConfigLoader.getWebserviceAddress().replaceFirst("http://(.+?):", request.getScheme()+"://"+request.getServerName()+":") %>' target="_blank"><%=ConfigLoader.getWebserviceAddress().replaceFirst("http://(.+?):", request.getScheme()+"://"+request.getServerName()+":") %></a>
    <h2>rmi测试</h2>
    address:&nbsp;<a href='<%=ConfigLoader.getRmiName() %>'><%=ConfigLoader.getRmiName() %></a><br/>
    port:&nbsp;<%=ConfigLoader.getRmiPort() %>
    <h2>json数据版本</h2>
    <ul>
    	<li>获得所有省份：</li>
    	<table style="width:50%;" cellpadding="2" cellspacing="0" border="1" bordercolor="#000000">
			<tr>
				<td>Url</td>
				<td><a href='http://as.cenbylin.cn/area_support/api/GetProvinces' target="_blank">http://as.cenbylin.cn/area_support/api/GetProvinces</a></td>
			</tr>
			<tr>
				<td>参数</td>
				<td> 无</td>
			</tr>
		</table>
		<br/>
    	<li>获得所有城市：</li>
    	<table style="width:50%;" cellpadding="2" cellspacing="0" border="1" bordercolor="#000000">
			<tr>
				<td>Url</td>
				<td><a href='http://as.cenbylin.cn/area_support/api/GetCities?pro_id=19' target="_blank">http://as.cenbylin.cn/area_support/api/GetCities</a></td>
			</tr>
			<tr>
				<td>参数</td>
				<td> pro_id: 省份ID，由获得省份的接口可以拿到</td>
			</tr>
		</table>
		<br/>
		<li>获得所有地区：</li>
    	<table style="width:50%;" cellpadding="2" cellspacing="0" border="1" bordercolor="#000000">
			<tr>
				<td>Url</td>
				<td><a href='http://as.cenbylin.cn/area_support/api/GetDistricts?city_id=190' target="_blank">http://as.cenbylin.cn/area_support/api/GetDistricts</a></td>
			</tr>
			<tr>
				<td>参数</td>
				<td> city_id: 城市ID，由获得城市的接口可以拿到</td>
			</tr>
		</table>
    </ul>
    <h2>工程信息：</h2>
    <strong>GitHub:</strong><a href="https://github.com/Cenbylin/area_support" target="_blank">https://github.com/Cenbylin/area_support</a>
  	<br/><br/>
  	<strong>E-mail:</strong>admin@cenbylin.cn
  </body>
</html>
