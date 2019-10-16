package com.lankeren.ssm.beans;

public class Course {

    private String cid;   // 课程号
    private String cname;    // 课程名
    private String cintroduction;   // 简介
    private String type;  // 类型( 必修选修 )
    private String belongcoll;   // 所属学院
    private String belongpro;   //  所属专业.

    public Course() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCintroduction() {
        return cintroduction;
    }

    public void setCintroduction(String cintroduction) {
        this.cintroduction = cintroduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBelongcoll() {
        return belongcoll;
    }

    public void setBelongcoll(String belongcoll) {
        this.belongcoll = belongcoll;
    }

    public String getBelongpro() {
        return belongpro;
    }

    public void setBelongpro(String belongpro) {
        this.belongpro = belongpro;
    }

    public Course(String cid, String cname, String cintroduction, String type, String belongcoll, String belongpro) {
        this.cid = cid;
        this.cname = cname;
        this.cintroduction = cintroduction;
        this.type = type;
        this.belongcoll = belongcoll;
        this.belongpro = belongpro;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", cintroduction='" + cintroduction + '\'' +
                ", type='" + type + '\'' +
                ", belongcoll='" + belongcoll + '\'' +
                ", belongpro='" + belongpro + '\'' +
                '}';
    }
}
