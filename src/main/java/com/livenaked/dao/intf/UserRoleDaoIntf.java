package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PUserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDaoIntf extends BaseDao<PUserRole, Long> {
    @Query(value = "select ur from PUserRole ur where ur.isValid =1 and ur.role.isValid =1 and ur.userId =?1")
    List<PUserRole> findByUser(String userId);
}
