package com.wzq.service;

import com.wzq.mapper.MemberMapper;
import com.wzq.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述:
 * member成员的服务类
 *
 * @author
 * @version 1.0.0
 * @date 2018-11-29 11:39
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public Member getMemberById(Integer id){
        return memberMapper.findObjectById(id);
    }

}