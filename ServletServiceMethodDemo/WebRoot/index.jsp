<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  	function refreshValidate()
  	{
  		var img=document.getElementById("validateImg");
  		img.src="validateCode?sn="+Math.random();	//加sn，给一个随机数就不会从缓存中去数据，而会从数据库中取数据
  	}
  </script>
  <body>
  	<form action="login">
  		用户名：<input type="text">
  		<br><br>
  		密&nbsp;&nbsp;&nbsp;码：<input type="text">
  		<br><br>
  		<input type="text">
		<img alt="validate" src="validateCode" id="validateImg" onclick="refreshValidate()">
    	<span><a href="#" onclick="refreshValidate()">看不清楚?换一张</a></span>  	
  	</form>
  </body>
</html>
