<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/13
  Time: 21:00
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
        <li><a href="loginviews/login-student.jsp">选课</a></li>
        <li class="active"><a href="#">查看选课结果</a></li>
        <li><a href="/getDeleMessage">退选</a></li>
        <li><a href="/getStudentInfo">管理个人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]}&nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">查看选课结果</h3>
</div>

<br><br>

<div class="container">
    <table style="padding: 10px">
        <h4>提示: 没有教师安排的课程无法查询</h4>
    </table>
</div>

<!--  课程名    班级名称   上课时间   上课周   上课教室   学分    学时    任课教师  -->


<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>课程名</td>
            <td>班级名称</td>
            <td>上课时间</td>
            <td>上课周</td>
            <td>上课教室</td>
            <td>学分</td>
            <td>学时</td>
            <td>任课教师</td>
        </tr>

        <c:set var="courseHadList" value="${sessionScope.selectresmap['courseHadList']}"></c:set>
        <c:forEach var="courseHad" items="${courseHadList}">
            <tr>
                <td>${courseHad.cname}</td>
                <c:forEach var="cap" items="${courseHad.allCourseAp}">
                    <td>${cap.courseclass}</td>
                    <td>${cap.coursetime}</td>
                    <td>${cap.courseweek}</td>
                    <td>${cap.classroom}</td>
                    <td>${cap.credits}</td>
                    <td>${cap.period}</td>
                </c:forEach>
                <td>${courseHad.teacher.tname}</td>
            </tr>
        </c:forEach>

    </table>
</div>
<br>

<div class="container">
    当前 ${sessionScope.selectresmap["seleres-nowPage"]} 页 , 总 ${sessionScope.selectresmap["seleres-pages"]} 页 , 总 ${sessionScope.selectresmap["seleres-pageSize"]} 条记录.
</div>




</body>
</html>
