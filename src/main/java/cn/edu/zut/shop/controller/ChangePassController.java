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
import java.util.Objects;

/**
 * @author liuhao on 2019/3/3 0003
 * @description 修改密码
 */
@Controller
public class ChangePassController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/api/changePass",method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result changePass(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        User userFromMysql = userService.findByName(user.getUsername());
        if (null == userFromMysql||!Objects.equals(userFromMysql.getPassword(), user.getPassword())){
            return ResultFactory.buildFailResult("用户名不存在！！！");
        }else {
           /* User userToMysql = new User();
            userToMysql.setUsername(user.getUsername());
            userToMysql.setPassword(user.getChangePass());
            userService.update(userToMysql);*/
           userService.updatePassByUsername(user.getChangePass(),user.getUsername());
        }
        return ResultFactory.buildSuccessResult("修改成功！");
    }
}
