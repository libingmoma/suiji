package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Course;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CourseDao extends MyMapper<Course> {
    @Select(value = "select * from course")
    List<Course> selectAll();
    void insertCourse(long courseid);
    void deleteByCourseId(long courseid);
    @Select(value = "select * from course where classroomid=#{classroomid}")
    List<Course> selectByClassroomId(long classroomid);

    List<Course> selectByCourseName(@Param("coursename") String coursename);

    @Select(value = "select * from course where teachername=#{teachername}")
    List<Course> selectByTeacherName(@Param("teachername") String teachername);
}