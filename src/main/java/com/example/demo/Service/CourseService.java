package com.example.demo.Service;

import com.example.demo.Base.BaseServiceImpl;
import com.example.demo.Dao.CourseDao;
import com.example.demo.Model.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

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
    public void deleteByCourseId(long courseid) {
        courseDao.deleteByCourseId(courseid);
    }
    public void insertCourse(long courseid) {
        courseDao.insertCourse(courseid);
    }
    public Course searchByClassroomId(long classroomid) {
        List<Course> result = courseDao.selectByClassroomId(classroomid);
        if (result.size() != 1)
            return null;
        else return result.get(0);
    }
    public List<Course> searchByCourseName(String coursename) {
        return courseDao.selectByCourseName(coursename);
    }

    public List<Course> searchByTeacherName(String teachername) {
        return courseDao.selectByTeacherName(teachername);
    }


}