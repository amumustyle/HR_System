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
    <div class="pop-tit">创建新岗位</div>
    <form action="<%=basePath%>servlet/Action?method=addpost" method="post" name="fom4" id="fom4" autocompelete="on">
        <div class="adddep">
            <p>
                <label for="add-num">岗位编号</label>
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
                <select name="addsort" id="add-sort" class="dinfor">
                    <option value="技术">技术</option>
                    <option value="管理">管理</option>
                    <option value="营销">营销</option>
                    <option value="市场">市场</option>
                </select>
            </P>
            <input type="submit" value="添加" class="sub-btn fl" id="check">
            <div class="back-btn"><a href="<%=basePath%>servlet/Action?method=toindex">返回</a></div>
        </div>
    </form>
    <script src="../js/check1.js"></script>
</body>
</html>