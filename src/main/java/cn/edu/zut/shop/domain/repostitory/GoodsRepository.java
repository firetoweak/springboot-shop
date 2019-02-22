package cn.edu.zut.shop.domain.repostitory;

import cn.edu.zut.shop.domain.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuhao on 2019/2/22 0022
 * @description 商品类的数据访问接口
 */
@Transactional
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Goods findByName(String name);

    @Modifying
    @Query(value = "update products set count= :count where name = :name", nativeQuery = true)
    void updateCountByName(@Param("count") Integer count, @Param("name") String name);
}
