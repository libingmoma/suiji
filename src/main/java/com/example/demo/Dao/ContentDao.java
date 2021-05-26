package com.example.demo.Dao;

import com.example.demo.Model.Content;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContentDao extends MyMapper<Content> {

    @Select(value = "select * from content")
    List<Content> selectAll();

    void insertContent(Content content);


    @Select(value = "select * from content where ctype=#{ctype}")
    List<Content> selectByCtype(@Param("ctype") int ctype);

    void deleteByRtime(String rtime);

    @Select(value = "select * from content where rtime=#{rtime}")
    List<Content> selectByRtime(String rtime);
}