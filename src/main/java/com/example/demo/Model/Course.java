package com.example.demo.Model;

import com.example.demo.Base.BaseEntity;

import javax.persistence.Column;

import javax.persistence.Table;


@Table(name = "`course`")
public class Course extends BaseEntity {
    @Column(name = "`course_id`")
    private long course_id;

    @Column(name = "`course_name`")
    private String course_name;

    @Column(name = "`classroom_id`")
    private long classroom_id;

    @Column(name = "`teacher_name`")
    private String teacher_name;



    public Course(long course_id, String course_name,long classroom_id, String teacher_name) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.classroom_id = classroom_id;
        this.teacher_name = teacher_name;
    }

    public Course() {

    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public long getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(long classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
