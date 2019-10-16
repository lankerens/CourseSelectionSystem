package com.lankeren.ssm.controller;

import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.exception.MyException;
import com.lankeren.ssm.server.CourseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SelectCourseController {

    @Autowired
    private CourseServer courseServer;

    @RequestMapping(value = "/getSelectCourse")
    public  String getSelectCourse(@RequestParam(value = "cid") String cid, HttpServletRequest request){
        String tid = courseServer.getTeacherIdByCid(cid);
        String Cname = courseServer.getCnameByCid(cid);
        Teacher teacher = courseServer.getTeacheInfoById(tid);
        // 把教师信息带过去
        Map<String,Object> selectmap = new HashMap<>();
        selectmap.put("teacher",teacher);
        selectmap.put("Cname",Cname);
        selectmap.put("cid",cid);
        request.getSession().setAttribute("selectmap",selectmap);
        return "redirect:/views/selectCourse.jsp";
    }

    @RequestMapping(value = "/CourseDeci")
    public String CourseDeci(@RequestParam(value = "abc") Integer id, @RequestParam("cid") String cid,
                             @RequestParam("sid") String sid,HttpServletRequest request,
                             @RequestParam("teacher") String tname){

        /**
         *   是否存在 学号和课程号已经绑定的 记录
         */
        Integer count = courseServer.isaliveSid(sid,cid);
        if(id == 1){
            if(count == 1){
                // messge 还未在 login-student 中使用
                request.getSession().setAttribute("selectCourseMessage","该门课程已经选了");
            } else if(count == 0 && (tname == null || tname == "")){
                request.getSession().setAttribute("selectCourseMessage","该门课程还没有开班, 无法选择");
                return "redirect:/views/loginviews/login-student.jsp";
            } else {
                courseServer.hadSelectCourse(sid, cid);
            }
        }else if(id == 2 && count == 1){
            /**
             *    如果存在 该记录, 需要进入条件判断 进行删除操作
             *    不存在, 不需要进入操作
             */
            Integer deleId = 0;
            deleId = courseServer.getDeleId(cid,sid);
            courseServer.deleSelectCourse(deleId);
        }else if(id == 2 && count == 0){
            request.getSession().setAttribute("selectCourseMessage","您还未选择该课程");
        }else{
            throw new MyException("出现了不可预料的错误,请重新再试");
        }

        return "redirect:/views/loginviews/login-student.jsp";
    }


}
