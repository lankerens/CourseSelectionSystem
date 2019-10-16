package com.lankeren.ssm.server;

import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.dao.PageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageInfoServer {

    @Autowired
    private PageInfoMapper pageInfoMapper;

    /**
     *   分页查询
     *   nowpage :  当前第几页
     *   pagesize:  一页多少 记录
     *
     */
    public List<CourseAp> getPageInfo(Integer nowpage, Integer pagesize){
        return pageInfoMapper.getPageInfo(nowpage,pagesize);
    }



}
