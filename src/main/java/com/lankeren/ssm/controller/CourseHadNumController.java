package com.lankeren.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.server.StudentServer;
import com.lankeren.ssm.server.TeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseHadNumController {

    @Autowired
    private TeacherServer teacherServer;

    @Autowired
    private StudentServer studentServer;

    @RequestMapping(value = "/getCoueseNumMessage")
    public String getCoueseNumMessage(HttpServletRequest request){
        Map map = (Map)request.getSession().getAttribute("map");
        String tid = (String) map.get("login-username");
        Map<String ,Object> getCourseNumMap = new HashMap<>();

        PageHelper.startPage(1,9);
        List<String> allCidByTid = teacherServer.getAllCidByTid(tid);
        /**
         *   封装结果
         */
        PageInfo page = new PageInfo(allCidByTid);

        List<CourseAp> courseAps = new ArrayList<>();
        for (String cid: allCidByTid) {
            String cnameByCid = studentServer.getCnameByCid(cid);
            Integer courseNumByCid = teacherServer.getCourseNumByCid(cid);
            Integer totalnumByCid = teacherServer.getTotalnumByCid(cid);
            CourseAp courseAp = new CourseAp(totalnumByCid,cnameByCid,courseNumByCid);
            courseAps.add(courseAp);

        }
        request.getSession().setAttribute("courseAps",courseAps);

        /**
         *  分页相关信息
         */
        getCourseNumMap.put("getCourseHad-nowPage",page.getPageNum());
        getCourseNumMap.put("getCourseHad-pages",page.getPages());
        getCourseNumMap.put("getCourseHad-pageSize",page.getSize());
        request.getSession().setAttribute("getCourseNumMap",getCourseNumMap);

        return "redirect:/teacherviews/courseHadNum.jsp";
    }



}
