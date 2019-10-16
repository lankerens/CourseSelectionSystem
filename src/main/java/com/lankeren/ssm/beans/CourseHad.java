package com.lankeren.ssm.beans;

import java.util.List;

public class CourseHad {

    public String cname;

    public Teacher teacher;

    public List<CourseAp> allCourseAp;


    public CourseHad() {
    }

    public CourseHad(String cname, Teacher teacher, List<CourseAp> allCourseAp) {
        this.cname = cname;
        this.teacher = teacher;
        this.allCourseAp = allCourseAp;
    }

    public CourseHad(String cname, List<CourseAp> allCourseAp) {
        this.cname = cname;
        this.allCourseAp = allCourseAp;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<CourseAp> getAllCourseAp() {
        return allCourseAp;
    }

    public void setAllCourseAp(List<CourseAp> allCourseAp) {
        this.allCourseAp = allCourseAp;
    }
}
