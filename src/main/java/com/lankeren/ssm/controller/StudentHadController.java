package com.lankeren.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.server.CourseServer;
import com.lankeren.ssm.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentHadController {

    @Autowired
    private CourseServer courseServer;

    @Autowired
    private StudentServer studentServer;


    @RequestMapping(value = "/getStudentwhoSelect")
    public String getStudentwhoSelect(@RequestParam("cname") String cname, HttpServletRequest request){
        Map<String,Object> studentWhoSelectMap = new HashMap<>();
        String cidByCname = "";
        /**
         *  班级名字  转换成 中文
         */
        try {
            cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
            cidByCname = courseServer.getCidByCname(cname);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        PageHelper.startPage(1,9);
        List<String> allSidByCid = courseServer.getAllSidByCid(cidByCname);
        /**
         *  封装 allsidByCid 结果
         */
        PageInfo page = new PageInfo(allSidByCid);

        List<Student> students = new ArrayList<>();
        for (String sid: allSidByCid) {
            Student stu = studentServer.getStuBySid(sid);
            students.add(stu);
        }
        studentWhoSelectMap.put("students",students);
        studentWhoSelectMap.put("cname",cname);

        /**
         *  分页相关的 信息
         */
        studentWhoSelectMap.put("studentHadSec-nowPage",page.getPageNum());
        studentWhoSelectMap.put("studentHadSec-pages",page.getPages());
        studentWhoSelectMap.put("studentHadSec-pageSize",page.getSize());


        request.getSession().setAttribute("studentWhoSelectMap",studentWhoSelectMap);
        return "redirect:/teacherviews/studentHadSelect.jsp";
    }

}
