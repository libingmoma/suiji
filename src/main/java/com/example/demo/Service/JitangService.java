package com.example.demo.Service;

import com.example.demo.Base.BaseServiceImpl;
import com.example.demo.Dao.JitangDao;
import com.example.demo.Model.Jitang;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;
@Service
public class JitangService extends BaseServiceImpl<Jitang> {

    @Resource
    private JitangDao jitangDao;

    @Override
    public Mapper<Jitang> getMapper() {
        return jitangDao;
    }


    public List<Jitang> showAlljitang() {

        return jitangDao.selectAll();
    }

    public void deleteJitang(String content) {
        jitangDao.deleteJitang(content);
    }
    public void insertJitang(String newcontent) {
        jitangDao.insertJitang(newcontent);
    }

}
