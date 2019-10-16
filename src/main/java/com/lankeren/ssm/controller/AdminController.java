package com.lankeren.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.Course;
import com.lankeren.ssm.eum.LoginPeople;
import com.lankeren.ssm.eum.MyPageHelper;
import com.lankeren.ssm.server.AdminServer;
import com.lankeren.ssm.server.CourseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminServer adminServer;

    @Autowired
    private CourseServer courseServer;

    @RequestMapping(value = "/updateStuInfoByAdmin",method = RequestMethod.POST)
    public String updateStuInfoByAdmin(@RequestParam("sid") String sid , @RequestParam("sname") String sname , @RequestParam("college") String college ,
                                       @RequestParam("ssex") String ssex , @RequestParam("spassword") String spassword , @RequestParam("sage") String sage ,
                                       @RequestParam("classr") String classr , @RequestParam("profession") String profession,
                                       HttpServletRequest request){

        /**
         *  判断 信息是否 有为空的情况
         */
        if(sname == "" || sname.contains(" ") ||
                college == "" || college.contains(" ") ||
                ssex == "" || ssex.contains(" ") ||
                 spassword == "" || spassword.contains(" ") ||
                sage == "" || sage.contains(" ") ||
                classr == "" || classr.contains(" ") ||
                profession == "" || profession.contains(" ") ){
            request.getSession().setAttribute("updateStuInfoMessage","信息不完整，添加失败");
            return "redirect:/adminviews/login-admin.jsp";
        }
        /**
         *   判断信息是否有不合法的情况
         */

        /**
         *   把字符变为 中文, 防止乱码
         */
        try {
            sname = new String(sname.getBytes("ISO-8859-1"), "UTF-8");
            college = new String(college.getBytes("ISO-8859-1"), "UTF-8");
            ssex = new String(ssex.getBytes("ISO-8859-1"), "UTF-8");
            classr = new String(classr.getBytes("ISO-8859-1"), "UTF-8");
            profession = new String(profession.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        adminServer.updateStuInfoByAdmin(sid,sname,ssex,spassword,sage,classr,profession,college);
        request.getSession().setAttribute("updateStuInfoMessage","修改成功");

        /**
         *   实现 动态更新 ， 修改完后 内容变化, 重新查一次数据库  ( 这种办法不可取 )
         */
        Map map = (Map) request.getSession().getAttribute("map");
        LoginPeople.adminBaseInfo(adminServer,request,map,(String)map.get("login-username"));

        return "redirect:/adminviews/login-admin.jsp";
    }


    @RequestMapping(value = "/addStudentInfoByAdmin",method = RequestMethod.POST)
    public String addStudentInfoByAdmin(@RequestParam("sid") String sid ,@RequestParam("sname") String sname ,@RequestParam("college") String college ,
                                       @RequestParam("ssex") String ssex ,@RequestParam("spassword") String spassword ,@RequestParam("sage") String sage ,
                                       @RequestParam("classr") String classr ,@RequestParam("profession") String profession,@RequestParam("sidcard") String sidcard,
                                        HttpServletRequest request){
        /**
         *  sid 判断是否重复了
         */
        if(     sid == null || sid == "" || sid.contains(" ")||
                sname == null || sname == "" || sname.contains(" ")||
                ssex == null || ssex == "" || ssex.contains(" ")||
                spassword == null || spassword == "" || spassword.contains(" ")||
                sidcard == null || sidcard == "" || sidcard.contains(" ")
               ){
            request.getSession().setAttribute("addStuByAdmin","信息有空缺,请仔细检查清楚 !!");
            return "redirect:/adminviews/admin-addStudent.jsp";
        }
        /**
         *    转换成中文
         */
        try {
            sname = new String(sname.getBytes("ISO-8859-1"), "UTF-8");
            college = new String(college.getBytes("ISO-8859-1"), "UTF-8");
            ssex = new String(ssex.getBytes("ISO-8859-1"), "UTF-8");
            classr = new String(classr.getBytes("ISO-8859-1"), "UTF-8");
            profession = new String(profession.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         *  数据判断
         */
        adminServer.addStudentInfoByAdmin(sid,sname,sidcard,ssex,spassword,sage,classr,profession,college);
        request.getSession().setAttribute("addStuByAdmin","添加成功!");

        return "redirect:/adminviews/admin-addStudent.jsp";
    }



    @RequestMapping(value = "/deleteStuInfoByAdmin")
    public String deleteStuInfoByAdmin(@RequestParam("sid") String sid,HttpServletRequest request){
        adminServer.deleteStuInfoByAdmin(sid);
        request.getSession().setAttribute("updateStuInfoMessage","删除成功! ");
        /**
         *   实现 动态更新 ， 修改完后 内容变化, 重新查一次数据库  ( 这种办法不可取 )
         */
        Map map = (Map) request.getSession().getAttribute("map");
        LoginPeople.adminBaseInfo(adminServer,request,map,(String)map.get("login-username"));
        return "redirect:/adminviews/login-admin.jsp";
    }



    /**
     *
     *  Admin 管理教师
     */
    @RequestMapping(value = "/getTeacherByAdmin")
    public String getTeacherByAdmin(HttpServletRequest request){

        MyPageHelper.getAllteacherInfoByAdmin(request,adminServer);

        return "redirect:/adminviews/admin-teacherManager.jsp";
    }

    /**
     *
     *  Admin 修改教师信息
     */
    @RequestMapping(value = "/updateTeacherByAdmin")
    public String updateTeacherByAdmin(@RequestParam("tid") String tid,@RequestParam("tname") String tname,
                                       @RequestParam("tpassword") String tpassword,@RequestParam("tsex") String tsex,
                                       @RequestParam("introduction") String introduction,HttpServletRequest request){

        if(tpassword == null || tpassword == "" || tpassword.contains(" ")||
                tname == null || tname == "" || tname.contains(" ")||
                    tsex == null || tsex == "" || tsex.contains(" ")||
                      introduction == null || introduction == "" || introduction.contains(" ")){
            request.getSession().setAttribute("updateTeacherMessage","信息不完整， 修改失败 ! ");
            return "redirect:/adminviews/admin-teacherManager.jsp";

        }else {

            try {
                tname = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
                tsex = new String(tsex.getBytes("ISO-8859-1"), "UTF-8");
                introduction = new String(introduction.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            adminServer.updateTeacherInfoByAdmin(tname,tpassword,tsex,introduction,tid);
            MyPageHelper.getAllteacherInfoByAdmin(request,adminServer);
        }


        return "redirect:/adminviews/admin-teacherManager.jsp";
    }


    /**
     *  Admin 删除教师
     */
    @RequestMapping(value = "/deleteTeacherByAdmin")
    public String deleteTeacherByAdmin(@RequestParam("tid") String tid,HttpServletRequest request){

        adminServer.deleteTeacherInfoByAdmin(tid);
        MyPageHelper.getAllteacherInfoByAdmin(request,adminServer);

        return "redirect:/adminviews/admin-teacherManager.jsp";
    }


    /**
     *  获取 所有的课程
     */

    @RequestMapping(value = "/getCourseInfoByAdmin")
    public String getCourseInfoByAdmin(HttpServletRequest request){

        MyPageHelper.getAllCourseInfoByAdmin(courseServer,request);

        return "redirect:/adminviews/admin-courseManager.jsp";
    }


    /**
     *  修改课程信息
     */
    @RequestMapping(value = "/updatCourseInfoByAdmin")
    public String updatCourseInfoByAdmin(HttpServletRequest request,@RequestParam("cname") String cname,
                                         @RequestParam("cintroduction") String cintroduction,@RequestParam("belongpro") String belongpro,
                                         @RequestParam("type") String type,@RequestParam("cid") String cid,
                                         @RequestParam("belongcoll") String belongcoll){

        try {
            cintroduction = new String(cintroduction.getBytes("ISO-8859-1"), "UTF-8");
            belongpro = new String(belongpro.getBytes("ISO-8859-1"), "UTF-8");
            belongcoll = new String(belongcoll.getBytes("ISO-8859-1"), "UTF-8");
            cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
            type = new String(type.getBytes("ISO-8859-1"), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        adminServer.updateCourseInfoByAdmin(cname,cintroduction,type,belongcoll,belongpro,cid);
        MyPageHelper.getAllCourseInfoByAdmin(courseServer,request);

        return "redirect:/adminviews/admin-courseManager.jsp";
    }


    /**
     *
     *  删除课程
     */
    @RequestMapping(value = "/deleCourseInfoByAdmin")
    public String deleCourseInfoByAdmin(@RequestParam("cid") String cid,HttpServletRequest request){

        adminServer.deleteCourseByAdmin(cid);
        MyPageHelper.getAllCourseInfoByAdmin(courseServer,request);
        return "redirect:/adminviews/admin-courseManager.jsp";
    }


    /**
     *
     *   添加教师
     */
    @RequestMapping(value = "/addTeacherByAdmin")
    public String addTeacherByAdmin(HttpServletRequest request,@RequestParam("tname")String tname,
                                    @RequestParam ("tpassword")String tpassword,
                                    @RequestParam ("tsex")String tsex,@RequestParam("introduction")String introduction,
                                    @RequestParam("tid")String tid){

        /**
         *
         *  是否已存在  tid
         */


        /**
         *  是否为空
         */
        if(tname == null || tname == "" || tname.contains(" ")||
                tpassword == null || tpassword == "" || tpassword.contains(" ")||
                 tid == null || tid == "" || tid.contains(" ")
        ){
            request.getSession().setAttribute("addTeacherMessgae","缺少必填内容,添加失败!!");
            return "redirect:/adminviews/admin-addTeacher.jsp";
        }

        try {
            introduction = new String(introduction.getBytes("ISO-8859-1"), "UTF-8");
            tsex = new String(tsex.getBytes("ISO-8859-1"), "UTF-8");
            tname = new String(tname.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        /**
         *  数据检验
         */
        adminServer.addTeacherInfoByAdmin(tname,tpassword,tsex,introduction,tid);
        request.getSession().setAttribute("addTeacherMessgae","添加成功!!");

        return "redirect:/adminviews/admin-addTeacher.jsp";
    }

    /**
     *  添加 课程
     * @param request
     * @param cname
     * @param cintroduction
     * @param type
     * @param belongcoll
     * @param belongpro
     * @param cid
     * @return
     */
    @RequestMapping(value = "/addCourseByAdmin")
    public String addCourseByAdmin(HttpServletRequest request,@RequestParam("cname")String cname,
                                   @RequestParam("cintroduction")String cintroduction,@RequestParam("type")String type,
                                   @RequestParam("belongcoll")String belongcoll,@RequestParam("belongpro")String belongpro,
                                   @RequestParam("cid")String cid){

        /**
         *  是否为空
         */
        if(cid == null || cid == "" || cid.contains(" ")||
                cname == null || cname == "" || cname.contains(" ")
        ){
            request.getSession().setAttribute("addCourseMessage","缺少必填内容,添加失败!!");
            return "redirect:/adminviews/admin-addCourse.jsp";
        }

        try {
            cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
            cintroduction = new String(cintroduction.getBytes("ISO-8859-1"), "UTF-8");
            belongpro = new String(belongpro.getBytes("ISO-8859-1"), "UTF-8");
            belongcoll = new String(belongcoll.getBytes("ISO-8859-1"), "UTF-8");
            type = new String(type.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        adminServer.addCourseInfoByAdmin(cname,cintroduction,type,belongcoll,belongpro,cid);
        request.getSession().setAttribute("addCourseMessage","添加成功!!");

        return "redirect:/adminviews/admin-addCourse.jsp";
    }

}
