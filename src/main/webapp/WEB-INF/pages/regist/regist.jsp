<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>注册界面</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!--背景-->
<div class="wel" id="background-3"></div>
<!--左右两边云-->
<div class="wel" id="box">
    <div class="box-1 lefp"></div>
    <div class="box-1">
        <div class="righp"></div>
    </div>
</div>
<!--荧光点点-->
<div class="wel" id="git"></div>
<div class="wel" id="from">
    <div class="box-2 le-2">
        <form action="${pageContext.request.contextPath}/user/regist.do" method="post">
            <div class="flrg-1">
                <h3>注册界面</h3>
                <div class="a">
                    <input name="name"  class="in-1" placeholder="您的用户名">
                </div>
                <div class="a">
                    <input name="pwd" class="in-1"  type="password" placeholder="输入密码">
                </div>
                <div class="a">
                    <input name="tpwd" class="in-1" type="password" placeholder="再次确认密码">
                </div>
                <div><a class="a" href="javascript:onClick=subbtn2()" style="color: #FFFFFF">确认</a></div>
                <div><a class="a" href="${pageContext.request.contextPath}/user/login" style="color: #FFFFFF">返回</a></div>
            </div>
        </form>
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
