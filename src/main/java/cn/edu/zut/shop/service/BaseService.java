package cn.edu.zut.shop.service;

import java.util.List;

public interface BaseService<T> {
    /**
     * 查询所有
     */
    List<T> findAll();

    /**
     * 添加
     */
    void create(T t);


    /**
     * 修改
     */
    void update(T t);
}
