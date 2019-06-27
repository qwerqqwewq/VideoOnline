<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询收藏夹</title>
</head>
<body>
    <c:forEach items="${favorites}" var="favorites" varStatus="vs">
        <li>${vs.count}
            <div>收藏夹名称  ${favorites.name}</div><br>
            <div>收藏夹用户id  ${favorites.uid}</div><br>
            <div>收藏夹创建日期  ${favorites.createDate}</div><br>
            <div>备注  ${favorites.remark}</div><br>
        </li><br>

    </c:forEach>
</body>
</html>
