package com.lankeren.ssm.controller;

import com.lankeren.ssm.eum.MyPageHelper;
import com.lankeren.ssm.server.StudentServer;
import com.lankeren.ssm.server.TeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@Controller
public class TeachManagerController {

    @Autowired
    private TeacherServer teacherServer;

    @Autowired
    private StudentServer studentServer;

    @RequestMapping(value = "/getTeachManagerMessage")
    public String getTeachManagerMessage(HttpServletRequest request){

        MyPageHelper.getTeachCoursePageInfo(request,teacherServer,studentServer);

        return "redirect:/teacherviews/teachManager.jsp";
    }


    @RequestMapping(value = "/updataTeachManagerInfo")
    public String updataTeachManagerInfo(@RequestParam("cid") String cid, HttpServletRequest request, @RequestParam("courseclass") String courseclass,
                                         @RequestParam("coursetime") String coursetime, @RequestParam("courseweek") String courseweek,
                                         @RequestParam("classroom") String classroom, @RequestParam("credits") Integer credits,
                                         @RequestParam("period")Integer period, @RequestParam("totalnum") Integer totalnum){

        if(courseclass == null || courseclass == "" || courseclass.contains(" ") ||
                 classroom == null ||  credits == null || period == null || totalnum == null){
            request.getSession().setAttribute("updataTeachManagerInfoMessage","修改失败,信息不完整! ");

        }else {
            /**
             *   把班级名字转为 中文
             */
            try {
                courseclass = new String(courseclass.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            teacherServer.updateTeacherCourseMessage(courseclass, coursetime, courseweek, cid, classroom, credits, period, totalnum);
            request.getSession().setAttribute("updataTeachManagerInfoMessage", "修改成功");

            MyPageHelper.getTeachCoursePageInfo(request,teacherServer,studentServer);
        }

        return "redirect:/teacherviews/teachManager.jsp";
    }


    @RequestMapping(value = "/DeleTeacherManager")
    public String DeleTeacherManager(@RequestParam("cid") String cid,HttpServletRequest request,
                                     @RequestParam("tid") String tid){

        teacherServer.deleTeacherManagerByCid(cid,tid);
        request.getSession().setAttribute("updataTeachManagerInfoMessage","删除成功!! ");

        MyPageHelper.getTeachCoursePageInfo(request,teacherServer,studentServer);

        return "redirect:/teacherviews/teachManager.jsp";
    }


}
