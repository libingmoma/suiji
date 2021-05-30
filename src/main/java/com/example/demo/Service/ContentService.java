package com.example.demo.Service;

import com.example.demo.Base.BaseServiceImpl;
import com.example.demo.Dao.ContentDao;
import com.example.demo.Model.Content;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContentService extends BaseServiceImpl<Content> {
    @Resource
    private ContentDao contentDao;

    @Override
    public Mapper<Content> getMapper() {

        return contentDao;
    }

    /**
     * 查询所有商品
     */
    public List<Content> showAllContent() {
        return contentDao.selectAll();
    }

    public void addContent(Content content) {
        contentDao.insertContent(content);
    }

    /**
     * 根据名字查询商品
     */
    public List<Content> searchByRtime(String rtime) {
        return contentDao.selectByRtime(rtime);
    }


    /**
     * 根据gid删除商品
     */
    public void deleteByRtime(String rtime) {
        contentDao.deleteByRtime(rtime);
    }


}
