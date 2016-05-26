package com.zhy.controller;

import com.zhy.bean.Message;
import com.zhy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/mybatis")
public class MybatisDemoController {

    @Autowired
    private MessageService messageService;

    private List<Message> messages;

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model){
        messages = messageService.getMessage();
        model.addAttribute("messages", messages);
        return "mybatisDemo/list";
    }
}
