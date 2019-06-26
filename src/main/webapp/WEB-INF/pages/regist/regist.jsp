<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regist" method="post">
    <div>用户名</div><input name="name" /><br>
    <div>密码</div><input name="pwd"><br>
    <div>确认密码</div><input name="tpwd"><br>
    <div><input type="submit" value="提交"></div>
</body>
</html>
