package com.livenaked.common.core;

import com.livenaked.common.page.Pagination;

import java.io.Serializable;
import java.util.List;

public interface BaseServiceIntf<T, ID extends Serializable> {
    T save(T entity);

    boolean update(T entity);

    boolean delete(T entity);

    boolean deleteById(ID id);

    List<T> findAll();

    Pagination<T> find(int pageNo, int pageSize);

    T findById(ID id);
}
