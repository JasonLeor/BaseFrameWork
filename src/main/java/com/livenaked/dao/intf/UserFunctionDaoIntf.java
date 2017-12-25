package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PUserFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFunctionDaoIntf extends BaseDao<PUserFunction, Long> {
    List<PUserFunction> findByUserIdAndFunctionId(Long userId, Long functionId);
}
