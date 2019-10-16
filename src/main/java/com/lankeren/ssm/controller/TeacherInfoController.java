package com.lankeren.ssm.controller;

import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.server.TeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TeacherInfoController {

    @Autowired
    private TeacherServer teacherServer;

    @RequestMapping(value = "/getTeacherInfoMessage")
    public String getTeacherInfoMessage(HttpServletRequest request){

        Map map = (Map)request.getSession().getAttribute("map");
        String tid = (String) map.get("login-username");
        Teacher teacher = teacherServer.getTeacherInfoByTid(tid);
        request.getSession().setAttribute("teacherInfo",teacher);

        return "redirect:/views/Info/teacher-info.jsp";
    }


    @RequestMapping(value = "/UpdateTpasswordByTid")
    public String UpdateTpasswordByTid(@RequestParam("pre_password") String pre_password,@RequestParam("suf_password1") String suf_password1,
                                       @RequestParam("suf_password2") String suf_password2,HttpServletRequest request,
                                       @RequestParam("tid") String tid){


        String tpassword = teacherServer.getTeacherPasswordByTid(tid);

        if(tpassword.equals(pre_password)){

            if(suf_password1 != null && suf_password1 != "" && (!suf_password1.contains((" ")) &&
                    suf_password1.equals(suf_password2))){
                teacherServer.updateTeacherPassword(suf_password1,tid);
            }
        }

        return "redirect:/views/Info/teacher-info.jsp";
    }


}
