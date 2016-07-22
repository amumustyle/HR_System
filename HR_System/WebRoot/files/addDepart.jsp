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
    <div class="pop-tit">创建新部门</div>
    <form action="<%=basePath%>servlet/Action?method=adddepart" method="post" name="fom1" id="fom1" autocompelete="on">
        <div class="adddep">
            <p>
                <label for="add-num">部门编号</label>
                <input type="text" name="addnum" id="add-num" required="required" class="dinfor">
             <br />
                <span></span>
            </p>
            <p>
                <label for="add-name">名称</label>
                <input type="text" name="addname" id="add-name" required="required" class="dinfor">
            <br />
                <span></span>
            </p>
            <p>
                <label for="add-sort">类型</label>
                
               <!--  <input type="text" name="addsort" id="add-sort" required="required" class="dinfor">-->
                     <select name="addsort" id="add-sort" class="dinfor">
                    <option value="公司">公司</option>
                    <option value="部门">部门</option>
                </select>
               
            </P>
            <p>
                <label for="add-phone">电话</label>
                <input type="text" name="addphone" id="add-phone" required="required" class="dinfor">
             <br />
                <span></span>
            </p>
            <p>
                <label for="add-time">成立时间</label>
                <input type="date" name="addtime" id="add-time" required="required" class="dinfor">
             <br />
                <span></span>
            </p>
            <input type="submit" value="添加" class="sub-btn fl" id="check">
            <div class="back-btn"><a href="<%=basePath%>servlet/Action?method=toindex">返回</a></div>
        </div>
    </form>
    <script src="../js/check1.js"></script>
</body>
</html>