<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8" /> 
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <form action="<%=basePath%>servlet/Action?method=login" name="loginFrm" method="post" id="log-in">
        <div class="login">
            <h1>登陆</h1>
            <div class="lg_input">
                <p>
                    <label for="name">账&nbsp;&nbsp;&nbsp;号：</label>
                    <input class="input1" type="text" id="userName" name="userName" maxlength="6" minlength="3" placeholder="请输入用户名">
                </p>
                <p>
                    <label for="password">密&nbsp;&nbsp;&nbsp;码：</label>
                    <input class="input1" type="password" id="password" name="password" maxlength="16" minlength="6" placeholder="请输入密码">
                </p>
                <p>
                    <input type="submit" value="登陆" class="login-btn">
                </p>
            </div>
            <p class="lg_copyright">Copyright&copy;超凡</p>
        </div>
    </form>
</body>
</html>

