<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频列表</title>
</head>
<body>
<c:forEach items="${videos}" var="video" varStatus="vs">
    <li>${vs.count}
        <div>视频标题  ${video.title}</div><br>
        <div>封面路径  ${video.picPath}</div><br>
        <div>视频路径  ${video.videoPath}</div><br>
        <div>视频时长  ${video.videoTime}</div><br>
        <div>视频简介  ${video.intro}</div><br>
        <div>上传时间  ${video.uploadDate}</div><br>
        <div>视频类型  ${video.type.type}</div>
    </li><br>

</c:forEach>
</body>
</html>
