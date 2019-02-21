package cn.edu.zut.shop.domain.repostitory;

import cn.edu.zut.shop.domain.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * 用id查询所有
     */
    Optional<Message> findById(Long id);

    /**
     * 用username查询
     */
    Message findByUsername(String username);
}
