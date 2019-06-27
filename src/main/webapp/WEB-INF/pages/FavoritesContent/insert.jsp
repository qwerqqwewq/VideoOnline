<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加视频</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/favoritescontent/insert.do" method="post">
    <div>视频名称</div><input name="vid" /><br>
    <div>视频备注</div><input name="remark"/><br>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>
