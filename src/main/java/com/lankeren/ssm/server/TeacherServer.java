package com.lankeren.ssm.server;

import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServer {

    @Autowired
    private TeacherMapper teacherMapper;


    public List<CourseAp> getAllCourseByTid(String tid){
        return teacherMapper.getAllCourseByTid(tid);
    }


    public Integer getCourseNumByCid(String cid){
        return teacherMapper.getCourseNumByCid(cid);
    }

    public List<Integer> gettotalnum(String tid){
        return teacherMapper.gettotalnumBytid(tid);
    }

    public List<String> getAllCidByTid(String tid){
        return teacherMapper.getAllCidByTid(tid);
    }


    public Integer getTotalnumByCid(String cid){
        return teacherMapper.getTotalnumByCid(cid);
    }

    public Teacher getTeacherInfoByTid(String tid){
        return teacherMapper.getTeacherInfoByTid(tid);
    }

    public String getTeacherPasswordByTid(String tid){
        return teacherMapper.getTeacherPasswordByTid(tid);
    }



    public void updateTeacherPassword( String newPassword,String tid){
        teacherMapper.updateTeacherPassword(newPassword,tid);
    }


    public void updateTeacherCourseMessage(String courseclass,String coursetime,String courseweek,String cid,String classroom,
                                           Integer credits,Integer period,Integer totalnum){
        teacherMapper.updateTeacherCourseMessage(courseclass,coursetime,courseweek,cid,classroom,credits,period,totalnum);
    }

    public void deleTeacherManagerByCid(String cid,String tid){
        teacherMapper.deleTeacherManagerByCid(cid,tid);
    }




}
