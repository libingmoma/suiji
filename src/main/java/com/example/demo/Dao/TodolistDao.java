package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Course;
import com.example.demo.Model.Todolist;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface TodolistDao extends MyMapper<Todolist> {
    @Select(value = "select * from todolist")
    List<Todolist> selectAll();
    void insertTodolist(String todo,String ddl);
    void deleteTodolist(String todo);
}