package com.lankeren.ssm.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseApMapper {

    @Select("select count(*) from courseap where Cid=#{cid}")
    public Integer getCourseNumByCid(String cid);

}
