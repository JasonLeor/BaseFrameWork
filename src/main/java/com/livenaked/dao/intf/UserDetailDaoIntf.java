package com.livenaked.dao.intf;

import com.livenaked.common.core.BaseDao;
import com.livenaked.model.PUserDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailDaoIntf extends BaseDao<PUserDetail, String> {
}
