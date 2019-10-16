package com.lankeren.ssm.server;

import com.lankeren.ssm.dao.AdminMapper;
import com.lankeren.ssm.dao.StudentMapper;
import com.lankeren.ssm.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServer {

   @Autowired
   private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AdminMapper adminMapper;

    /**
     *  学生登录
     * @param username
     * @param password
     * @return
     */
    public boolean studentLogin(String username,String password){
        String passwordByUserId = studentMapper.getStuPasswordByUserId(username);
        if(password != null && password !="" && password.equals(passwordByUserId)){
            /**
             *  登录成功
             */
            return true;
        }else{
            /**
             *  登录失败
             */
            return false;
        }
    }


    /**
     *   username 就是 tid (登录的 id )
     * @param username
     * @param password
     * @return
     */
    public boolean teacherLogin(String username,String password){
        String teacherPasswordByTid = teacherMapper.getTeacherPasswordByTid(username);
        if(password != null && password !="" && password.equals(teacherPasswordByTid)){
            /**
             *  登录成功
             */
            return true;
        }else{
            /**
             *  登录失败
             */
            return false;
        }
    }

    public boolean adminLogin(String username,String password){
        String apassword = adminMapper.getPasswordByAname(username);

        if(password != null && password !="" && password.equals(apassword)){
            /**
             *  登录成功
             */
            return true;
        }else{
            /**
             *  登录失败
             */
            return false;
        }
    }

}
