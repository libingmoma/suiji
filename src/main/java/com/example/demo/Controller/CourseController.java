package com.example.demo.Controller;

import com.example.demo.Base.BaseController;
import com.example.demo.Model.Course;
import com.example.demo.Service.CourseService;
import com.example.demo.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/course")
@Api(description = "课程接口")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    /**
     * 列表测试
     */

    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "全部课程", notes = "全部课程")
    public String all() {
        List<Course> result = courseService.showAllCourse();
        return FastJsonUtils.resultSuccess(200, "拉取课程列表成功", result);
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "删除课程", notes = "删除课程")
    public String delete(@ApiParam(name = "courseid", value = "课程id",required = true) @RequestParam long courseid){
        courseService.deleteCourse(courseid);
        Map<String, Object> result = new HashMap<>();
        result.put("courseid", courseid);
        return FastJsonUtils.resultSuccess(200, "删除课程成功", result);
    }

    @GetMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加课程", notes = "添加课程")
    public String insert(@ApiParam(name = "courseid", value = "课程id",required = true) @RequestParam long courseid){
        courseService.insertCourse(courseid);
        Map<String, Object> result = new HashMap<>();
        result.put("course_id", courseid);
        return FastJsonUtils.resultSuccess(200, "添加课程成功", result);
    }
}