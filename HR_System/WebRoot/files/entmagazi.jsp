<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/depart.css">
<link rel="stylesheet" type="text/css" href="../css/font-awesome.css" />
<script type="text/javascript" src="../js/jquery-1.11.2.min.js"></script>
</head>
<body>
	<div class="pop-tit">入职员工报表</div>
	<form action="<%=basePath%>servlet/Action?method=allentmagazi"
		method="post" name="fom10" id="fom10" autocompelete="on">
		<div class="month clearfix">
			<label for="" class="date fl">开始日期</label> 
			<input type="month"
				name="starttime" class="add fl">
				<label for="" class="date fl">结束日期</label>
			<input type="month" name="endtime" class="add fl"> 
			<input
				type="submit" value="查询" class="search2 fl">
		</div>
	</form>
</body>
</html>