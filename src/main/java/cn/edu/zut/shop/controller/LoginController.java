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

    @ResponseBody
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result login(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", result.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        User u = null;
        u = userService.findByName(user.getUsername());
        if (!Objects.equals(u.getUsername(), user.getUsername()) || !Objects.equals(u.getPassword(), user.getPassword())) {
            String message = String.format("登陆失败，详细信息【用户名或密码错误】。");
            return ResultFactory.buildFailResult(message);
        }
        Message data = messageService.findByUsername(user.getUsername());
        return ResultFactory.buildSuccessResult(data);
    }
}
