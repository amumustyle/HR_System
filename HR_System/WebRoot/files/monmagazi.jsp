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
    
</head>
<body>
    <div class="pop-tit">查询月份报表</div>
    <form action="<%=basePath%>servlet/Action?method=hryuebao" method="post" name="fom8" id="fom8" autocompelete="on">
        <div class="month clearfix">
            <label for="" class="date fl">选择月份</label>
            <input type="month" name="month1" class="add fl">
            <input type="submit" value="查询" class="search2 fl">
        </div>
    </form> 
    
</body>
</html>