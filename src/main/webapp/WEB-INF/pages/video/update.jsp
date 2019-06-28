<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <li>
        <div>视频标题  ${video.title}</div><br>
        <div>封面路径  ${video.picPath}</div><br>
        <div>视频路径  ${video.videoPath}</div><br>
        <div>视频时长  ${video.videoTime}</div><br>
        <div>视频简介  ${video.intro}</div><br>
        <div>上传时间  ${video.uploadDate}</div><br>
        <div>视频类型  ${video.type.type}</div>
    </li><br>

    <form action="${pageContext.request.contextPath}/video/update.do/${video.id}">
        视频标题
        <input name="title" value="${video.title}"/><br>
        封面路径
        <input value="${video.picPath}" readonly="readonly"/><br>
        视频路径
        <input value="${video.videoPath}" readonly="readonly"/><br>
        视频时长
        <input value="${video.videoTime}" readonly="readonly"/><br>
        视频简介
        <input name="intro" value="${video.intro}"/><br>
        上传时间
        <input value="${video.uploadDate}" readonly="readonly"/><br>
        视频类型
        <div>
            <c:forEach items="${types}" var="type">
                ${type.type}  <input type="radio" name="typeId" value="${type.id}"
                    <c:if test="${type.id==video.type.id}">
                        checked="checked"
                    </c:if>
                    /><br>
            </c:forEach>
        </div>
        <input type="submit" value="确认修改">
    </form>
    <form action="${pageContext.request.contextPath}/video/remove.do/${video.id}">
        <input type="submit" value="删除该视频">
    </form>
</body>
</html>
