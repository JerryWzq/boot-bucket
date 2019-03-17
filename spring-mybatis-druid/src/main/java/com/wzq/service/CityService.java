package com.wzq.service;

import com.wzq.mapper.CityMapper;
import com.wzq.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements BaseService<City> {

    @Autowired
    private CityMapper mapper;

    @Override
    public List<City> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public City selectById(Integer id) {
        return null;
    }

    @Override
    public boolean add(City city) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean updateById(City city) {
        return false;
    }
}
