package com.example.demo.Base;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

    List<T> select(T record);

    int selectCount(T record);

    T selectByPrimaryKey(Object key);

    int insert(T record);

    int insertSelective(T record);

    int delete(T record);

    int deleteByPrimaryKey(Object key);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    //int save(T record);

    //PageInfo<T> selectPage(int pageNum, int pageSize, T record);

    //PageInfo<T> selectPage(int pageNum, int pageSize, T record, String orderSqlStr);

    T selectOne(T record);
}
