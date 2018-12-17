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
package com.wzq.mapper;

import com.wzq.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 类描述:
 * member的mapper接口
 *
 * @author 顺丰科技开源(opensource @ sfmail.sf - express.com)
 * @version 1.0.0
 * @date 2018-11-29 11:30
 */
@Mapper
//该注解如果不加， 在service中自动注解idea会报红， 但是不影响功能
@Repository
public interface MemberMapper {
    /**
     * 根据ID获取记录
     * @param id
     * @return
     */
    Member findObjectById(Integer id);
}