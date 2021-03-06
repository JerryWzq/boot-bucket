package com.wzq.mapper;

import com.wzq.model.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    List<City> selectAll();

    List<City> selectCities();

    List<City> selectTest();

    boolean add(City city);

}
