package com.lankeren.ssm.dao;

import com.lankeren.ssm.beans.Student;
import com.lankeren.ssm.beans.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AdminMapper {

    /**
     *   根据 管理员  账号 获取 密码
     * @return
     */
    @Select("select Apassword from admin where Aname = #{aname}")
    public String getPasswordByAname(String aname);


    /**
     *  获取 所有的学生
     * @return
     */
    @Select("select * from student")
    public List<Student> getAllStudentByAdmin();


    /**
     *    Admin 修改 学生信息
     */
    @Select("UPDATE student SET `Sname` = #{sname}, `Ssex` = #{ssex}, `Spassword` = #{spassword}, `Sage` = #{sage}," +
            " `Classr` = #{classr}, `profession` = #{profession}, `College` = #{college} WHERE (`Sid` = #{sid})")
    public void updateStuInfoByAdmin(@Param("sid") String sid, @Param("sname")String sname,@Param("ssex") String ssex,
                                     @Param("spassword")String spassword,@Param("sage") String sage, @Param("classr")String classr,
                                     @Param("profession")String profession,@Param("college") String college);


    /**
     *   Admin  添加学生信息
     */
    @Select("INSERT INTO student (`Sid`, `Sname`, `Sidcard`, `Ssex`, `Spassword`, `Sage`, `Classr`, `profession`, `College`) " +
            "VALUES (#{sid}, #{sname}, #{sidcard}, #{ssex}, #{spassword}, #{sage}, #{classr}, #{profession}, #{college})")
    public void addStudentInfoByAdmin(@Param("sid") String sid,@Param("sname")String sname,@Param("sidcard")String sidcard,@Param("ssex")String ssex,
                                      @Param("spassword")String spassword,@Param("sage")String sage,@Param("classr")String classr,
                                      @Param("profession")String profession,@Param("college") String college);


    /**
     *  Admin 删除 学生
     */
    @Select("delete from  student where Sid = #{sid}")
    public void deleteStuInfoByAdmin(String sid);


    /**
     *  Admin 获取 所有教师
     */
    @Select("select * from teacher")
    public List<Teacher> getAllteacherInfoByAdmin();


    /**
     *  Admin 修改 教师信息
     */
    @Select("UPDATE teacher SET `Tname` = #{tname}, `Tpassword` = #{tpassword}, `Tsex` = #{tsex}, " +
            "`Introduction` = #{introduction} WHERE (`Tid` = #{tid})")
    public void updateTeacherInfoByAdmin(@Param("tname") String tname,@Param("tpassword")String tpassword,@Param("tsex")String tsex,
                                         @Param("introduction")String introduction,@Param("tid")String tid);


    /**
     *  添加教师
     */
    @Select("INSERT INTO teacher (`Tid`, `Tname`, `Tpassword`, `Tsex`, " +
            "`Introduction`) VALUES (#{tid}, #{tname}, #{tpassword}, #{tsex}, #{introduction})")
    public void addTeacherInfoByAdmin(@Param("tname")String tname,@Param("tpassword")String tpassword,
                                      @Param("tsex")String tsex,@Param("introduction")String introduction,
                                      @Param("tid")String tid);


    /**
     *  删除教师
     */
    @Select("delete from teacher where Tid=#{tid}")
    public void deleteTeacherInfoByAdmin(String tid);


    /**
     *  获取 所有的 课程
     *
     *  有其他的 mapper 已经实现  getStuCourseAllselect
     */


    /**
     *  修改课程信息
     */
    @Select("UPDATE course SET `Cname` = #{cname}, `Cintroduction` = #{cintroduction}, `Type` = #{type}, " +
            "`Belongcoll` = #{belongcoll}, `Belongpro` = #{belongpro} WHERE (`Cid` = #{cid})")
    public void updateCourseInfoByAdmin(@Param("cname") String cname,@Param("cintroduction")String cintroduction,@Param("type")String type,
                                        @Param("belongcoll")String belongcoll,@Param("belongpro")String belongpro,@Param("cid")String cid);

    /**
     *  添加课程信息
     */
    @Select("INSERT INTO course (`Cid`, `Cname`, `Cintroduction`, `Type`, `Belongcoll`, `Belongpro`) " +
            "VALUES (#{cid}, #{cname}, #{cintroduction}, #{type}, #{belongcoll}, #{belongpro})")
    public void addCourseInfoByAdmin(@Param("cname")String cname,@Param("cintroduction")String cintroduction,@Param("type")String type,
                                     @Param("belongcoll")String belongcoll,@Param("belongpro")String belongpro,@Param("cid")String cid);

    /**
     *  删除课程信息
     */
    @Select("delete from course where Cid = #{cid}")
    public void deleteCourseByAdmin(String cid);




}
