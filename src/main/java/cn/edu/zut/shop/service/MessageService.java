package cn.edu.zut.shop.service;

import cn.edu.zut.shop.domain.entity.Message;

import java.util.Optional;

public interface MessageService extends BaseService<Message>{
    Optional<Message> findById(Long id);
    Message findByUsername(String usrname);
}
