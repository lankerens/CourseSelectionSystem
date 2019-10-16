package com.lankeren.ssm.dao;

import com.lankeren.ssm.beans.Course;
import com.lankeren.ssm.beans.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    public String getStuPasswordByUserId(String Sid);  // 按学号查找

    public List<Course> getStuCourseAllselect();         // 获取学生可选的全部课程.

    public String getCnameByCid(String cid);         // 根据 课程号查找 课程名.

    public Student getStuBySid(String sid);      //获取学生信息

    /**
     *  修改密码
     */
    public void updateStuPassword(@Param("sid") String sid, @Param("newPassword") String newPassword);


}
