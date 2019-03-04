package cn.edu.zut.shop.service;

import cn.edu.zut.shop.domain.entity.User;

public interface UserService extends BaseService<User> {
    /**
     * 用username查询
     */
    User findByName(String name);

    void updatePassByUsername(String password, String username);
}
