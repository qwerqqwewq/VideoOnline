<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.request.contextPath}/js/html5media.min.js"></script>
    <style type="text/css">
        <!--
        a:link {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
        }
        a:visited {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
        }
        a:hover {
            font-size: 12px;
            color: #999999;
            text-decoration: underline;
        }
        -->
    </style>
</head>
<body>
<c:if test="${path!=null}">
<video id="video" controls preload="auto" width="1000" height="500">
    <source src="${pageContext.request.contextPath}/p/${path}" type="video/mp4">
</video>
<br>
</c:if>

<c:forEach items="${maps.entrySet()}" var="entry">
    <a href="${pageContext.request.contextPath}/pop/${entry.key}">${entry.value}</a><br>
</c:forEach>

</body>
</html>
