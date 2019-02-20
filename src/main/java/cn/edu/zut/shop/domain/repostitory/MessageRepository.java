package cn.edu.zut.shop.domain.repostitory;

import cn.edu.zut.shop.domain.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Optional<Message> findById(Long id);
    Message findByUsername(String username);
}
