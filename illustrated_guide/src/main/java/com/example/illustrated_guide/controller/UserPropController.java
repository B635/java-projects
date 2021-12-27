package com.example.illustrated_guide.controller;

import com.example.illustrated_guide.bean.Props;
import com.example.illustrated_guide.service.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**********************************************************************
 Interfaces in this module:
 showProps()           <-- GET   /userProps
 deleteProps()         <-- POST  /deleteProp/{id}
 changeProps()         <-- POST  /changeProp/{id}
 addProps()            <-- POST  /addProp/{id}
 verifyProp()          <-- POST  /searchProp/{id}

 use Map<String, String> to represent json
 *********************************************************************/


@Controller
public class UserPropController {
    @Autowired
    PropsService propsService;

    @ResponseBody
    @RequestMapping("/userProps")
    public List<Props> showProps() {
        return propsService.showAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteProp/{id}", method = RequestMethod.POST)
    public void deleteProps(@PathVariable int id) {
        propsService.deleteProp(id);
    }

    @ResponseBody
    @RequestMapping(value = "/changeProp/{id}", method = RequestMethod.POST)
    public void changeProps(
            @PathVariable int id,
            @RequestBody Map<String, String> body
    ) {
        Props result = new Props(id, body.get("name"), body.get("description"), body.get("place"), body.get("effect"));
        propsService.changeProp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/addProp/{id}", method = RequestMethod.POST)
    public void addProps(
            @PathVariable int id,
            @RequestBody Map<String, String> body
    ) {
        Props result = new Props(id, body.get("name"), body.get("description"), body.get("place"), body.get("effect"));
        propsService.addProp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/searchProp/{id}", method = RequestMethod.POST)
    public String verifyProp(
            @PathVariable int id
    ) {
        Props props = propsService.getProp(id);
        if (props == null) {
            return "PropMissed";
        } else {
            return "true";
        }
    }
}
