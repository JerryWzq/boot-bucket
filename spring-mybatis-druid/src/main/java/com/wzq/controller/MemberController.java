package com.wzq.controller;

import com.wzq.service.MemberService;
import com.wzq.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 类描述:
 * member成员的控制层
 *
 * @author
 * @version 1.0.0
 * @date 2018-11-29 11:37
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService service;

    @RequestMapping("/getMember")
    @ResponseBody
    public Member getMemberById(){
        return service.getMemberById(1);
    }

}