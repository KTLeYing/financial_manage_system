<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/6/5
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <%--图标--%>
    <link rel="shortcut icon" href="/images/m1.png">

    <title>注册页面</title>
    <!-- 屏幕和设备的屏幕一致，初始缩放为1:1，进制用户缩放 -->
    <meta name="viewport"
          content="width=device-width,initial-scale=1,user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <!-- 引入外部的bootstrap中的css文件 -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <!-- jquery文件，务必在bootstrap.min.js之前引入 -->
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <!-- 引入自定义样式 -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/regist.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/regist.js">

    </script>

   <%-- <script type="text/javascript">
        function eamilCode() {
            var email = $("#email").val();
            $.post("${pageContext.request.contextPath}/emailCode.action", {email: email}, function () {

                }, "json");
        }
    </script>--%>

</head>

<body>
<!-- bootstrap布局容器    固定宽度  1170px  -->
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
            <!-- 注册主体框 -->
            <div class="main-box" style="background: rgba(255, 255, 255, 0.6)">
                <img class="img-responsive" alt="财务管理系统"
                     src="/images/regist.jpg" id="logo">
                <hr />
                <h3>注册</h3>
                <!-- 访问路径     "${pageContext.request.contextPath}/user/regist.action"  -->
                <form
                        action="${pageContext.request.contextPath}/user/regist.action"
                        id="myform" method="post">
                    <!-- 输入框组 -->
                    <!-- 用户名或者密码输入错误，请重新输入 -->
                    <div>
                        <label id="msgLabel">${msg }</label>
                    </div>
                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-user" id="icon"></span>
                            </div>
                            <input type="text" class="form-control" placeholder="请输入用户名"
                                   name="username" id="username" required="required" value="${user.username }">
                        </div>
                    </div>


                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock" id="icon"></span>
                            </div>
                            <input type="password" class="form-control" placeholder="请输入密码"
                                   name="password" id="password" required="required" value="${user.password }">
                        </div>
                        <!-- 						<label id="passwordLabel"></label> -->
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-ok" id="icon"></span>
                            </div>
                            <input type="password" class="form-control"
                                   placeholder="请再次输入密码" name="repassword" id="repassword"
                                   required="required" value="${repassword}">
                        </div>
                        <!-- 						<label id="passwordLabel"></label> -->
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-envelope" id="icon"></span>
                            </div>
                            <input type="email" class="form-control" placeholder="请输入邮箱"
                                   name="email" id="email" required="required" value="${user.email }">
                        </div>
                        <!-- 						<label id="passwordLabel"></label> -->
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-earphone" id="icon"></span>
                            </div>
                            <input type="text" class="form-control" placeholder="请输入手机号"
                                   name="phone" id="phone" required="required" value="${user.phone }">
                        </div>
                        <!-- 						<label id="passwordLabel"></label> -->
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <label id="sexLabel">性别</label>

                        <c:if test="${sex==null}">
                            <label class="radio-inline">
                                <input type="radio" class="sexradio" name="sex" value="男" checked="checked" >男
                            </label>
                            <span class="rightradio">
									<label class="radio-inline">
										<input type="radio" class="sexradio" name="sex" value="女">女
									</label>
								</span>
                        </c:if>

                        <c:if test="${sex!=null}">
                            <label class="radio-inline">
                                <input type="radio" class="sexradio" name="sex" value="男"
                                <c:if test="${sex=='男'}"> checked="checked"</c:if>
                                >男
                            </label>
                            <span class="rightradio">
									<label class="radio-inline">
										<input type="radio" class="sexradio" name="sex" value="女"
                                        <c:if test="${sex=='女'}"> checked="checked"</c:if>
                                        >女
									</label>
								</span>
                        </c:if>
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-barcode" id="icon"></span>
                            </div>
                            <input type="emailCode" class="form-control" placeholder="请输入邮箱验证码"
                                   name="emailCode" id="emailCode" required="required" style="float: left; width: 62%">
                            <input type="button" name="codebtn" id="codebtn" value="获取验证码" style="float: right; width: 35%;
                            height: 40px" onclick="eamilCode();">
<%--                            <button type="button" name="codebtn" id="codebtn" style="float: right; width: 35%; height: 40px">获取验证码</button>--%>
                        </div>
                        <!-- 						<label id="passwordLabel"></label> -->
                    </div>

                    <%--隐藏提示框--%>
                    <div id="disappare" style="display: none">
                        <p style="vertical-align: middle; line-height: 40px">验证码发送成功</p>
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <input type="submit" value="注册"
                               class="btn btn-primary  registbtn" id="registbtn">
                        <input type="reset" value="重置"
                               class="btn btn-primary  resetbtn" id="resetbtn">
                    </div>


                    <!-- 输入框组 -->
                    <div class="form-group a">
                        <a class="" href="${pageContext.request.contextPath}/index.jsp">已有账号，去登陆</a>
                    </div>

                </form>

            </div>
            <!-- main-box -->
        </div>
        <!-- col-md-4  -->
    </div>
    <!-- row -->
</div>
<!-- container -->
</body>
</html>
