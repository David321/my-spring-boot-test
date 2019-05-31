package com.davidcorp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value="index")
    public String index(){
        return "这是首页";
    }
}