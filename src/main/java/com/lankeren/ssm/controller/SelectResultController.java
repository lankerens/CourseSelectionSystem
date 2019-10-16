package com.lankeren.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.beans.CourseHad;
import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.server.CourseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  author: lankeren
 */
@Controller
public class SelectResultController {

    @Autowired
    private CourseServer courseServer;



    @RequestMapping(value = "/getAllSelectRes")
    public String getAllSelectRes(HttpServletRequest request){   // 待修改  -----  待完善
        Map map = (Map) request.getSession().getAttribute("map");

        Map<String,Object> selectresmap = new HashMap<>();
        List<CourseHad> courseHadList = new ArrayList<>();
        /**
         *   首页，1条
         */
        PageHelper.startPage(1,9);
        List<String> cids = courseServer.getAllCidBySid((String)map.get("login-username"));
        /**
         *   封装结果
         */
        PageInfo page = new PageInfo(cids);

        for (String cid: cids) {
            String tid = courseServer.getTeacherIdByCid(cid);
            String Cname = courseServer.getCnameByCid(cid);
            Teacher teacher = courseServer.getTeacheInfoById(tid);
            List<CourseAp> allCourseAp = courseServer.getAllCourseApByCid(cid);
            CourseHad courseHad = null;
            if(teacher != null) {
                courseHad = new CourseHad(Cname, teacher, allCourseAp);
                courseHadList.add(courseHad);
            }
        }
        selectresmap.put("courseHadList",courseHadList);

        /**
         *   分页的相关信息:  当前 页  总 页  总  条记录
         */
        selectresmap.put("seleres-nowPage",page.getPageNum());
        selectresmap.put("seleres-pages",page.getPages());
        selectresmap.put("seleres-pageSize",page.getSize());

        request.getSession().setAttribute("selectresmap",selectresmap);
        return "redirect:/views/selectResult.jsp";
    }

}
