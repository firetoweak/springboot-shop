package cn.edu.zut.shop.service;

import cn.edu.zut.shop.domain.entity.User;

public interface UserService extends BaseService<User> {

    User findByName(String name);
}
