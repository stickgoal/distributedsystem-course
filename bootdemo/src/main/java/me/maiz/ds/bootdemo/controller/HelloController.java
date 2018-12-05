package me.maiz.ds.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("hello")
    @ResponseBody
    public Map<String, Object> sayHello() {
        Map<String, Object> data = new HashMap<>();
        data.put("hello", "boot");
        return data;
    }

}
