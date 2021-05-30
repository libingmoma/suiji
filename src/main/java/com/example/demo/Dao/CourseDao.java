package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Course;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseDao extends MyMapper<Course> {
    @Select(value = "select * from course")
    List<Course> selectAll();
    void insertCourse(Course course);
    void deleteByCourseName(String coursename);

    List<Course> selectByWeek(String week);

    List<Course> selectByCourseName(@Param("coursename") String coursename);

    @Select(value = "select * from course where teachername=#{teachername}")
    List<Course> selectByTeacherName(@Param("teachername") String teachername);
    @Update(value = "update course set classroomid=#{classroomid}, teachername=#{teachername}, time=#{time} ,week=#{week}where coursename=#{coursename}")
    void updateByCourseName(Course newCou);
}