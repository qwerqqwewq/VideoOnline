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
        <div>封面路径  ${video.picPath}</div><img src="${pageContext.request.contextPath}/${video.picPath}"/><br>
        <div>视频封面  ${video.videoPath}</div>
        <div>视频时长  ${video.videoTime}</div>
        <div>视频简介  ${video.intro}</div><br>
        <div>上传时间  ${video.uploadDate}</div>
        <div>视频类型  ${video.type.type}</div><br>
        <div><a href="${pageContext.request.contextPath}/play/${video.id}">查看详情</a> </div>
    </li><br>

</c:forEach>
</body>
</html>
