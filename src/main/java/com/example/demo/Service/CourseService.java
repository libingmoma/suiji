package com.example.demo.Service;

import com.example.demo.Base.BaseServiceImpl;
import com.example.demo.Dao.CourseDao;
import com.example.demo.Model.Course;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CourseService extends BaseServiceImpl<Course> {

    @Resource
    private CourseDao courseDao;

    @Override
    public Mapper<Course> getMapper() {
        return courseDao;
    }


    public List<Course> showAllCourse() {

        return courseDao.selectAll();
    }
    public void deleteCourse(long courseid) {
        courseDao.deleteCourse(courseid);
    }
    public void insertCourse(long courseid) {
        courseDao.insertCourse(courseid);
    }


}