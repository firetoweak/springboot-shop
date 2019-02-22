package cn.edu.zut.shop.service.impl;

import cn.edu.zut.shop.domain.entity.Message;
import cn.edu.zut.shop.domain.repostitory.MessageRepository;
import cn.edu.zut.shop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public void create(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void update(Message message) {
        messageRepository.delete(message);
        messageRepository.save(message);
    }

    @Override
    public Message findByUsername(String username) {
        return messageRepository.findByUsername(username);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }
}
