<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aying
  Date: 2019/10/15
  Time: 18:41
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

    <!--  配合模态框 传值  -->
    <script>
        $("#myModal").modal("hide");
        function Values(cid) {
            $("#cid").val(cid);
            $("#cid1").val(cid);

        }

    </script>



</head>
<body>

<div class="container" style="background-color: pink ; width: 100%" >
    <ul class="nav nav-pills" >
        <li><h4 style="color: #2b669a">学生信息管理系统</h4></li>
        <li>&nbsp;&nbsp;&nbsp;</li>
        <li ><a href="login-teacher.jsp">添加教学课程</a></li>
        <li class="active"><a href="teachManager.jsp">管理教学课程</a></li>
        <li><a href="/getCoueseNumMessage">查看选课名单</a></li>
        <li><a href="/getTeacherInfoMessage">管理本人信息</a></li>
        <li><a href="/stuLogout">注销</a></li>
        <li style="float: right"><h4>${sessionScope.map["loginSuceessMessage"]} 老师 &nbsp;&nbsp;</h4></li>
    </ul>
</div>
<br>

<div class="container">
    <h3 style="text-align: left">管理教学课程</h3>
</div>
<br><br>

<div class="container" style="color: red">
    ${sessionScope.updataTeachManagerInfoMessage}
    <%
        session.removeAttribute("updataTeachManagerInfoMessage");
    %>
</div>


<!-- 所建班级  上课时间   上课周  课程名   上课教室    学分    学时   总人数   修改   删除  -->
<div class="container">
    <table border="1" cellpadding="1" cellspacing="1" width="70%" style="text-align: center">
        <tr>
            <td>所建班级</td>
            <td>上课时间</td>
            <td>上课周</td>
            <td>课程名</td>
            <td>上课教室</td>
            <td>学分</td>
            <td>学时</td>
            <td>总人数</td>
            <td>修改</td>
            <td>删除</td>
        </tr>

        <tr>
            <c:forEach items="${sessionScope.teachCourseMap['allCourseByTid']}" var="allCourseByTid">
                <td>${allCourseByTid.courseclass}</td>
                <td>${allCourseByTid.coursetime}</td>
                <td>${allCourseByTid.courseweek}</td>
                <td>${allCourseByTid.cname}</td>
                <td>${allCourseByTid.classroom}</td>
                <td>${allCourseByTid.credits}</td>
                <td>${allCourseByTid.period}</td>
                <td>${allCourseByTid.totalnum}</td>
                <td>


                    <button class="btn btn-primary btn-sm" data-toggle="modal"
                            data-target="#myModal" onclick=Values("${allCourseByTid.cid}")>修改</button>
                    <form action="/updataTeachManagerInfo" method="post" >
                        <input type="hidden" id = "cid" name="cid" value="" >
                        <input type="hidden" name="tid" value="${sessionScope.map["login-username"]}">
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">

                                    <div class="modal-header">
                                        <button type="button" class="close"
                                                data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel">修改课程信息</h4>
                                    </div>

                                    <div class="modal-body row col-md-12">
                                        <div class="col-md-6">
                                            <div class="form-group">

                                                <label>新建班级名称</label><br>
                                                <input name="courseclass" type="text"  /><br><br>
                                                <label>上课时间</label><br>

                                                <input type="radio" name="coursetime" value="12" checked />第一二节<br>
                                                <input type="radio" name="coursetime" value="34" />第三四节<br>
                                                <input type="radio" name="coursetime" value="56" />第五六节<br>
                                                <input type="radio" name="coursetime" value="78" />第七八节
                                                <br><br>
                                                <label>上课周</label><br>
                                                <input type="radio" name="courseweek" value="1" checked/>星期一<br>
                                                <input type="radio" name="courseweek" value="2" />星期二<br>
                                                <input type="radio" name="courseweek" value="3" />星期三<br>
                                                <input type="radio" name="courseweek" value="4" />星期四<br>
                                                <input type="radio" name="courseweek" value="5"/>星期五<br>
                                                <input type="radio" name="courseweek" value="6" />星期六<br>
                                                <input type="radio" name="courseweek" value="7" />星期日
                                            </div></div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>课程编号</label><br>
                                                <input type="text" id="cid1"  value="" readonly="readonly" /><br>
                                                <label>教师编号</label><br>
                                                <input type="text" value="${sessionScope.map["login-username"]}" readonly="readonly" /><br>
                                                <label>上课教室</label><br>
                                                <input type="text" name="classroom" /><br>
                                                <label>学分</label><br>
                                                <input type="text" name="credits" /><br>
                                                <label>学时</label><br>
                                                <input type="text" name="period" /><br>
                                                <label>总人数</label><br>
                                                <input type="text" name="totalnum" /><br>

                                            </div></div>
                                    </div>

                                    <div class="modal-footer">

                                        <button type="button" class="btn btn-default"
                                                data-dismiss="modal">关闭</button>

                                            <%--<button type="button" class="btn btn-primary" data-toggle="modal"--%>
                                            <%--data-target="#abc" >提交更改</button>--%>
                                        <input type="submit" value="完成" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>





                </td>
                <td>
                    <form action="/DeleTeacherManager" method="post">
                        <input type="hidden" name="cid" value="${allCourseByTid.cid}">
                        <input type="hidden" name="tid" value="${allCourseByTid.tid}">
                        <input type="submit" value="删除" />
                    </form>
                </td>
        </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    当前 ${sessionScope.teachCourseMap["getTeachManger-nowPage"]} 页 , 总 ${sessionScope.teachCourseMap["getTeachManger-pages"]} 页 , 总 ${sessionScope.teachCourseMap["getTeachManger-pageSize"]} 条记录.
</div>

</body>
</html>
