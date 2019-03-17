package com.wzq.mapper;

import com.wzq.model.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    List<Province> selectAll();
}
