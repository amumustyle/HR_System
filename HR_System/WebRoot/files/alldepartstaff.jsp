<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <div class="header clearfix">
       <!--   <a href="addDepart.jsp" class="search fl">创建新部门</a>  
        <a href="refDepart.jsp" class="add fr" id="add-class">查询部门员工</a> -->
    </div>  
	<table class="tableshow" id="tableshow">
	    <thead class="even">
			<td>员工号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>出生日期</td>
            <td>身份证号</td>
            <td>部门</td>
            <td>岗位</td>
            <td>入职日期</td>
            <td>参加工作日期</td>
            <td>形式</td>
            <td>来源</td>
		</thead>
		<c:forEach items="${alldepartstaffshow}" var="alldepartstaffshow">
        <tbody>
			<tr>
				<td>
					${alldepartstaffshow.empid}
				</td>
				<td>
                    ${alldepartstaffshow.empname}
                </td>
				<td>
	                ${alldepartstaffshow.empsex}
	            </td>
	            <td>
	                ${alldepartstaffshow.empbirth}
	            </td>
	            <td>
	                ${alldepartstaffshow.empidcard}
	            </td>
	            <td>
					${alldepartstaffshow.empdepart}
				</td>
				<td>
					${alldepartstaffshow.emppost}
				</td>
				<td>
					${alldepartstaffshow.empindate}
				</td>
				<td>
					${alldepartstaffshow.empinwork}
				</td>
				<td>
					${alldepartstaffshow.emptype}
				</td>
				<td>
					${alldepartstaffshow.empfrom}
				</td>
			</tr>
		</tbody>
		</c:forEach>
   <!--     <div class="page">
            当前第1页/共10页
                <a href="__URL__/mod/pageNow/{$pageNow+1}">下一页</a>
                <a href="__URL__/mod/pageNow/{$pageCount}">尾页</a>
        </div>-->  
    </table>
</body>
</html>