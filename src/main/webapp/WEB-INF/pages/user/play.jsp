<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

权限${sessionScope.user.power.power}
用户id ${sessionScope.user.id}

<li>视频界面
    <div>视频标题  ${video.title}</div><br>
    <div>视频封面  </div><img src="${pageContext.request.contextPath}/${video.picPath}"/>
    <div>视频封面  ${video.videoPath}</div><br>
    <div>视频时长  ${video.videoTime}</div>
    <div>视频简介  ${video.intro}</div><br>
    <div>上传时间  ${video.uploadDate}</div>
    <div>视频类型  ${video.type.type}</div>
</li><br>



<td style="text-align: center">
    <div id="box">
        <video id="video" controls preload="auto" width="300" height="200">
            <source src="${pageContext.request.contextPath}/${video.videoPath}" type="video/mp4">
        </video>
    </div>
</td>

<li>视频评论
    <c:forEach items="${videoComments}" var="comment">
        <div>用户名：${comment.user.name}</div>
        <div>评论时间${comment.commentDate}</div><br>
        <div>评论了：  ${comment.content}</div>
        <c:if test="${comment.user.id}==${sessionScope.user.id}" >
            <a href="${pageContext.request.contextPath}/videoComment/update.do?id=${comment.id}">删除</a>
        </c:if>
    </c:forEach>
</li><br>

<%--发出我的评论--%>
<form action="${pageContext.request.contextPath}/videoComment/insert.do">
    我的评论
    评论内容<input name="content">
    <input type="submit" value="提交">
    <input name="vid" value="${video.id}" type="hidden">
</form>

</body>
</html>
