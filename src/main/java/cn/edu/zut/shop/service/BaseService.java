package cn.edu.zut.shop.service;

import java.util.List;

public interface BaseService<T> {
    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();

    /**
     * 添加
     *
     * @param t
     */
    void create(T t);

    /**
     * 删除（批量）
     *
     * @param ids
     */
    void delete(Long... ids);

    /**
     * 修改
     *
     * @param t
     */
    void update(T t);
}
