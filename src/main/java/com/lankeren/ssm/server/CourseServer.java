package com.lankeren.ssm.server;

import com.lankeren.ssm.beans.Course;
import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.dao.CourseMapper;
import com.lankeren.ssm.dao.StudentMapper;
import com.lankeren.ssm.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  time
 */
@Service
public class CourseServer {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    public TeacherMapper teacherMapper;

    public List<Course> getStuCourseAllselect(){
        return studentMapper.getStuCourseAllselect();
    }

    public String getTeacherIdByCid(String cid){
        return courseMapper.getTeacherIdByCid(cid);
    }

    public Teacher getTeacheInfoById(String tid){
        return  teacherMapper.getTeacheInfoById(tid);
    }

    // 根据 课程号查找 课程信息.
    public String getCnameByCid(String cid){
        return studentMapper.getCnameByCid(cid);
    }

    public void hadSelectCourse(String sid,String cid){
        courseMapper.hadSelectCourse(sid,cid);
    }


    public Integer getDeleId(String cid,String sid){
        return courseMapper.getDeleId(cid,sid);
    }

    public void deleSelectCourse(Integer id){
        courseMapper.deleSelectCourse(id);
    }

    public List<CourseAp> getAllCourseApByCid(String cid){
        return  courseMapper.getAllCourseApByCid(cid);
    }

    public List<String> getAllCidBySid(String sid){
        return courseMapper.getAllCidBySid(sid);
    }


    // 判断是否存在了 该科,不能重复选择

    public Integer isaliveSid(String sid,String cid){
        return courseMapper.isaliveSid(sid,cid);
    }


    public String getCidByCname(String cname){
        return courseMapper.getCidByCname(cname);
    }


    public void addwithCourseAp(String courseclass,String coursetime,String courseweek,String cid,String tid,String classroom,
                                Integer credits,Integer period,Integer totalnum){
        teacherMapper.addwithCourseAp(courseclass,coursetime,courseweek,cid,tid,classroom,credits,period,totalnum);
    }


    public List<String> getAllSidByCid(String cid){
        return  courseMapper.getAllSidByCid(cid);
    }

}
