package cn.edu.zut.shop.controller;

import cn.edu.zut.shop.domain.entity.Message;
import cn.edu.zut.shop.domain.entity.Result;
import cn.edu.zut.shop.service.MessageService;
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
public class MessageController {
    @Autowired
    private MessageService service;

    /**
     * 给User对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
     * 在逻辑处理中判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     * message返回user的个人信息
     */
    @ResponseBody
    @RequestMapping(value = "/api/messageChange", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result message(@Valid @RequestBody Message message, BindingResult result) {
        if (result.hasErrors()) {
            String data = String.format("信息更改失败，详细信息[%s]。", result.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(data);
        }
        if (null != service.findByUsername(message.getUsername())) {
            service.update(message);
        } else {
            service.create(message);
        }
        return ResultFactory.buildSuccessResult(message);
    }
}
