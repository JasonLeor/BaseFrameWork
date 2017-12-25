package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDaoIntf extends BaseDao<PUserRole, Long> {
    List<PUserRole> findByUserId(Long userId);
}
