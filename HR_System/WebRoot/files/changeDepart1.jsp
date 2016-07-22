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
    <div class="header clearfix">
        <a href="" class="search fl">创建新部门</a>
        <a href="addDepart.html" class="add fr" id="add-class">查询部门员工</a>
    </div>     
    <span class="notice">提示：请在下面选择要修改的部门</span>
	<table class="tableshow" id="tableshow">
	    <thead class="even">
			<td>编号</td>
			<td>名称</td>
			<td>类型</td>
			<td><i class="fa fa-phone fa-fw" aria-hidden="true"></i>电话</td>
			<td>成立时间</td>
			<td><i class="fa fa-pencil-square-o fa-fw" aria-hidden="true"></i>修改</td>
			<td><i class="fa fa-trash fa-fw" aria-hidden="true"></i>删除</td>
		</thead>
        <tbody>
			<tr>
				<td>1</td>
				<td>
                    <a href="">人力资源部</a>
                </td>
				<td>
	                管理
	            </td>
	            <td>
	                18842629353
	            </td>
	            <td>
	                时间
	            </td>
	            <td>
	                <a href="files/changeDepart.jsp">修改</a>
	            </td>
	            <td>
	                <a href="files/delDepart.jsp">删除</a>

	            </td>
			</tr>
		</tbody>
        <div class="page">
            当前第1页/共10页
                <a href="__URL__/mod/pageNow/{$pageNow+1}">下一页</a>
                <a href="__URL__/mod/pageNow/{$pageCount}">尾页</a>
        </div>
    </table>
</body>
</html>