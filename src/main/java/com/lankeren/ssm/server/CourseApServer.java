package com.lankeren.ssm.server;

import com.lankeren.ssm.dao.CourseApMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseApServer {

    @Autowired
    private CourseApMapper courseApMapper;

    public Integer getCourseNumByCid(String cid){
        return courseApMapper.getCourseNumByCid(cid);
    }

}
