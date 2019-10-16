<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/15
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>学生信息管理系统</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css"  rel="stylesheet" >
    <script src="//cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container" style="background-color: pink ; width: 100%" >
    <ul class="nav nav-pills" >
        <li><h4 style="color: #2b669a">学生信息管理系统</h4></li>
        <li>&nbsp;&nbsp;&nbsp;</li>
        <li ><a href="../../teacherviews/login-teacher.jsp">添加教学课程</a></li>
        <li ><a href="/getTeachManagerMessage">管理教学课程</a></li>
        <li><a href="/getCoueseNumMessage">查看选课名单</a></li>
        <li class="active"><a href="#">管理本人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]} 老师 &nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">管理本人信息</h3>
</div>
<br><br>

<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>/</td>
            <td>信息</td>
            <td>介绍</td>
        </tr>
        <tr>
            <td>工号</td>
            <td>${teacherInfo.tid}</td>
            <td>教师信息唯一标识</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${teacherInfo.tname}</td>
            <td>不可修改</td>
        </tr>
        <tr>
            <td>密码</td>
            <td>******</td>
            <td>



                <button class="btn btn-primary btn-sm" data-toggle="modal"
                        data-target="#myModal" >修改</button>

                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close"
                                        data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                            </div>
                            <form action="/UpdateTpasswordByTid" method="post" >
                                <div class="modal-body">
                                    <input type="hidden" name="tid" value="${teacherInfo.tid}">
                                    原密码: <input type="password" name="pre_password" /> <br>
                                    新密码: <input type="password" name="suf_password1" /><br>
                                    再次输入新密码<input type="password" name="suf_password2" />

                                </div>

                                <div class="modal-footer">

                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">关闭</button>

                                    <input type="submit" value="提交更改" />
                                </div>
                            </form>
                        </div></div></div>


            </td>
        </tr>
        <tr>
            <td>女</td>
            <td>${teacherInfo.tsex}</td>
            <td>不可修改</td>
        </tr>
        <tr>
            <td>简介</td>
            <td>${teacherInfo.introduction}</td>
            <td>不可修改,由管理员评判</td>
        </tr>
</body>
</html>
