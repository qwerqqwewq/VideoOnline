<%@ page contentType="text/html;charset=UTF-8" language="java"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <center>
        <form action="${pageContext.request.contextPath}/user/login.do" method="post">
            用户名：<input name="name" type="text"/>
            密码：<input name="pwd" type="password"/>
            <br>
            <input type="radio" name="power" value="普通用户">普通用户
            <input type="radio" name="power" value="管理员">管理员
            </br>
        </form>
    </center>
</body>
</html>
