package com.lankeren.ssm.controller;

import com.lankeren.ssm.server.CourseApServer;
import com.lankeren.ssm.server.CourseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@Controller
public class AddCourseController {

    @Autowired
    private CourseServer courseServer;

    @Autowired
    private CourseApServer courseApServer;

    @RequestMapping(value = "/addCourseInfo",method = RequestMethod.POST)
    public String addCourseInfo(@RequestParam("cid") String cid, HttpServletRequest request,@RequestParam("courseclass") String courseclass,
                                @RequestParam("coursetime") String coursetime,@RequestParam("courseweek") String courseweek,
                                @RequestParam("classroom") String classroom, @RequestParam("credits") Integer credits,
                                @RequestParam("period")Integer period,@RequestParam("totalnum") Integer totalnum,@RequestParam("tid") String tid){

        Integer courseNumByCid = courseApServer.getCourseNumByCid(cid);
        System.out.println(courseNumByCid);
        /**
         *  如果 该课程号已经存在
         *  不允许重复 开班
         */
        if(courseNumByCid != 0){
            request.getSession().setAttribute("addCourseInfoMessage","该课程号的班级已经存在, 无需再添加新的班级!");
            return "redirect:/teacherviews/login-teacher.jsp";
        }

        if(courseclass == null || courseclass == "" || courseclass.contains(" ") ||
                 classroom == null ||  credits == null || period == null || totalnum == null) {
            request.getSession().setAttribute("addCourseInfoMessage", "修改失败,信息不完整! ");
            return "redirect:/teacherviews/login-teacher.jsp";
        }

            /**
             *   把班级名字转为 中文
             */
        try {
            courseclass = new String(courseclass.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**
         *   直接这样操作有风险
         *   待完善
         */
        courseServer.addwithCourseAp(courseclass,coursetime,courseweek,cid,tid,classroom,credits,period,totalnum);

        request.getSession().setAttribute("addCourseInfoMessage","添加成功");
        return "redirect:/teacherviews/login-teacher.jsp";
    }


}
