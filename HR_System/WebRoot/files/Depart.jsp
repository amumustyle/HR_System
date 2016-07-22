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
			window.location.href="<%=basePath%>servlet/Action?departid="+a+"&method=changedepartsingle";						
		}
		
		function action2(b){
			window.location.href="<%=basePath%>servlet/Action?departname="+b+"&method=deldepartsingle";						
		}
	</script>
	
</head>
<body> 
    <div class="header clearfix">
          <a href="<%=basePath%>servlet/Action?method=toadddepart" class="search fl">创建新部门</a>  
          <a href="<%=basePath%>servlet/Action?method=torefdepart" class="add fr" id="add-class">查询部门员工</a> 
    </div>  
	<table class="tableshow" id="tableshow">
	    <thead class="even">
			<td>部门编号</td>
			<td>部门名称</td>
			<td>部门类型</td>
			<td><i class="fa fa-phone fa-fw" aria-hidden="true"></i>电话</td>
			<td><i class="fa fa-calendar fa-fw" aria-hidden="true"></i>成立时间</td>
			<td><i class="fa fa-pencil-square-o fa-fw" aria-hidden="true"></i>修改</td>
			<td><i class="fa fa-trash fa-fw" aria-hidden="true"></i>删除</td>
		</thead>
		<c:forEach items="${findalld}" var="findalld">
        <tbody>
			<tr>
				<td>
					${findalld.departid}
				</td>
				<td>
                    ${findalld.departname}
                </td>
				<td>
	                ${findalld.departtype}
	            </td>
	            <td>
	                ${findalld.departtel}
	            </td>
	            <td>
	                ${findalld.departst}
	            </td>
	             <td>
	             <input type="button" name="button1"
					value="修改" onClick="action1(${findalld.departid})"/>
	            </td>
	             <td>
	             
	             <input type="button" name="button2"
	             <%
	             String b = "'";
	              %>
					value="删除"  onClick=" var c = <%=b%>${findalld.departname}<%=b%>;action2(c)"/>
	            </td>
	           
	          <!--    <td>
	             <input type="button" name="button2"
					value="删除" onClick="servlet/Action?departname=${findalld.departname}&method=deldepartsingle"/>
	            </td>
	         -->
	          
			</tr>
		</tbody>
		</c:forEach>
   <!-- <div class="page">
            	当前第1页/共10页
              	 	 <a href="__URL__/mod/pageNow/{$pageNow+1}">下一页</a>
               	 	 <a href="__URL__/mod/pageNow/{$pageCount}">尾页</a>
        </div>-->  
    </table>
</body>
</html>