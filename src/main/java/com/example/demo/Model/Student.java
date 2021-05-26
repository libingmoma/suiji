package com.example.demo.Model;
import com.alibaba.fastjson.annotation.JSONType;
import com.example.demo.Base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "`student`")
@JSONType(orders = {"uid","name","password", "description", "phone"})
public class Student extends BaseEntity {

    /**
     * uid
     */
    @Column(name = "`uid`")
    private long uid;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 描述
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 描述
     */
    @Column(name = "`description`")
    private String description;

    /**
     * 电话
     */
    @Column(name = "`phone`")
    private String phone;

    public Student(long uid,String name, String password, String description, String phone) {
        this.uid = uid;
        this.name= name;
        this.password = password;
        this.description = description;
        this.phone = phone;
    }


    public Student() {

    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}