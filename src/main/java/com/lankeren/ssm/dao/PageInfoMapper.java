package com.lankeren.ssm.dao;

import com.lankeren.ssm.beans.CourseAp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageInfoMapper {

    /**
     *    分页查询
     * @return
     */
    @Select("select * from courseap limit #{nowpage},#{pagesize}")
    public List<CourseAp> getPageInfo(@Param("nowpage") Integer nowpage, @Param("pagesize") Integer pagesize);



}
