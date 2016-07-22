<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <div class="pop-tit">删除岗位</div>
    <form action="<%=basePath%>servlet/Action?method=delpost" method="post" name="fom3" id="fom3" autocompelete="on">
        <input type="search" value="${delpostsingle}" name="delpostname"  class="search1 fl" placeholder="请输入要删除的岗位名称">
        <input type="submit" value="删除" class="search2 fl">
    </form>
    
</body>
</html>