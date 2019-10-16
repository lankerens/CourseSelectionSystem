package com.lankeren.ssm.eum;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.Course;
import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.server.AdminServer;
import com.lankeren.ssm.server.CourseServer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class   LoginPeople {

    public static Integer STUDENTLOGIN = 0;
    public static Integer TEACHERLOGIN = 1;
    public static Integer ADMINLOGIN = 2;


    public static void baseInfo(HttpServletRequest request, CourseServer courseServer, Map map,String username) {
        /**
         *  设置 默认显示首页, 一页两条记录
         */
        PageHelper.startPage(1, 9);
        List<Course> stuCourseAllselect = courseServer.getStuCourseAllselect();
        /**
         *  用PageInfo对结果进行包装
         */
        PageInfo page = new PageInfo(stuCourseAllselect);
        /**
         *    存入分页的相关信息
         */
        map.put("index-nowPage",page.getPageNum());
        map.put("index-pages",page.getPages());
        map.put("index-pageSize",page.getSize());
        map.put("coursesList",stuCourseAllselect);

        // 登录成功
        map.put("loginSuceessMessage","欢迎您: " + username);
        map.put("login-username",username);

        request.getSession().setAttribute("map",map);

    }


    public static void adminBaseInfo(AdminServer adminServer,HttpServletRequest request, Map map,String username){

        PageHelper.startPage(1,9);

        List<Student> allStudents = adminServer.getAllStudentByAdmin();
        /**
         *  封装 结果集
         */
        PageInfo page = new PageInfo(allStudents);

        map.put("allStudents",allStudents);

        /**
         *  分页相关信息
         */
        map.put("loginadmin-nowPage",page.getPageNum());
        map.put("loginadmin-pages",page.getPages());
        map.put("loginadmin-pageSize",page.getSize());

        /**
         *  当前用户 的相关信息
         */
        map.put("loginSuceessMessage","欢迎您: " + username);
        map.put("login-username",username);

        request.getSession().setAttribute("map",map);

    }



}
