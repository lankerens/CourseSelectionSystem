package com.lankeren.ssm.beans;

public class CourseAp {

    private String courseclass;  // 开课班级
    private String coursetime;  // 上课时间
    private String courseweek;   // 上课周
    private String cid;  // 课程号
    private String tid;    //教师编号
    private String classroom;  // 上课教室
    private Integer credits;    // 学分
    private Integer period;   // 学时
    private Integer totalnum;  // 总人数
    private String cname;
    private Integer hadNum;

    public CourseAp() {
    }

    public CourseAp(String courseclass, String coursetime, String courseweek, String cid, String tid, String classrooom, Integer credits, Integer period, Integer totalnum) {
        this.courseclass = courseclass;
        this.coursetime = coursetime;
        this.courseweek = courseweek;
        this.cid = cid;
        this.tid = tid;
        this.classroom = classrooom;
        this.credits = credits;
        this.period = period;
        this.totalnum = totalnum;
    }

    public CourseAp(Integer totalnum, String cname, Integer hadNum) {
        this.totalnum = totalnum;
        this.cname = cname;
        this.hadNum = hadNum;
    }

    public Integer getHadNum() {
        return hadNum;
    }

    public void setHadNum(Integer hadNum) {
        this.hadNum = hadNum;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCourseclass() {
        return courseclass;
    }

    public void setCourseclass(String courseclass) {
        this.courseclass = courseclass;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getCourseweek() {
        return courseweek;
    }

    public void setCourseweek(String courseweek) {
        this.courseweek = courseweek;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classrooom) {
        this.classroom = classrooom;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }
}
