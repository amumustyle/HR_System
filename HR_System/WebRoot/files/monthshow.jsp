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
    
</head>
<body>
    <div class="pop-tit">查询月份报表</div>
    
    <table class="tableshow" id="tableshow">
        <thead class="even">
            <tr>
                <td rowspan="2">部门名称</td>
                <td colspan="6">人数统计</td>
            </tr>
            <tr>
                <td>月初人数</td>
                <td>月末人数</td>
                <td>本月入职</td>
                <td>本月离职</td>
            </tr>
        </thead>
        <c:forEach items="${hrmonth}" var="hrmonth">
        <tbody class="even">
            <tr>
                <td>${hrmonth.departname}</td>
                <td>
                    ${hrmonth.startnum}
                </td>
                <td>
                    ${hrmonth.endnum}
                </td>
                <td>
                    ${hrmonth.innum}
                </td>
                <td>
                    ${hrmonth.outnum}
                </td>
            </tr>
            
        </tbody>
        </c:forEach>
    </table>
</body>
</html>