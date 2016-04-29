package com.zhy.controller;

import com.zhy.bean.Users;
import com.zhy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    private Users users;

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model){
        users = userService.getUserById(1);
        model.addAttribute("users", users);
        return "showUsers";
    }
}
