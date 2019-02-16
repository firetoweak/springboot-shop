package cn.edu.zut.shop.domain.repostitory;

import cn.edu.zut.shop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String name);

    void create(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();
}
