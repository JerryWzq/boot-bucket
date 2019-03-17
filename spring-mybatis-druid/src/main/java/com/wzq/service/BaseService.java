package com.wzq.service;

import java.util.List;

public interface BaseService<T> {

    List<T> selectAll();

    T selectById(Integer id);

    boolean add(T t);

    boolean deleteById(Integer id);

    boolean updateById(T t);

}
