package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoIntf extends BaseDao<PUser, Long> {
    List<PUser> findByUserName(String userName);
}
