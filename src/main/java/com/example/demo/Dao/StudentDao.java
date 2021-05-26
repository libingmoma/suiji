package com.example.demo.Dao;
import com.example.demo.Model.Student;
import com.example.demo.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Collection;
import java.util.List;

public interface StudentDao extends MyMapper<Student> {

    @Select(value = "select * from student")
    List<Student> selectAll();

    void insertStudent(Student student);

    @Select(value = "select * from student where uid=#{uid}")
    List<Student> selectByUid(@Param(value = "uid") long uid);

    List<Student> selectByDescription(String description);

    @Select(value = "select * from student where phone=#{phone}")
    List<Student> selectByPhone(String phone);
    List<Student> selectByPhoneAndPassword(Student stu);

    @Update(value = "update student set name=#{name}, password=#{password}, description=#{description} where uid=#{uid}")
    void updateByUid(Student newStu);
    //List<Student> selectByYearInterval(@Param("left") Integer left,@Param("right") Integer right);
}
