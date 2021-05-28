package com.example.demo.Service;

import com.example.demo.Base.BaseServiceImpl;
import com.example.demo.Dao.TodolistDao;

import com.example.demo.Model.Todolist;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TodolistService extends BaseServiceImpl<Todolist> {

    @Resource
    private TodolistDao todolistDao;

    @Override
    public Mapper<Todolist> getMapper() {
        return todolistDao;
    }


    public List<Todolist> showAllcourse() {

        return todolistDao.selectAll();
    }
    public void deleteTodolist(String todo) {
        todolistDao.deleteTodolist(todo);
    }
    public void insertTodolist(String todo,String ddl) {
        todolistDao.insertTodolist(todo,ddl);
    }
}