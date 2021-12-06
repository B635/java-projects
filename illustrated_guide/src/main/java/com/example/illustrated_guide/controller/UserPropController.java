package com.example.illustrated_guide.controller;

import com.example.illustrated_guide.service.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserPropController {
    @Autowired
    PropsService propsService;

    @RequestMapping("/userprops")
    public String showProps() {
        return "";
    }
}
