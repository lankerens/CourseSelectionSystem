<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/16
  Time: 19:42
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
        function Valuess(cid,cname,cintroduction,type,belongcoll,belongpro) {
            $("#cid").val(cid);
            $("#cid1").val(cid);
            $("#cname").val(cname);
            $("#cintroduction").val(cintroduction);
            $("#type").val(type);
            $("#belongcoll").val(belongcoll);
            $("#belongpro").val(belongpro);

        }

    </script>


</head>
<body>

<div class="container" style="background-color: pink ; width: 100%" >
    <ul class="nav nav-pills" >
        <li><h4 style="color: #2b669a">学生信息管理系统</h4></li>
        <li>&nbsp;&nbsp;&nbsp;</li>
        <li><a href="/getBaseInfoByAdmin">学生管理</a></li>
        <li><a href="/getTeacherByAdmin">教师管理</a></li>
        <li class="active"><a href="#">课程管理</a></li>
        <li><a href="admin-addStudent.jsp">添加学生</a></li>
        <li><a href="admin-addTeacher.jsp">添加教师</a></li>
        <li><a href="admin-addCourse.jsp">添加课程</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]} 老师 &nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">教师管理</h3>
</div>

<br><br>


<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">

        <tr>
            <td>课程号</td>
            <td>课程名</td>
            <td>简介</td>
            <td>类型</td>
            <td>所属学院</td>
            <td>所属专业</td>
            <td>修改</td>
            <td>删除</td>
        </tr>


        <c:forEach items="${sessionScope.getCourseInfoMap['stuCourseAllselect']}" var="stuCourseAllselect">
            <tr>
                <td>${stuCourseAllselect.cid}</td>
                <td>${stuCourseAllselect.cname}</td>
                <td>${stuCourseAllselect.cintroduction}</td>
                <td>${stuCourseAllselect.type}</td>
                <td>${stuCourseAllselect.belongcoll}</td>
                <td>${stuCourseAllselect.belongpro}</td>
                <td>
                    <button class="btn btn-primary btn-sm" data-toggle="modal"
                            data-target="#myModal" onclick="Valuess('${stuCourseAllselect.cid}','${stuCourseAllselect.cname}','${stuCourseAllselect.cintroduction}','${stuCourseAllselect.type}','${stuCourseAllselect.belongcoll}','${stuCourseAllselect.belongpro}')">修改</button>
                    <form action="/updatCourseInfoByAdmin" method="post" >
                        <input type="hidden" id = "cid" name="cid" value="" >
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <div class="modal-header">
                                        <button type="button" class="close"
                                                data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel">修改课程信息</h4>
                                    </div>

                                    <div class="modal-body">

                                        <label>课程号</label><br>
                                        <input name="cid1" id="cid1" value="" type="text" readonly="readonly" /><br><br>
                                        <label>课程名</label><br>
                                        <input name="cname" id="cname" value="" type="text" />
                                        <br><br>
                                        <label>简介</label><br>
                                        <input name="cintroduction" id="cintroduction" value="" type="text" /><br>
                                        <label>类型</label><br>
                                        <input name="type" id="type" value="" type="text" /><br>
                                        <label>所属学院</label><br>
                                        <input type="text" id="belongcoll" name="belongcoll" value="" /><br>
                                        <label>所属专业</label><br>
                                        <input type="text" name="belongpro" id="belongpro" value="" />

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

                <!-- 删除  -->
                <td>

                    <form action="/deleCourseInfoByAdmin" method="post">
                        <input type="hidden" name="cid" value="${stuCourseAllselect.cid}">
                        <input type="submit" value="删除" />
                    </form>

                </td>
            </tr>
        </c:forEach>


    </table>
</div>

<div class="container">
    当前 ${sessionScope.getCourseInfoMap["getTeacherMess-nowPage"]} 页 ,
    总 ${sessionScope.getCourseInfoMap["getTeacherMess-pages"]} 页 ,
    总 ${sessionScope.getCourseInfoMap["getTeacherMess-pageSize"]} 条记录.
</div>


</body>
</html>
