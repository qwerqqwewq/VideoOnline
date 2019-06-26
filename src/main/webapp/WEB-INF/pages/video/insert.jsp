<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入视频</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/video/insert.do" method="post" enctype="multipart/form-data">
    <div>标题</div><input name="title" /><br>
    <div>视频路径</div><input type="file" name="v_video"><br>
    <div>视频时长</div><input name="videoTime"><br>
    <div>简介</div><input name="intro"><br>
    <div>类型</div><br>

    <c:forEach items="${types}" var="type">
        <li><input name="typeId" type="radio" value=${type.id}>${type.type}</li>
    </c:forEach>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>
