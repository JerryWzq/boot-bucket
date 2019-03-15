
package com.wzq.boot.mapper;

import com.wzq.boot.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Member> selectList();
}