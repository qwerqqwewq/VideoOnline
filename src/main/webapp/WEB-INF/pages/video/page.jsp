<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form>
    <div>标题</div><input name="title" /><br>
    <div>封面路径</div><input name="picPath"><br>
    <div>视频路径</div><input name="videoPath"><br>
    <div>视频时长</div><input name="videoTime"><br>
    <div>简介</div><input name="intro"><br>
    <div>类型</div><br>
    <c:forEach items="${types}" var="type">
    <li><input name="typeId" type="radio" value=${type.id}>${type.type}</li>
    </c:forEach>

</form>
</body>
</html>
