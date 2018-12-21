<%--
  Created by IntelliJ IDEA.
  User: Yogurt.Yuan
  Date: 2018/12/17
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html lang="en" class="no-js">
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS -->
    <link rel="stylesheet" href="<%=basePath%>assets/css/reset.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/supersized.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/style.css">
</head>

<body>
<input id="basePath" type="hidden" value="<%=basePath%>" />
<div class="page-container">
    <h1>登录</h1>
    <form action="/user/login" method="post">
        <input type="text" id="telephone" name="telephone" class="telephone"
               placeholder="请输入手机号" pattern="^1(3|4|5|7|8)\d{9}$" required="required">
        <input type="password" id="password" name="password" class="password"
               pattern="[A-Za-z0-9]{6,12}" required="required" placeholder="请输入密码">
        <button type="submit">登录</button>
        <div id="login-error" style="color: #F00">${requestScope.message}</div>
        <input type="button" value="注册" onclick="location.href='/user/goRegister'">
    </form>
</div>

<!-- Javascript -->
<script src="<%=basePath%>assets/js/jquery-1.8.2.min.js"></script>
<script src="<%=basePath%>assets/js/supersized.3.2.7.min.js"></script>
<script src="<%=basePath%>assets/js/supersized-init.js"></script>
<script src="<%=basePath%>assets/js/scripts.js"></script>

</body>

</html>