package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PRole;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDaoIntf extends BaseDao<PRole, Long> {
}
