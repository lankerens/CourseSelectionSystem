<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/13
  Time: 19:01
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
        <li class="active"><a href="loginviews/login-student.jsp">选课</a></li>
        <li><a href="/getAllSelectRes">查看选课结果</a></li>
        <li><a href="/getDeleMessage">退选</a></li>
        <li><a href="/getStudentInfo">管理个人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]}&nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">确认选课</h3>
</div>

<br><br>

<div class="container">

        <h2>课程名</h2>
        ${sessionScope.selectmap["Cname"]}
        <h2>任课教师</h2>
        ${sessionScope.selectmap["teacher"].tname}
        <h2>教师简介</h2>
        ${sessionScope.selectmap["teacher"].introduction}

</div>
<br>
<br>

<div class="container">
    <form action="/CourseDeci" method="post">
        <input type="hidden" name="teacher" value="${sessionScope.selectmap["teacher"].tname}">
        <input type="hidden" id="abc" name="abc" value="1" />
        <input type="hidden" name="cid" value="${sessionScope.selectmap["cid"]}" />
        <input type="hidden" name="sid" value="${sessionScope.map["login-username"]}" />
        <input type="submit" name="subtype1" value="确认选课" onclick="this.form.abc.value='1'" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="subtype2" value="取消选课" onclick="this.form.abc.value='2'" />
    </form>

</div>


</body>
</html>
