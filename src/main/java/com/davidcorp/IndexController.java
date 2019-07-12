package com.davidcorp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    /*
     * @Description
     * @Author DavidPeng
     * @Date 2019/7/12 22:37
     **/
    @RequestMapping(value="index")
    public String index(){
        return "这是首页";
    }
}
