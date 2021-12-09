package com.example.illustrated_guide.controller;

import com.example.illustrated_guide.bean.Props;
import com.example.illustrated_guide.service.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserPropController {
    @Autowired
    PropsService propsService;

    @ResponseBody
    @RequestMapping("/userprops")
    public List<Props> showProps() {
        return propsService.showAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteprop/{id}", method = RequestMethod.POST)
    public void deleteProps(@PathVariable int id) {
        propsService.deleteProp(id);
    }

    @ResponseBody
    @RequestMapping(value = "/changeprop/{id}", method = RequestMethod.POST)
    public void changeProps(
            @PathVariable int id,
            @RequestBody Map<String, String> body
    ) {
        Props result = new Props(id, body.get("name"), body.get("description"), body.get("place"), body.get("effect"));
        propsService.changeProp(result);
    }
}
