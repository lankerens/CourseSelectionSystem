<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/16
  Time: 20:19
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
        <li><a href="/getBaseInfoByAdmin">学生管理</a></li>
        <li><a href="/getTeacherByAdmin">教师管理</a></li>
        <li><a href="/getCourseInfoByAdmin">课程管理</a></li>
        <li><a href="admin-addStudent.jsp">添加学生</a></li>
        <li class="active"><a href="admin-addTeacher.jsp">添加教师</a></li>
        <li><a href="admin-addCourse.jsp">添加课程</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]} 老师 &nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">添加教师</h3>
</div>

<br><br>


<div class="container" style="color:red;">
    ${sessionScope.addTeacherMessgae}
        <%
            session.removeAttribute("addTeacherMessgae");
        %>
</div>


<form action="/addTeacherByAdmin" method="post">


<div class="input-group container">

    <span class="input-group-addon">工号 &nbsp;&nbsp;</span>
    <input name="tid" type="text" class="form-control"  style="width: 40%" placeholder="必填" />

</div>
<br>

<div class="input-group container">

    <span class="input-group-addon">姓名 &nbsp;&nbsp;</span>
    <input name="tname" type="text" class="form-control"  style="width: 40%" placeholder="必填"/>

</div>
<br>
<div class="input-group container">

    <span class="input-group-addon">密码 </span>
    <input name="tpassword" type="text" class="form-control"  style="width: 40%"placeholder="必填"/>

</div><br>
<div class="input-group container">

    <span class="input-group-addon">性别 &nbsp;&nbsp;</span>
    <input name="tsex" type="text" class="form-control"  style="width: 40%" placeholder="男 / 女"/>

</div><br>
<div class="input-group container">

    <span class="input-group-addon">简介 &nbsp;&nbsp;</span>
    <input name="introduction" type="text" class="form-control" style="width: 40%"/>

</div><br>

<br><br>
<div class="container">

    <input type="submit" value="添加" />
</div>

</form>

<br>
</body>
</html>
