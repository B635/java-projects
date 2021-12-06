package com.example.illustrated_guide.controller;

import com.example.illustrated_guide.bean.Users;
import com.example.illustrated_guide.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String account, String passwd) {
        Users user = usersService.loginIn(account, passwd);
        if (user.getAdmin()) {
            return "管理员";
        } else {
            return "用户";
        }
    }
}
