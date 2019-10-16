package com.lankeren.ssm.server;

import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@Service
public class StudentServer {

    @Autowired
    private StudentMapper studentMapper;

    public String getCnameByCid(String cid){
        return  studentMapper.getCnameByCid(cid);
    }

    public Student getStuBySid(String sid){
        return studentMapper.getStuBySid(sid);
    }

    public String getStuPasswordByUserId(String Sid){
        return studentMapper.getStuPasswordByUserId(Sid);
    }

    /**
     *
     * @param sid
     * @param newPassword
     */
    public void updateStuPassword( String sid,String newPassword){
        studentMapper.updateStuPassword(sid,newPassword);
    }


}
