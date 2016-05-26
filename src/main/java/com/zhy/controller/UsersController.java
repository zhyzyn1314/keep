package com.zhy.controller;

import com.zhy.bean.Users;
import com.zhy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    //private static Logger log = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    private Users users;

    @RequestMapping(method = RequestMethod.GET)
    public String showUsers(ModelMap model) {
        //log.debug("This is log test: {}", "test");
        users = userService.getUserById(1);
        model.addAttribute("users", users);
        return "showUsers";
    }

    //url:/users/showuser?userid=1
    @RequestMapping(value = "/showuser", method = RequestMethod.GET)
    public String showUsers2(@RequestParam("userid") Integer userid, Model model) {
        //log.debug("the userid is: {}", userid);
        users = userService.getUserById(userid);
        model.addAttribute(users);
        return "showUsers";
    }

    //url:/users/showuser2/1
    @RequestMapping("/showuser2/{userid}")
    public String showUsers3(@PathVariable("userid") Integer userid, Map<String, Object> model) {
        //log.debug("the userid is: {}", userid);
        users = userService.getUserById(userid);
        model.put("users", users);
        return "showUsers";
    }

    //url:/users/showuser3?userid=1
    @RequestMapping("/showuser3")
    public String showUsers4(HttpServletRequest request) {
        Integer userid = Integer.valueOf(request.getParameter("userid"));
        //log.debug("the userid is: {}", userid);
        users = userService.getUserById(userid);
        request.setAttribute("users", users);
        return "showUsers";
    }

    //url:/users/admin?add
    @RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
    public String createUser() {
        return "editUser";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String doSave(@ModelAttribute Users user){
        //log.debug("Info of Course:");
        //log.debug(user.toString());
        return "redirect:showuser2/" + user.getId();
    }
}


























