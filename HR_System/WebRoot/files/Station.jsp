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
	<script type="text/javascript">
		function action1(a){			  				
			window.location.href="<%=basePath%>servlet/Action?postid="+a+"&method=changepostsingle";						
		}
		function action2(a){			  				
			window.location.href="<%=basePath%>servlet/Action?postname="+a+"&method=delpostsingle";						
		}
	
	</script>	
</head>
<body> 
    <div class="header clearfix">
          <a href="<%=basePath%>servlet/Action?method=toaddpost" class="search fl">创建新岗位</a>  
          <a href="<%=basePath%>servlet/Action?method=torefpost" class="add fr" id="add-class">查询岗位员工</a> 
    </div>  
	<table class="tableshow" id="tableshow">
	    <thead class="even">
			<td>岗位编号</td>
			<td>岗位名称</td>
			<td>岗位类型</td>
			<td><i class="fa fa-pencil-square-o fa-fw" aria-hidden="true"></i>修改</td>
			<td><i class="fa fa-trash fa-fw" aria-hidden="true"></i>删除</td>
		</thead>
		<c:forEach items="${findallp}" var="findallp">
        <tbody>
			<tr>
				<td>${findallp.postid}</td>
				<td>
                    ${findallp.postname}
                </td>
				<td>
	                ${findallp.posttype}
	            </td>
	            <td>
	             <input type="button" name="button1"
					value="修改" onClick="action1(${findallp.postid})"/>
	            </td>
	            <td>
	             <input type="button" name="button2"
	             <%
	             String b = "'";
	              %>
					value="删除" onClick="var c = <%=b%>${findalld.postname}<%=b%>;action2(c)"/>
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