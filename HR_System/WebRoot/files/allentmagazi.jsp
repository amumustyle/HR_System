<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="header clearfix">
		<!--   <a href="addDepart.jsp" class="search fl">创建新部门</a>  
        <a href="refDepart.jsp" class="add fr" id="add-class">查询部门员工</a> -->
	</div>

	<table class="tableshow" id="tableshow">
		<thead class="even">
			<td>序号</td>
			<td>部门名称</td>
			<td>岗位名称</td>
			<td>姓名</td>
			<td>性别</td>
			<td>入职日期</td> 
			</thead>
			<c:forEach items="${instaffshow}" var="instaffshow">
			<tbody>
				<tr>
					<td>${instaffshow.empid}</td>
					<td>${instaffshow.empdepart}</td>
					<td>${instaffshow.emppost}</td>
					<td>${instaffshow.empname}</td>
					<td>${instaffshow.empsex}</td>
					<td>${instaffshow.empindate}</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>
