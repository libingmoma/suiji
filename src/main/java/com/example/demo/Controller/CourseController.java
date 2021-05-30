package com.example.demo.Controller;

import com.example.demo.Base.BaseController;
import com.example.demo.Model.Content;
import com.example.demo.Model.Course;
import com.example.demo.Service.CourseService;
import com.example.demo.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/search" , produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "按照星期几返回课表", notes = "通过星期几来返回课程信息")
    public String search(@ApiParam(name = "week", value = "星期几上课", required = true) @RequestParam String week) {
        List<Course> results;
        results=courseService.searchByWeek(week);
        return FastJsonUtils.resultSuccess(200, "搜索课表成功", results);
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改课程信息", notes = "修改课程信息")
    public String updateInfo(@ApiParam(name = "coursename", value = "课程名称",required = true)@RequestParam String coursename,
                             @ApiParam(name = "classroomid", value = "教室编号")@RequestParam(required = false, defaultValue = "") long classroomid,
                             @ApiParam(name = "teachername", value = "老师名字")@RequestParam(required = false, defaultValue = "") String teachername,
                             @ApiParam(name = "time", value = "上课时间")@RequestParam(required = false, defaultValue = "") String time,
                             @ApiParam(name = "week", value = "星期几上课")@RequestParam(required = false, defaultValue = "") String week
    ) {
        Course newCou=courseService.searchByCourseName(coursename).get(0);
        if(!"".equals(classroomid))
            newCou.setClassroomid(classroomid);
        if(!"".equals(teachername))
            newCou.setTeachername(teachername);
        if(!"".equals(time))
            newCou.setTime(time);
        if(!"".equals(week))
            newCou.setWeek(week);
        courseService.update(newCou);
        return FastJsonUtils.resultSuccess(200, "修改成功", null);
    }
    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "删除课程", notes = "删除课程")
    public String delete(@ApiParam(name = "coursename", value = "课程名称", required = true) @RequestParam String coursename) {
        courseService.deleteByCourseName(coursename);
        Map<String, Object> result = new HashMap<>();
        result.put("coursename", coursename);
        return FastJsonUtils.resultSuccess(200, "删除课程成功", result);
    }

    @ResponseBody
    @PostMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加课程", notes = "添加课程")
    public String insert(@ApiParam(name = "coursename", value = "课程名称", required = true) @RequestParam String coursename,
                         @ApiParam(name = "classroomid", value = "教室编号", required = true) @RequestParam long classroomid,
                         @ApiParam(name = "teachername", value = "老师名字", required = true) @RequestParam String teachername,
                         @ApiParam(name = "time", value = "上课时间", required = true) @RequestParam String time,
                         @ApiParam(name = "week", value = "星期几上课", required = true) @RequestParam String week) {
        System.out.println(coursename);
        long courseid = super.getIdGeneratorUtils().nextId();
        Course course = new Course(courseid, coursename, classroomid, teachername, time,week);
        courseService.insertCourse(course);
        Map<String, Object> result = new HashMap<>();
        result.put("courseid", courseid);
        return FastJsonUtils.resultSuccess(200, "保存内容成功", result);
    }
}