<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <!-- meta data -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!--font-family-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext" rel="stylesheet">

    <!-- title of site -->
    <title>注册界面</title>

    <!-- For favicon png -->
    <link rel="shortcut icon" type="image/icon" href="${pageContext.request.contextPath}/img/demo-1-bg.jpg"/>

    <!--font-awesome.min.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">

    <!--animate.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">

    <!--bootstrap.min.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

    <!-- bootsnav -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootsnav.css" >

    <!--style.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <!--responsive.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<section class="signin signup popup-in">
    <div class="container">
        <div class="sign-content popup-in-content">
            <div class="popup-in-txt">
                <h2>注册界面</h2>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">
                            <form action="${pageContext.request.contextPath}/user/regist.do" method="post">
                                <div class="form-col">
                                    <div class="form-group">
                                        <label for="signin_form">用户名</label>
                                        <input name="name" class="form-control" type="text" placeholder="请输入用户名">
                                    </div>
                                </div>
                                <div class="form-coll">
                                    <div class="form-group">
                                        <label for="signin_form"></label>
                                        <input readonly="readonly" value="只能为普通用户哦">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="signin_form">密码</label>
                                    <input name="pwd" class="form-control" type="password" placeholder="请输入密码">
                                </div>
                                <div class="form-group">
                                    <label for="signin_form">密码确认</label>
                                    <input name="tpwd" class="form-control" type="password" placeholder="请再次输入密码">
                                </div>
                            </form>


                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="signin-footer">
                                        <a href="javascript:onClick=subbtn2()">确认</a>
                                        <a href="${pageContext.request.contextPath}/user/login">返回</a>
                                    </div><!--/.signin-footer -->
                                </div><!--/.col-->
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--footer copyright start -->
<footer class="footer-copyright">
    <div id="scroll-Top">
        <i class="fa fa-angle-double-up return-to-top" id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
    </div><!--/.scroll-Top-->

</footer><!--/.hm-footer-copyright-->
<script src="assets/js/jquery.js"></script>

<!--modernizr.min.js-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

<!--bootstrap.min.js-->
<script src="assets/js/bootstrap.min.js"></script>

<!-- bootsnav js -->
<script src="assets/js/bootsnav.js"></script>

<!-- jquery.sticky.js -->
<script src="assets/js/jquery.sticky.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>


<!--Custom JS-->
<script src="assets/js/custom.js"></script>
<script language="javascript" type="text/javascript">
    function subbtn2()
    {
        document.r.submit();

    }

</script>

</body>
</html>
