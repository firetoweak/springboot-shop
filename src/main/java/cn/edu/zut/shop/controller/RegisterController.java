package cn.edu.zut.shop.controller;

import cn.edu.zut.shop.domain.entity.Result;
import cn.edu.zut.shop.domain.entity.User;
import cn.edu.zut.shop.service.UserService;
import cn.edu.zut.shop.tools.ResultFactory;
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
        if (result.hasErrors()) {
            String message = String.format( result.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        userService.create(user);
        return ResultFactory.buildSuccessResult("注册成功。");
    }
}
