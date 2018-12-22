
package com.wzq.mapper;

import com.wzq.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 类描述:
 * member的mapper接口
 *
 * @author
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