package com.example.demo.Controller;

import com.example.demo.Base.BaseController;
import com.example.demo.Model.Course;
import com.example.demo.Model.Todolist;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.TodolistService;
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
@RequestMapping("/todolist")
@Api(description = "待办接口")
public class TodolistController extends BaseController {

    @Autowired
    private TodolistService todolistService;

    /**
     * 列表测试
     */

    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "全部待办", notes = "全部待办")
    public String all() {
        List<Todolist> result = todolistService.showAllcourse();
        return FastJsonUtils.resultSuccess(200, "拉取待办列表成功", result);
    }

    @GetMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "删除待办", notes = "删除待办")
    public String delete(@ApiParam(name = "todo", value = "待办",required = true) @RequestParam String todo){
        todolistService.deleteTodolist(todo);
        Map<String, Object> result = new HashMap<>();
        result.put("todo", todo);
        return FastJsonUtils.resultSuccess(200, "删除待办成功", result);
    }

    @GetMapping(value = "/insert", produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "添加待办", notes = "添加待办")
    public String insert(@ApiParam(name = "todo", value = "待办",required = true) @RequestParam String todo,
                         @ApiParam(name = "ddl", value = "待办ddl",required = true) @RequestParam String ddl){
        todolistService.insertTodolist(todo,ddl);
        Map<String, Object> result = new HashMap<>();
        result.put("todo", todo);
        return FastJsonUtils.resultSuccess(200, "添加待办成功", result);
    }
}