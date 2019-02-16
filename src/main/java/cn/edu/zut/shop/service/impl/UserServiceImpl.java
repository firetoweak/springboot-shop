package cn.edu.zut.shop.service.impl;

import cn.edu.zut.shop.domain.entity.User;
import cn.edu.zut.shop.domain.repostitory.UserRepository;
import cn.edu.zut.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids) {
            userRepository.delete(id);
        }
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }
}