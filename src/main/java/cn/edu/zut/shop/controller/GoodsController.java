package cn.edu.zut.shop.controller;

import cn.edu.zut.shop.domain.entity.Goods;
import cn.edu.zut.shop.domain.entity.Result;
import cn.edu.zut.shop.service.GoodsSerivce;
import cn.edu.zut.shop.tools.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author liuhao on 2019/2/22 0022
 * @description 商品的页面访问控制
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsSerivce goodsSerivce;

    @ResponseBody
    @RequestMapping(value = "/api/shopping", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result goods(@Valid @RequestBody Goods[] products, BindingResult result) {
        String message = null;
        for (int i = 0; i < products.length; i++) {
            Goods goods = goodsSerivce.findByName(products[i].getName());
            if (0 == goods.getCount() || 0 > goods.getCount() - products[i].getCount()) {
                message += products[i].getName() + "数量不足";
                return ResultFactory.buildFailResult(message);
            }
        }
        for (int i = 0; i < products.length; i++) {
            Goods goods = goodsSerivce.findByName(products[i].getName());
            if (goods.getCount() > products[i].getCount() || goods.getCount() == products[i].getCount()) {
                Integer suiplus = goods.getCount() - products[i].getCount();
                goodsSerivce.updataCountByName(suiplus, products[i].getName());
            }
        }
        return ResultFactory.buildSuccessResult("成功");
    }
}
