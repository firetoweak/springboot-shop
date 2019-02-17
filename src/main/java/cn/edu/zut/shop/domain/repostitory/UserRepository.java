package cn.edu.zut.shop.domain.repostitory;

import cn.edu.zut.shop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
