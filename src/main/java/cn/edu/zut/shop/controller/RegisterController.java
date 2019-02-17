package cn.edu.zut.shop.controller;

import cn.edu.zut.shop.domain.entity.Result;
import cn.edu.zut.shop.domain.entity.User;
import cn.edu.zut.shop.service.UserService;
import cn.edu.zut.shop.service.ret.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/api/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result register(@Valid @RequestBody User user, BindingResult result) {
        System.out.println("通过了Post,但没有通过注册操作");
        if (result.hasErrors()) {
            String message = String.format("注册失败，详细信息[%s]。", result.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        userService.create(user);
        System.out.println("通过了注册操作");
        System.out.println("注册完成，可在数据库中查询到！");
        return ResultFactory.buildSuccessResult("注册成功。");
    }
}
