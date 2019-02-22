package cn.edu.zut.shop.service.impl;

import cn.edu.zut.shop.domain.entity.Goods;
import cn.edu.zut.shop.domain.repostitory.GoodsRepository;
import cn.edu.zut.shop.service.GoodsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhao on 2019/2/22 0022
 * @description 商品类的业务逻辑实现
 */
@Service
public class GoodsServiceImpl implements GoodsSerivce {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public void updataCountByName(Integer count, String name) {
        goodsRepository.updateCountByName(count,name);
    }

    @Override
    public Goods findByName(String name) {
        return goodsRepository.findByName(name);
    }

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public void create(Goods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public void update(Goods goods) {
        goodsRepository.delete(goods);
        goodsRepository.save(goods);
    }
}
