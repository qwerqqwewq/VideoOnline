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
            <div><input type="submit" value="提交"></div>
        </form>
    </center>
</body>
</html>
