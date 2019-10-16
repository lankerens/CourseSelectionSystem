package com.lankeren.ssm.controller;


import com.lankeren.ssm.eum.MyPageHelper;
import com.lankeren.ssm.server.CourseServer;
import com.lankeren.ssm.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author lankeren
 */
@Controller
public class DeleteCourseController {

    @Autowired
    public StudentServer studentServer;

    @Autowired
    private CourseServer courseServer;

    @RequestMapping(value = "/getDeleMessage")
    public String getDeleMessage(HttpServletRequest request){

        // 已修改
        MyPageHelper.getDelCoursePageInfo(request,"login-username",courseServer,studentServer);

        return "redirect:/views/deleteCourse.jsp";
    }


    @RequestMapping(value = "/DeleCourseDec")
    public String DeleCourseDec(@RequestParam(value = "cname") String cname,HttpServletRequest request,
                                @RequestParam(value = "sid") String sid){

        try {
            cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String cidByCname = courseServer.getCidByCname(cname);
        Integer deleId = courseServer.getDeleId(cidByCname,sid);
        courseServer.deleSelectCourse(deleId);
        /**
         *  完成 删除 操作了, 重新查询数据库
         */

        MyPageHelper.getDelCoursePageInfo(request,"login-username",courseServer,studentServer);

        return "redirect:/views/deleteCourse.jsp";

    }

}
