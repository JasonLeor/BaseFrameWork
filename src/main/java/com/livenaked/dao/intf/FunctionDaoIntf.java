package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PFunction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FunctionDaoIntf extends BaseDao<PFunction, Long> {
    @Query(value = "select fun from PFunction fun where fun.isValid =1 and fun.route = ?1")
    List<PFunction> findFunction(String route);

    @Query(value = "select fun from PFunction fun where fun.isValid =1 and fun.id=?1")
    PFunction findValidFunction(Long functionId);
}
