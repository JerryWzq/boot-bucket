package com.wzq.test;

import com.wzq.entity.Member;
import com.wzq.entity.Province;
import com.wzq.mapper.BaseMapper;
import org.junit.Test;

public class JdbcTest {

    @Test
    public void test01(){
        String sql = "select id, name from member where name=?";
        Object[] objects = {"Bob"};
        Member member = BaseMapper.get(Member.class, sql, false, objects);
        System.err.println(member.toString());
    }

    @Test
    public void test02(){
        String sql = "select id, province_code provinceCode, province_name provinceName from province " +
                "where province_name=?";
        Object[] objects = {"江西"};
        Province province = BaseMapper.get(Province.class, sql, false, objects);
        System.err.println(province.toString());
    }

    @Test
    public void test03(){
        String sql = "select id, province_code, province_name from province " +
                "where province_name=?";
        Object[] objects = {"江西"};
        Province province = BaseMapper.get(Province.class, sql, true, objects);
        System.err.println(province.toString());
    }


}
