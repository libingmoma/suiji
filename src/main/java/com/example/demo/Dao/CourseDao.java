package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Course;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface CourseDao extends MyMapper<Course> {
    @Select(value = "select * from course")
    List<Course> selectAll();
    void insertCourse(long course_id);
    void deleteCourse(long course_id);
}