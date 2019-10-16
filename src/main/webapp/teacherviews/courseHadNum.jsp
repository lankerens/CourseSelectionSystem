<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/15
  Time: 19:20
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
        <li ><a href="login-teacher.jsp">添加教学课程</a></li>
        <li ><a href="/getTeachManagerMessage">管理教学课程</a></li>
        <li class="active"><a href="#">查看选课名单</a></li>
        <li><a href="/getTeacherInfoMessage">管理本人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]} 老师 &nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">查看选课总览</h3>
</div>
<br><br>

<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>课程名</td>
            <td>总人数</td>
            <td>已报名人数</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${sessionScope.courseAps}" var="courseAps">
        <tr>
                <td>${courseAps.cname}</td>
                <td>${courseAps.totalnum}</td>
                <td>${courseAps.hadNum}</td>
                <td>
                    <form action="/getStudentwhoSelect" method="post">
                        <input type="hidden" name="cname" value="${courseAps.cname}">
                        <input type="submit" value="查看名单" />
                    </form>
                </td>
        </tr>
        </c:forEach>

    </table>
</div>

<div class="container">
    当前 ${sessionScope.getCourseNumMap["getCourseHad-nowPage"]} 页 ,
    总 ${sessionScope.getCourseNumMap["getCourseHad-pages"]} 页 ,
    总 ${sessionScope.getCourseNumMap["getCourseHad-pageSize"]} 条记录.
</div>

</body>
</html>
