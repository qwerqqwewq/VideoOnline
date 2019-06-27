<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加收藏夹</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/favorites/update.do" method="post">
    <div>收藏夹名称</div><input name="name" /><br>
    <div>收藏夹备注</div><input name="remark"/><br>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>