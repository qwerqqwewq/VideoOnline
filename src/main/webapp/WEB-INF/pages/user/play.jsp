<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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

</body>
</html>
