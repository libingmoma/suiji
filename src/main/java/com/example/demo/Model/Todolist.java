package com.example.demo.Model;

import com.example.demo.Base.BaseEntity;

import javax.persistence.Column;

import javax.persistence.Table;



@Table(name = "`todolist`")
public class Todolist extends BaseEntity {
    @Column(name = "`todoid`")
    private long todoid;

    @Column(name = "`todo`")
    private String todo;

    @Column(name = "`ddl`")
    private String ddl;

    public Todolist(long todoid, String todo,String ddl) {
        this.todoid = todoid;
        this.todo = todo;
        this.ddl = ddl;
    }

    public Todolist() {

    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getTodo() { return todo; }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }
}
