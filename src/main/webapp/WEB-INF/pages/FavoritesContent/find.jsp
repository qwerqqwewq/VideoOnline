<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏夹中的视频列表</title>
</head>
<body>
<from items="${favorites}" var="video" varStatus="vs">
    <li>${vs.count}
    <div>视频标题  ${video.title}</div><br>
    <div>视频时长  ${video.videoTime}</div><br>
    <div>视频标注  ${favoritescontent.remark}</div><br>
    <div>收藏时间  ${favoritescontent.inserDate}</div><br>
    <div>视频类型  ${video.type.type}</div>
    </li><br>
</from>
</body>
</html>
