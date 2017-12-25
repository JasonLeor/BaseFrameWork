package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PRoleFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleFunctionDaoIntf extends BaseDao<PRoleFunction, Long> {
    List<PRoleFunction> findByFunctionIdAndRoleIdIn(Long functionId, List<Long> roleIds);
}
