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
    <div class="pop-tit">修改部门</div>
    <form action="<%=basePath%>servlet/Action?method=changedepart" method="post" name="fom1" id="fom1" autocompelete="on">
        <div class="adddep">
            <p>
                <label for="add-num">部门编号</label>
                
                <input type="text" value="${changedepartsingle}" name="addnum" id="add-num" readonly="true" required="required" class="dinfor">
            </p>
            <p>
                <label for="add-name">新的名称</label>
                <input type="text" name="addname" id="add-name" required="required" class="dinfor">
            </p>
            <p>
                <label for="add-sort">新的类型</label>
                
               <!--  <input type="text" name="addsort" id="add-sort" required="required" class="dinfor">-->
                     <select name="addsort" id="add-sort" class="dinfor">
                    <option value="公司">公司</option>
                    <option value="部门">部门</option>
                </select>
               
            </P>
            <p>
                <label for="add-phone">新的电话</label>
                <input type="text" name="addphone" id="add-phone" required="required" class="dinfor">
            </p>
            <p>
                <label for="add-time">成立时间</label>
                <input type="date" name="addtime" id="add-time" required="required" class="dinfor">
            </p>
            <input type="submit" value="修改" class="sub-btn fl">
            <div class="back-btn"><a href="<%=basePath%>servlet/Action?method=toindex">返回</a></div>
        </div>
    </form>
</body>
</html>