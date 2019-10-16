package com.lankeren.ssm.server;

import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.beans.Teacher;
import com.lankeren.ssm.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *   业务逻辑
 */
@Service
public class AdminServer {

    @Autowired
    private AdminMapper adminMapper;


    public String getPasswordByAname(String aname){
        return adminMapper.getPasswordByAname(aname);
    }

    public List<Student> getAllStudentByAdmin(){
        return adminMapper.getAllStudentByAdmin();
    }

    /**
     *  修改学生信息
     */
    public void updateStuInfoByAdmin(String sid,String sname,String ssex,
                                     String spassword,String sage,String classr,
                                     String profession, String college){
        adminMapper.updateStuInfoByAdmin(sid,sname,ssex,spassword,sage,classr,profession,college);
    }

    /**
     * 删除学生信息
     */
    public void deleteStuInfoByAdmin(String sid){
        adminMapper.deleteStuInfoByAdmin(sid);
    }

    /**
     *  获取 所有教师的信息
     */
    public  List<Teacher>  getAllteacherInfoByAdmin(){
        return  adminMapper.getAllteacherInfoByAdmin();
    }

    /**
     *  修改教师信息
     */
    public void updateTeacherInfoByAdmin(String tname,String tpassword,String tsex,String introduction,String tid){
        adminMapper.updateTeacherInfoByAdmin(tname,tpassword,tsex,introduction,tid);
    }

    public void addTeacherInfoByAdmin(String tname,String tpassword,String tsex,String introduction,String tid){
        adminMapper.addTeacherInfoByAdmin(tname,tpassword,tsex,introduction,tid);
    }

    public void deleteTeacherInfoByAdmin(String tid){
        adminMapper.deleteTeacherInfoByAdmin(tid);
    }


    /**
     *  修改课程
     */
    public void updateCourseInfoByAdmin(String cname,String cintroduction,String type,
                                        String belongcoll,String belongpro,String cid){

        adminMapper.updateCourseInfoByAdmin(cname,cintroduction,type,belongcoll,belongpro,cid);
    }


    /**
     *  添加课程
     */
    public void addCourseInfoByAdmin(String cname,String cintroduction,String type,
                                     String belongcoll,String belongpro,String cid){

        adminMapper.addCourseInfoByAdmin(cname,cintroduction,type,belongcoll,belongpro,cid);
    }

    /**
     *  删除课程
     */
    public void deleteCourseByAdmin(String cid){
        adminMapper.deleteCourseByAdmin(cid);
    }


    public void addStudentInfoByAdmin( String sid,String sname,String sidcard,String ssex,
                                      String spassword,String sage,String classr,
                                      String profession,String college){
        adminMapper.addStudentInfoByAdmin(sid,sname,sidcard,ssex,spassword,sage,classr,profession,college);
    }
}
