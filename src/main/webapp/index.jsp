<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/10
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
        <meta charset="UTF-8">
        <title>学生在线选课系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <script src="jQuery/jquery-3.4.1.min.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


    <!-- 把按钮美化了一下 -->
    <style>
        input{
            border:1px solid #4cae4c;
            background-color:transparent;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-body">
            <h2 class="card-title" style="text-align: center; color: #2b669a" >学生信息管理系统</h2>
        </div>
    </div>

    <!-- 中间的图片层 -->
   <div style="text-align: center">
       <img src="pic/login.png">
   </div>
    <br>

    <div style="color: red ; text-align: center">${sessionScope.map["message"]}</div>

    <br>
    <div style="text-align: center">
        <h4 style="text-align: left; color: #2b669a">账号信息</h4>
        <form action="logincontroller" method="post" >
            <div  class="input-group">
                <span class="input-group-addon">登录名</span>
                <input name="username" type="text" class="form-control" value="${sessionScope.map["oldUserName"]}" />
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">密码 &nbsp;&nbsp;</span>
                <input name="password" type="password" class="form-control"/>
            </div>
            <br>
            <h4 style="text-align: left; color: #2b669a">角色信息</h4>
            <div>
                <input type="radio" name="loginpeople" value="0" checked >学生
                <input type="radio" name="loginpeople" value="1">教师
                <input type="radio" name="loginpeople" value="2">管理员
            </div>

            <input type="submit" value="登录" />

        </form>

    </div>

</div>






</body>
</html>
