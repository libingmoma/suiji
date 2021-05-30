package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Jitang;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Select;

public interface JitangDao extends MyMapper<Jitang>{
    @Select(value = "select * from jitang")
    List<Jitang> selectAll();
    void insertJitang(String newcontent);
    void deleteJitang(String content);
}
