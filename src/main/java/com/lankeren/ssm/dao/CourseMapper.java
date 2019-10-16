package com.lankeren.ssm.dao;

import com.lankeren.ssm.beans.CourseAp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    @Select("select Tid from courseap where Cid=#{cid}")
    public String getTeacherIdByCid(String cid);       // 根据 课程的课程号 查找教师的工号.

    @Select("insert into  sc (Sid, Cid) VALUES (#{sid}, #{cid})")
    public void hadSelectCourse(@Param("sid") String sid, @Param("cid")String cid);

    /**
     *  唯一确定该课程是否已经 被该学生选择了
     * @param sid
     * @param cid
     * @return
     */
    @Select("select count(*) from sc where Sid = #{sid} and Cid = #{cid} ")
    public Integer isaliveSid(@Param("sid") String sid,@Param("cid") String cid);

    /**
     *  根据 学号 和 学号， 唯一确定该学生的 课程 退选
     * @param cid
     * @param sid
     * @return
     */
    @Select("select id from sc where Cid=#{cid} and Sid = #{sid}")
    public Integer getDeleId(@Param("cid") String cid,@Param("sid") String sid);

    @Select("delete from sc where Id = #{id}")
    public void deleSelectCourse(Integer id);


    /**
     * 这是查询 全部的课程
      */
    @Select("select Courseclass,Coursetime,Courseweek,Cid,Tid,Classroom,credits,period from courseap where Cid = #{cid}")
    public List<CourseAp> getAllCourseApByCid(String cid);


    @Select("select Cid from sc where Sid = #{sid}")
    public List<String> getAllCidBySid(String sid);

    @Select("select Cid from course where Cname = #{cname}")
    public String getCidByCname(String cname);


    /**
     *   根据 cid 获取 全部的 sid
     *
     */
    @Select("select Sid from sc where Cid = #{cid}")
    public List<String> getAllSidByCid(String cid);

}
