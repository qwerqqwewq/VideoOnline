<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
    <!--[if IE]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/html5.js"></script>
    <![endif]-->
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regist.do" method="post">
    <div>用户名</div><input name="name" /><br>
    <div>密码</div><input name="pwd"><br>
    <div>确认密码</div><input name="tpwd"><br>
    <div><input type="submit" value="提交"></div>
</form>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎你</h3>
                <form action="${pageContext.request.contextPath}/user/regist.do" name="r" method="post" id="regist">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入用户名">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="pwd" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="password" placeholder="请输入密码">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="tpwd" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="" type="password" placeholder="请再次输入密码">
                    </div>
                    <div><a class="act-but submit" href="javascript:onClick=subbtn2()" style="color: #FFFFFF">确认</a></div>
                    <div><a class="act-but submit" href="${pageContext.request.contextPath}/user/regist" style="color: #FFFFFF">返回</a></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/TweenLite.min.js"></script>
<script type="text/javascript" src="js/EasePack.min.js"></script>
<script type="text/javascript" src="js/rAF.js"></script>
<script type="text/javascript" src="js/demo-1.js"></script>
<script language="javascript" type="text/javascript">
    function subbtn2()
    {
        document.r.submit();

    }

</script>
</body>
</html>
