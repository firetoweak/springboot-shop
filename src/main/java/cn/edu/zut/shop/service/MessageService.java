package cn.edu.zut.shop.service;

import cn.edu.zut.shop.domain.entity.Message;

import java.util.Optional;

public interface MessageService extends BaseService<Message> {
    /**
     * 用id查询所有
     */
    Optional<Message> findById(Long id);

    /**
     * 用username查询
     */
    Message findByUsername(String username);
}
