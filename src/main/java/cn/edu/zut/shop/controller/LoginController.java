package cn.edu.zut.shop.controller;

import cn.edu.zut.shop.domain.entity.Result;
import cn.edu.zut.shop.domain.entity.User;
import cn.edu.zut.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class LoginController {

    @Autowired
    private UserService userService;


    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/blogLogin")
    public Result login(@RequestBody User user) {
        Result result = new Result();
        List<User> list = new ArrayList<>();
        return result;
        /*if (result.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", result.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        if (!Objects.equals("liuhao", user.getUsername()) || !Objects.equals("123", user.getPassword())) {
            String message =String.format("登陆失败，详细信息【用户名或密码错误】。");
            return ResultFactory.buildFailResult(message);
        }
        return ResultFactory.buildSuccessResult("登陆成功。");*/
    }
}
