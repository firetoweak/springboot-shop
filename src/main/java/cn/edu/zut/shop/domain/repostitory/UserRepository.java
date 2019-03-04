package cn.edu.zut.shop.domain.repostitory;

import cn.edu.zut.shop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 用username查询
     */
    User findByUsername(String name);

    @Modifying
    @Query(value = "update user set password= :password where username = :username", nativeQuery = true)
    void updatePassByUsername(@Param("password") String password, @Param("username") String username);
}
