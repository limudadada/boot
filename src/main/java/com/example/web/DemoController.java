package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/test")
public class DemoController {

    @RequestMapping("/do")
    @ResponseBody
    public Map<String,Object> test(){
        Map<String,Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }
}
