<%@ page contentType="text/html;charset=UTF-8" language="java"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <center>
        <form action="${pageContext.request.contextPath}/user/login.do" method="post">
            用户名：<input name="name"/>
            密码：<input name="pwd"/>
            <font size="+1">
                <p><input name="submit"  type="submit" class="button"  style="width:200px; height:35px " value="登录" /></p>
                <p><font  size="-1"  color="#000099"><a href="${pageContext.request.contextPath}/user/regist">注册</a> </font> </p>
            </font>
        </form>
    </center>
</body>
</html>

