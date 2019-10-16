<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/12
  Time: 13:03
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
        <li class="active"><a href="login-student.jsp">选课</a></li>
        <li><a href="/getAllSelectRes">查看选课结果</a></li>
        <li><a href="/getDeleMessage">退选</a></li>
        <li><a href="/getStudentInfo">管理个人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]}&nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">选课</h3>
</div>


<br><br>

<div class="container" style="color: red">
${sessionScope.selectCourseMessage}
<%
    session.removeAttribute("selectCourseMessage");
%>
</div>

<!--  课程号   课程名   课程简介   类型   所属学院    所属专业    选择  -->

<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>课程号</td>
            <td>课程名</td>
            <td>课程简介</td>
            <td>类型</td>
            <td>所属学院</td>
            <td>所属专业</td>
            <td>选择</td>
        </tr>

        <c:set var="coursesList" value="${sessionScope.map['coursesList']}"></c:set>
        <c:forEach items="${coursesList}" var="course">

            <tr>
                <td>${course.cid}</td>
                <td>${course.cname}</td>
                <td>${course.cintroduction}</td>
                <td>${course.type}</td>
                <td>${course.belongcoll}</td>
                <td>${course.belongpro}</td>
                <td>
                    <form action="/getSelectCourse" method="post">
                        <input type="hidden" name="cid" value="${course.cid}">
                        <input type="submit" value="选择" />
                    </form>
                </td>
             </tr>
        </c:forEach>

    </table>

</div>
<br>

<div class="container">
    当前 ${sessionScope.map["index-nowPage"]} 页 , 总 ${sessionScope.map["index-pages"]} 页 , 总 ${sessionScope.map["index-pageSize"]} 条记录.
</div>



</body>
</html>
