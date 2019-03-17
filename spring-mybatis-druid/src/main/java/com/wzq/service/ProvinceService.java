package com.wzq.service;

import com.wzq.mapper.ProvinceMapper;
import com.wzq.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements BaseService<Province> {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> selectAll() {
        return provinceMapper.selectAll();
    }

    @Override
    public Province selectById(Integer id) {
        return null;
    }

    @Override
    public boolean add(Province province) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public boolean updateById(Province province) {
        return false;
    }
}
