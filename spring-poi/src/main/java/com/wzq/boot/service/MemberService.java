package com.wzq.boot.service;

import com.wzq.boot.mapper.MemberMapper;
import com.wzq.boot.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Member> selectList(){
        return memberMapper.selectList();
    }

}