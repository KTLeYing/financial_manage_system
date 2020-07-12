<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/7/7
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> -->
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%= basePath%>">

    <%--图标--%>
    <link rel="shortcut icon" href="/images/m1.png">

    <title>后台登录页面</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <!-- jquery文件，务必在bootstrap.min.js之前引入 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <!-- 引入自定义样式 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/index.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/index.js">

    </script>
</head>

<body>
<!-- bootstrap布局容器    固定宽度  1170px  -->
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-xs-10 col-xs-offset-1">
            <!-- 登录主体框 -->
            <div class="main-box" style="background: rgba(255, 255, 255, 0.6)">
                <h2 style="text-align: center; font-weight: bold">后台管理</h2>
                <hr />
                <h3>管理员登录</h3>
                <form
                        action="${pageContext.request.contextPath}/userManage/login.action "
                        id="myform" method="post">
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
                                   name="adminname" id="adminname">
                        </div>
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock" id="icon"></span>
                            </div>
                            <input type="password" class="form-control" placeholder="请输入密码"
                                   name="password" id="password">
                        </div>
                        <label id="passwordLabel"></label>
                    </div>

                    <!-- 输入框组 -->
                    <div class="form-group">
                        <input type="submit" value="登录"
                               class="btn btn-primary btn-block loginbtn" id="loginbtn">
                    </div>
                </form>
            </div>
            <!-- col-md-4 -->
        </div>
        <!-- row -->


    </div>
    <!--main-box  -->
</div>
<!-- container -->


</body>
</html>
