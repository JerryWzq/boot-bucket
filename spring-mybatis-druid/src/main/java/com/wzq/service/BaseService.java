package com.wzq.service;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BaseService<T> {

    List<T> selectAll();

    T selectById(Integer id);

    boolean add(T t);

    boolean deleteById(Integer id);

    boolean updateById(T t);

}
