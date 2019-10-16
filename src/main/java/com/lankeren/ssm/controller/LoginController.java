package com.lankeren.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.Course;
import com.lankeren.ssm.dao.CourseMapper;
import com.lankeren.ssm.dao.StudentMapper;
import com.lankeren.ssm.eum.LoginPeople;
import com.lankeren.ssm.server.AdminServer;
import com.lankeren.ssm.server.CourseServer;
import com.lankeren.ssm.server.LoginServer;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginServer loginServer;

    @Autowired
    private CourseServer courseServer;

    @Autowired
    private AdminServer adminServer;

    @RequestMapping(value = "/logincontroller",method = {RequestMethod.POST})
    public String getloginpeople(@RequestParam("loginpeople")Integer loginpeople, @RequestParam("username") String username,
                                 @RequestParam("password")String password, HttpServletRequest request){
        System.out.println(loginpeople);
        boolean res = false;
        Map map = new HashMap();
        /**
         *  登录身份的判断
         */
                if(loginpeople.equals(LoginPeople.STUDENTLOGIN)){
                    res = loginServer.studentLogin(username,password);
                    if(res){
                        LoginPeople.baseInfo(request,courseServer,map,username);
                        return "redirect:/views/loginviews/login-student.jsp";
                    }
                }else if(loginpeople.equals(LoginPeople.TEACHERLOGIN)){
                    res = loginServer.teacherLogin(username,password);
                    if(res){
                        LoginPeople.baseInfo(request,courseServer,map,username);
                        return "redirect:/teacherviews/login-teacher.jsp";
                    }

                }else if(loginpeople.equals(LoginPeople.ADMINLOGIN)){
                    res = loginServer.adminLogin(username,password);
                    if(res){
                        LoginPeople.adminBaseInfo(adminServer,request,map,username);
                        return "redirect:/adminviews/login-admin.jsp";
            }

        }


        /**
         *  登录失败
         */
        map.put("message","用户名 / 密码错误, 请重新输入");
        map.put("oldUserName",username);
        request.getSession().setAttribute("map",map);
        return "redirect:/";

    }



    @RequestMapping(value = "/getBaseInfoByAdmin")
    public String getBaseInfoByAdmin(HttpServletRequest request){

        Map map = (Map) request.getSession().getAttribute("map");
        LoginPeople.adminBaseInfo(adminServer,request,map,(String)map.get("login-username"));

        return "redirect:/adminviews/login-admin.jsp";
    }
}
