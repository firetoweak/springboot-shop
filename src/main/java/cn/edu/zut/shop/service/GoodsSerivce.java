package cn.edu.zut.shop.service;

import cn.edu.zut.shop.domain.entity.Goods;

/**
 * @author liuhao on 2019/2/22 0022
 * @description 商品类的业务逻辑接口
 */
public interface GoodsSerivce extends BaseService<Goods>{
    void updataCountByName(Integer count,String name);
    Goods findByName(String name);
}
