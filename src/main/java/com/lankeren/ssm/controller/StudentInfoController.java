
package com.lankeren.ssm.controller;

import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Demo class
 *
 * 如果 直接登入这些页面, 会报错吗
 * @author keriezhang
 * @date 2016/10/31
 */
@Controller
public class StudentInfoController {

    @Autowired
    private StudentServer studentServer;

    @RequestMapping(value = "/getStudentInfo")
    public String getStudentInfo(HttpServletRequest request){
        Map map = (Map) request.getSession().getAttribute("map");
        String sid = "";
        /**
         *  防止 直接进入这个页面报错
         */
        if(map != null) {
            sid = (String) map.get("login-username");
            Student stu = studentServer.getStuBySid(sid);
            request.getSession().setAttribute("getStuInfo",stu);

        }else{
            /**
             *  请先登录
             */

        }

        return "redirect:/views/Info/student-info.jsp";
    }


    @RequestMapping(value = "/UpdateStudPassword")
    public String UpdateStudPassword(@RequestParam("pre_password") String pre_password, @RequestParam("sid") String sid,
                                     @RequestParam("suf_password1") String suf_password1,@RequestParam("suf_password2") String suf_password2){
        String passwordByUserId = studentServer.getStuPasswordByUserId(sid);
        /**
         *  密码相同的情况
         */
        if(passwordByUserId != null && passwordByUserId != "" && passwordByUserId.equals(pre_password)){
            /**
             *  排除  新密码 不正确的情况
             */
            if(suf_password1 != null && suf_password1 != ""
                    && !suf_password1.contains(" ") && suf_password1.equals(suf_password2)){
                    studentServer.updateStuPassword(sid,suf_password1);

            }
        }

        return "redirect:/views/Info/student-info.jsp";
    }




}
