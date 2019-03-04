package cn.edu.zut.shop.controller;

import cn.edu.zut.shop.domain.entity.Message;
import cn.edu.zut.shop.domain.entity.Result;
import cn.edu.zut.shop.domain.entity.User;
import cn.edu.zut.shop.service.MessageService;
import cn.edu.zut.shop.service.UserService;
import cn.edu.zut.shop.tools.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    /**
     * 给User对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
     * 在逻辑处理中判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     * data返回user的个人信息
     */
    @ResponseBody
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        User userFromMysql = new User();
        userFromMysql = userService.findByName(user.getUsername());
        if (null == userFromMysql || !Objects.equals(userFromMysql.getPassword(), user.getPassword())) {
            String message = "登陆失败，用户名或密码不正确！";
            return ResultFactory.buildFailResult(message);
        }
        Message data = new Message();
        if (null != messageService.findByUsername(user.getUsername())) {
            data = messageService.findByUsername(user.getUsername());
        }
        data.setUsername(user.getUsername());
        return ResultFactory.buildSuccessResult(data);
    }
}
