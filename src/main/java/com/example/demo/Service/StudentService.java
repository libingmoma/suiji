package com.example.demo.Service;

import com.example.demo.Base.BaseServiceImpl;
import com.example.demo.Dao.StudentDao;
import com.example.demo.Model.Student;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

//import com.space.movie.moviespacesimpleserver.contants.Constant;
//import com.space.movie.moviespacesimpleserver.util.EncryptUtil;
//import com.space.movie.moviespacesimpleserver.util.FastJsonUtils;

@Service
public class StudentService extends BaseServiceImpl<Student> {
    @Resource
    private StudentDao studentDao;

    @Override
    public Mapper<Student> getMapper() {
        return studentDao;
    }

    /**
     * 查询所有学生
     */
    public List<Student> showAllStudent() {
        return studentDao.selectAll();
    }

    public void addStudent(Student student) {
        studentDao.insertStudent(student);

    }

    public List<Student> searchByUid(long uid) {
        return studentDao.selectByUid(uid);
    }

    public List<Student> searchByDescription(String description) {
        return studentDao.selectByDescription(description);
    }

    public boolean auth(Student stu) {
        return studentDao.selectByPhoneAndPassword(stu).size()==1;
    }
    public List<Student> SelectByPhone(String phone) {
        return studentDao.selectByPhone(phone);
    }

    public void update(Student newStu) {
        studentDao.updateByUid(newStu);
    }
    //public PageInfo<Film> getFilmList(Film record) {
    //}
}