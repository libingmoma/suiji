package com.example.demo.Model;

import com.alibaba.fastjson.annotation.JSONType;
import com.example.demo.Base.BaseEntity;
import javax.persistence.Column;

import javax.persistence.Table;


@Table(name = "`course`")
@JSONType(orders = {"courseid","coursename","classroomid", "teachername", "time"})
public class Course extends BaseEntity {
    @Column(name = "`courseid`")
    private long courseid;

    @Column(name = "`coursename`")
    private String coursename;

    @Column(name = "`classroomid`")
    private long classroomid;

    @Column(name = "`teachername`")
    private String teachername;

    @Column(name = "`time`")
    private String time;

    public Course(long courseid, String coursename,long classroomid, String teachername,String time) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.classroomid = classroomid;
        this.teachername = teachername;
        this.time = time;
    }

    public Course() {

    }

    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public long getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(long classroomid) {
        this.classroomid = classroomid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {

        this.teachername = teachername;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
