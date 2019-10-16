package com.lankeren.ssm.beans;

public class Teacher {

    private String tid;   //工号
    private String tname;  // 姓名
    private String tpassword;  // 密码
    private String tsex;    // 性别
    private String introduction;   // 简介.

    public Teacher() {
    }

    public Teacher(String tid, String tname, String tpassword, String tsex, String tntroduction) {
        this.tid = tid;
        this.tname = tname;
        this.tpassword = tpassword;
        this.tsex = tsex;
        this.introduction = tntroduction;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String tntroduction) {
        this.introduction = tntroduction;
    }
}
