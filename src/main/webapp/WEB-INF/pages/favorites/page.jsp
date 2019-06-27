<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏夹</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/favorites/insert">添加收藏夹</a><br>
<a href="${pageContext.request.contextPath}/favorites/findByUser">根据用户查找收藏夹</a><br>
<li>输入查找id<input name="uid" type="text"></li>
<div><input type="submit" value="提交"></div>
<a href="${pageContext.request.contextPath}/favorites/update">更新收藏夹</a><br>
<a href="${pageContext.request.contextPath}/favorites/delete">删除收藏夹</a><br>
<li>输入删除id<input name="fid" type="text"></li>
<div><input type="submit" value="提交"></div>
</body>
</html>
