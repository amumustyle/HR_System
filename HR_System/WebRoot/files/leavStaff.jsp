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
    <div class="pop-tit">员工离职</div>
    <form action="<%=basePath%>servlet/Action?method=leaveemp" method="post" name="fom1" id="fom1" autocompelete="on">
        <div class="adddep">
            <p>
                <label for="add-num">员工号</label>
                <input type="text" name="leavenum" id="add-num" required="required" class="dinfor">
            </p>
            <p>
                <label for="add-name">离职日期</label>
                <input type="date" name="empoutdate" id="add-name" required="required" class="dinfor">
            </p>
            <p>
                <label for="add-sort">离职类型</label>
                <select name="empouttype" id="add-sort" class="dinfor">
                    <option value="主动辞职">主动辞职</option>
                    <option value="辞退">辞退</option>
                    <option value="退休">退休</option>
                    <option value="开除">开除</option>
                    <option value="试用期未过">试用期未过</option>
                </select>
            </P>
            <input type="submit" value="离职" class="sub-btn fl">
            <div class="back-btn"><a href="<%=basePath%>servlet/Action?method=toindex">返回</a></div>
        </div>
    </form>
</body>
</html>
    