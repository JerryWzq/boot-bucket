/*
 * Copyright [2018]
 * 顺丰科技开源(opensource@sfmail.sf-express.com)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wzq.service;

import com.wzq.mapper.MemberMapper;
import com.wzq.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述:
 * member成员的服务类
 *
 * @author 顺丰科技开源(opensource @ sfmail.sf - express.com)
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