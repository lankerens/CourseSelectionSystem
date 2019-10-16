package com.lankeren.ssm.dao;

import com.lankeren.ssm.beans.CourseAp;
import com.lankeren.ssm.beans.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    /**
     *  根据教师工号去查找 教师相关信息
     * @param tid
     * @return
     */
    @Select("select Tname,Introduction from teacher where Tid=#{tid}")
    public Teacher getTeacheInfoById(String tid);


    /**
     *   根据  Tid  返回 密码信息 验证登录
     * @param tid
     * @return
     */
    @Select("select Tpassword from teacher where Tid=#{tid}")
    public String getTeacherPasswordByTid(String tid);


    @Select("insert into  courseap  VALUES (#{courseclass}, #{coursetime},#{courseweek}, #{cid}, #{tid},#{classroom}, #{credits},#{period},#{totalnum})")
    public void addwithCourseAp(@Param("courseclass") String courseclass, @Param("coursetime")String coursetime, @Param("courseweek")String courseweek,
                                @Param("cid")String cid, @Param("tid")String tid, @Param("classroom")String classroom,
                                @Param("credits")Integer credits, @Param("period")Integer period, @Param("totalnum")Integer totalnum);


    /**
     *  根据教师 id  查询所管理的课程
     * @param tid
     * @return
     */
    @Select("select * from courseap where Tid = #{tid}")
    public List<CourseAp> getAllCourseByTid(String tid);


    /**
     *   查询有几个学生 报名了 当前教师的 课程
     */
    @Select("select count(*) from sc where Cid = #{cid}")
    public Integer getCourseNumByCid(String cid);


    /**
     *   查询 该课程的 总人数
     */
    @Select("select Totalnum from courseap where Tid=#{tid}")
    public List<Integer> gettotalnumBytid(String tid);


    /**
     *   根据 tid 获取当前教师所有的 cid
     */
    @Select("select Cid from courseap where Tid=#{tid}")
    public List<String> getAllCidByTid(String tid);


    /**
     *  根据课程号查总人数
     */
    @Select("select Totalnum from courseap where Cid=#{cid}")
    public Integer getTotalnumByCid(String cid);


    /**
     *   根据 教师 工号 tid  获取 教师 信息
     */
    @Select("select * from teacher where Tid=#{tid}")
    public Teacher getTeacherInfoByTid(String tid);


    /**
     *  修改 教师 的 密码
     *
     */
    @Select(" UPDATE teacher SET Tpassword = #{newPassword} WHERE Tid = #{tid}")
    public void updateTeacherPassword(@Param("newPassword") String newPassword,@Param("tid") String tid);


    /**
     *  修改 教师 所管理的课程 信息
     */
    @Select("UPDATE courseap SET `Courseclass` = #{courseclass}, `Coursetime` = #{coursetime}, `Courseweek` = #{courseweek}, `Classroom` = #{classroom}," +
            " `credits` = #{credits}, `period` = #{period}, `Totalnum` = #{totalnum} WHERE (`Cid` = #{cid})")
    public void updateTeacherCourseMessage(@Param("courseclass") String courseclass, @Param("coursetime")String coursetime, @Param("courseweek")String courseweek,
                                           @Param("cid")String cid, @Param("classroom")String classroom,
                                           @Param("credits")Integer credits, @Param("period")Integer period, @Param("totalnum")Integer totalnum);


    /**
     *    删除 指定 cid and tid 的 课程
     */
    @Select("delete from courseap where Cid = #{cid} and Tid = #{tid}")
    public void deleTeacherManagerByCid(@Param("cid") String cid,@Param("tid") String tid);

}
