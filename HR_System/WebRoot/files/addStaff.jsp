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
    <div class="pop-tit">添加新员工</div>
    <form action="<%=basePath%>servlet/Action?method=addemp" method="post" name="fom1" id="fom1" autocompelete="on">
        <div class="adddep">
            <p>
                <label for="add-num">员工号</label>
                <input type="text" name="addnum" id="add-num" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-name">姓名</label>
                <input type="text" name="addname" id="add-name" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-sort">性别</label>
                <select name="addsex" id="add-sort" class="dinfor">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </P>
            <p>
                <label for="add-date">出生日期</label>
                <input type="date" name="addbirth" id="add-date" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-num1">身份证号</label>
                <input type="text" name="addidcard" id="add-num1" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-name1">部门</label>
                <input type="text" name="adddepart" id="add-name1" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-name2">岗位</label>
                <input type="text" name="addpost" id="add-name2" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-time1">入职日期</label>
                <input type="date" name="addindate" id="add-time1" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-time2">工作日期</label>
                <input type="date" name="addinwork" id="add-time2" required="required" class="dinfor">
            <br /><span></span>
            </p>
            <p>
                <label for="add-name">形式</label>
                <select name="addtype" id="add-sort" class="dinfor">
                    <option value="正式工">正式工</option>
                    <option value="临时工">临时工</option>
                </select>
            </p>
            <p>
                <label for="add-name">来源</label>
                <select name="addfrom" id="add-sort" class="dinfor">
                    <option value="校园">校园</option>
                    <option value="社会">社会</option>
                </select>
            </p>
            <input type="submit" value="添加" class="sub-btn fl" id="check">
            <div class="back-btn"><a href="<%=basePath%>servlet/Action?method=toindex">返回</a></div>
        </div>
    </form>
       <script src="../js/check2.js"></script>
</body>
</html>
    