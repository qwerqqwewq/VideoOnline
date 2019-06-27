<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏夹中的视频列表</title>
</head>
<body>
<c:forEach items="${favorites}" var="favorites" varStatus="status">
    <li>${status.count}
    <div>视频标题  ${video.title}</div><br> <a href="delete.jsp?id=xxx" onclick="return confirm('确认删除？！')">删除</a>
    <div>视频时长  ${video.videoTime}</div><br> <a href="delete.jsp?id=xxx" onclick="return confirm('确认删除？！')">删除</a>
    <div>视频标注  ${favoritescontent.remark}</div><br> <a href="delete.jsp?id=xxx" onclick="return confirm('确认删除？！')">删除</a>
    <div>收藏时间  ${favoritescontent.inserDate}</div><br> <a href="delete.jsp?id=xxx" onclick="return confirm('确认删除？！')">删除</a>
    <div>视频类型  ${video.type.type}</div> <a href="delete.jsp?id=xxx" onclick="return confirm('确认删除？！')">删除</a>
    </li><br>
</c:forEach>

</body>
</html>
