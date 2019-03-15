package com.wzq.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述:
 *
 * @author
 * @date 2019-03-08 17:28
 */
@RestController
public class TestController {

    @RequestMapping("/echo")
    public Object echo(){
        return "启动成功";
    }

}