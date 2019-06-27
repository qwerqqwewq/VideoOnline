<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏夹视频</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/favoritescontent/insert.do" method="post">
    <div>视频名称</div><input name="fid" /><br>
    <div>视频备注</div><input name="remark"/><br>


    <li><input name="vid" type="text"></li>

    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>
