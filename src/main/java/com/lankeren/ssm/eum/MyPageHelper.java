package com.lankeren.ssm.eum;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.Course;
import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.server.AdminServer;
import com.lankeren.ssm.server.CourseServer;
import com.lankeren.ssm.server.StudentServer;
import com.lankeren.ssm.server.TeacherServer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPageHelper {

    /**
     *  学生 系统的 分页插件
     * @param request
     * @param nowuser
     * @param courseServer
     * @param studentServer
     */
    public static void getDelCoursePageInfo(HttpServletRequest request, String nowuser, CourseServer courseServer,
                                            StudentServer studentServer){

        Map map = (Map)request.getSession().getAttribute("map");

        PageHelper.startPage(1,9);
        List<String> cids = courseServer.getAllCidBySid((String) map.get(nowuser));
        /**
         *  封装 结果 cids
         */
        PageInfo page = new PageInfo(cids);

        List<String> cnames = new ArrayList<>();
        for (String cid: cids) {
            String cname = studentServer.getCnameByCid(cid);
            cnames.add(cname);
        }
        Map<String,Object> getDeleMessagemap = new HashMap<>();
        /**
         *   分页的相关信息:  当前 页  总 页  总  条记录
         */
        getDeleMessagemap.put("GetDeleCname",cnames);
        getDeleMessagemap.put("getdelMess-nowPage",page.getPageNum());
        getDeleMessagemap.put("getdelMess-pages",page.getPages());
        getDeleMessagemap.put("getdelMess-pageSize",page.getSize());
        /**
         *  方便退选后的页面更新操作
         */
        request.getSession().setAttribute("getDeleMessagemap",getDeleMessagemap);


    }

    /**
     *  教师系统的 分页插件
     * @param
     * @param
     * @param
     */
    public static void getTeachCoursePageInfo(HttpServletRequest request, TeacherServer teacherServer, StudentServer studentServer){

        Map map = (Map) request.getSession().getAttribute("map");
        /**
         *  获取当前登陆的教师 id
         */
        String tid = (String) map.get("login-username");

        /**
         *   通过 tid 获取 所开的所有课程
         */
        PageHelper.startPage(1,9);
        List<CourseAp> allCourseByTid = teacherServer.getAllCourseByTid(tid);

        /**
         *  封装一下
         */
        PageInfo page = new PageInfo(allCourseByTid);

        Map<String, Object> teachCourseMap = new HashMap<>();
        /**
         *  要是用的容量不多, 最好给一个初始值.
         */
        List<String> cnames  = new ArrayList<>();
        /**
         *  根据相应的顺序对应存储的
         */
        for (CourseAp courseAp:allCourseByTid) {
            String cid = courseAp.getCid();
            String cnameByCid = studentServer.getCnameByCid(cid);
            courseAp.setCname(cnameByCid);
        }
        teachCourseMap.put("getTeachManger-nowPage",page.getPageNum());
        teachCourseMap.put("getTeachManger-pages",page.getPages());
        teachCourseMap.put("getTeachManger-pageSize",page.getSize());

        /**
         *
         */
        teachCourseMap.put("allCourseByTid",allCourseByTid);

        request.getSession().setAttribute("teachCourseMap",teachCourseMap);




    }


    /**
     *  管理员系统的 分页插件 --- 学生管理
     */
    public static void getAllStuInfoByAdmin(){

    }


    /**
     *  管理员系统的 分页插件 --- 教师管理
     */
    public static void getAllteacherInfoByAdmin(HttpServletRequest request, AdminServer adminServer){

        Map<String , Object> getTeacherInfoMap = new HashMap<>();

        PageHelper.startPage(1,9);

        List<Teacher> allteacherInfoByAdmin = adminServer.getAllteacherInfoByAdmin();
        /**
         *  封装结果
         *
         */
        PageInfo page = new PageInfo(allteacherInfoByAdmin);

        getTeacherInfoMap.put("allteacherInfoByAdmin",allteacherInfoByAdmin);

        /**
         *   分页相关信息的存储
         */
        getTeacherInfoMap.put("getTeacherMess-nowPage",page.getPageNum());
        getTeacherInfoMap.put("getTeacherMess-pages",page.getPages());
        getTeacherInfoMap.put("getTeacherMess-pageSize",page.getSize());

        request.getSession().setAttribute("getTeacherInfoMap",getTeacherInfoMap);



    }


    /**
     *  课程管理
     *
     */
    public static void getAllCourseInfoByAdmin(CourseServer courseServer,HttpServletRequest request){

        Map<String,Object> getCourseInfoMap = new HashMap<>();
        PageHelper.startPage(1,9);

        List<Course> stuCourseAllselect = courseServer.getStuCourseAllselect();
        /**
         *  封装结果
         */
        PageInfo page = new PageInfo(stuCourseAllselect);

        getCourseInfoMap.put("stuCourseAllselect",stuCourseAllselect);

        /**
         *   分页相关信息的存储
         */
        getCourseInfoMap.put("getTeacherMess-nowPage",page.getPageNum());
        getCourseInfoMap.put("getTeacherMess-pages",page.getPages());
        getCourseInfoMap.put("getTeacherMess-pageSize",page.getSize());

        request.getSession().setAttribute("getCourseInfoMap",getCourseInfoMap);

    }





}
