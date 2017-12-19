package com.livenaked.common.core;

import com.livenaked.common.page.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseServiceIntf<T, ID> {
    private BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    @Override
    public T save(T entity) {
        this.baseDao.saveAndFlush(entity);
        return entity;
    }

    @Override
    public boolean update(T entity) {
        T o = (T) this.baseDao.saveAndFlush(entity);
        return true;
    }

    @Override
    public boolean delete(T entity) {
        this.baseDao.delete(entity);
        return true;
    }

    @Override
    public boolean deleteById(ID id) {
        this.baseDao.delete(id);
        return false;
    }

    @Override
    public List<T> findAll() {
        return this.baseDao.findAll();
    }

    @Override
    public Pagination<T> find(int pageNo, int pageSize) {
        Page<T> pages = this.baseDao.findAll(new PageRequest(pageNo, pageSize));
        return null;
    }

    @Override
    public T findById(ID id) {

        return this.baseDao.getOne(id);
    }
}
