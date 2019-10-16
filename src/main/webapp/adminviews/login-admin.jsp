<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/16
  Time: 10:49
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

    <!-- 把值传入 模态框中, 回显  -->
    <script>
        $("#myModal").modal("hide");
        function Values(sid,sname,sidcard,ssex,spassword,sage,classr,profession,college) {
            $("#sid").val(sid);
            $("#sid1").val(sid);
            $("#sname").val(sname);
            $("#sidcard").val(sidcard);
            $("#ssex").val(ssex);
            $("#spassword").val(spassword);
            $("#sage").val(sage);
            $("#classr").val(classr);
            $("#profession").val(profession);
            $("#college").val(college);
        }

    </script>


</head>
<body>

<div class="container" style="background-color: pink ; width: 100%" >
    <ul class="nav nav-pills" >
        <li><h4 style="color: #2b669a">学生信息管理系统</h4></li>
        <li>&nbsp;&nbsp;&nbsp;</li>
        <li class="active"><a href="#">学生管理</a></li>
        <li><a href="/getTeacherByAdmin">教师管理</a></li>
        <li><a href="/getCourseInfoByAdmin">课程管理</a></li>
        <li><a href="admin-addStudent.jsp">添加学生</a></li>
        <li><a href="admin-addTeacher.jsp">添加教师</a></li>
        <li><a href="admin-addCourse.jsp">添加课程</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]} 老师 &nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">学生管理</h3>
</div>

<br><br>

<div class="container" style="color: red">
    ${sessionScope.updateStuInfoMessage}
    <%
        session.removeAttribute("updateStuInfoMessage");
    %>
</div>
<!--  学号  姓名  身份证  性别  密码  年龄  班级  专业  学院  修改  删除 -->

<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>身份证</td>
            <td>性别</td>
            <td>密码</td>
            <td>年龄</td>
            <td>班级</td>
            <td>专业</td>
            <td>学院</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <c:forEach items="${sessionScope.map['allStudents']}" var="allStudents">
        <tr>

            <td>${allStudents.sid}</td>
            <td>${allStudents.sname}</td>
            <td>${allStudents.sidcard}</td>
            <td>${allStudents.ssex}</td>
            <td>${allStudents.spassword}</td>
            <td>${allStudents.sage}</td>
            <td>${allStudents.classr}</td>
            <td>${allStudents.profession}</td>
            <td>${allStudents.college}</td>
            <td>


                <button class="btn btn-primary btn-sm" data-toggle="modal"
                        data-target="#myModal" onclick=Values("${allStudents.sid}","${allStudents.sname}","${allStudents.sidcard}","${allStudents.ssex}","${allStudents.spassword}","${allStudents.sage}","${allStudents.classr}","${allStudents.profession}","${allStudents.college}")>修改</button>
                <form action="/updateStuInfoByAdmin" method="post" >
                    <input type="hidden" id = "sid" name="sid" value="" >
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close"
                                            data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">修改学生信息</h4>
                                </div>

                                <div class="modal-body row col-md-12">
                                    <div class="col-md-6">
                                        <div class="form-group">

                                            <label>学号</label><br>
                                            <input name="sid1" id="sid1" value="" type="text" readonly="readonly" /><br><br>
                                            <label>姓名</label><br>
                                            <input name="sname" id="sname" value="" type="text"  />
                                            <br><br>
                                            <label>身份证</label><br>
                                            <input name="sidcard" id="sidcard" value="" type="text" readonly="readonly" /><br>
                                            <label>性别</label><br>
                                            <input type="text" id="ssex"  name="ssex" value="" /><br>
                                            <label>密码</label><br>
                                            <input type="text" name="spassword" id="spassword"  value="" />

                                        </div></div>
                                    <div class="col-md-6">
                                        <div class="form-group">

                                            <label>年龄</label><br>
                                            <input type="text" name="sage" id="sage" value="" /><br>
                                            <label>班级</label><br>
                                            <input type="text" name="classr" id="classr" value="" /><br>
                                            <label>专业</label><br>
                                            <input type="text" name="profession" id="profession" value=""/><br>
                                            <label>学院</label><br>
                                            <input type="text" name="college" id="college" value="" /><br>

                                        </div></div>
                                </div>

                                <div class="modal-footer">

                                    <button type="button" class="btn btn-default"
                                            data-dismiss="modal">关闭</button>

                                    <input type="submit" value="完成" />
                                </div>
                            </div>
                        </div>
                    </div>
                </form>


            </td>

            <!--  删除  -->

            <td>

                <form action="/deleteStuInfoByAdmin" method="post">
                    <input type="hidden" name="sid" value="${allStudents.sid}">
                    <input type="submit" value="删除" />
                </form>

            </td>

        </tr>
        </c:forEach>

    </table>
</div>

<div class="container">
    当前 ${sessionScope.map["loginadmin-nowPage"]} 页 ,
    总 ${sessionScope.map["loginadmin-pages"]} 页 ,
    总 ${sessionScope.map["loginadmin-pageSize"]} 条记录.
</div>


</body>
</html>
