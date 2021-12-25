package com.example.illustrated_guide.controller;

import com.example.illustrated_guide.bean.Users;
import com.example.illustrated_guide.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    UsersService usersService;

    @ResponseBody
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(
            @RequestBody Map<String, String> body
    ) {

        Users user = usersService.loginIn(body.get("account"), body.get("password"));
        if (user == null) {
            return "AccountMissed";
        } else {
            return String.valueOf(user.getAdmin());
        }
    }
}
