<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/13
  Time: 22:26
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
        <li ><a href="loginviews/login-student.jsp">选课</a></li>
        <li ><a href="/getAllSelectRes">查看选课结果</a></li>
        <li class="active"><a href="#">退选</a></li>
        <li><a href="/getStudentInfo">管理个人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]}&nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">退选课程</h3>
</div>

<br><br>

<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>课程名</td>
            <td>退选</td>
        </tr>

        <c:forEach items="${sessionScope.getDeleMessagemap['GetDeleCname']}" var="cname">
            <tr>
                <td>${cname}</td>
                <td>
                    <form action="/DeleCourseDec" method="post">
                        <input type="hidden" name="sid" value="${sessionScope.map["login-username"]}">
                        <input type="hidden" name="cname" value="${cname}">
                        <input type="submit" value="退选" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<br>

<div class="container">
    当前 ${sessionScope.getDeleMessagemap["getdelMess-nowPage"]} 页 , 总 ${sessionScope.getDeleMessagemap["getdelMess-pages"]} 页 , 总 ${sessionScope.getDeleMessagemap["getdelMess-pageSize"]} 条记录.
</div>


</body>
</html>
