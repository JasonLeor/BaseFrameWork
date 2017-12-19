package com.livenaked.service.impl;

import com.livenaked.common.core.BaseDao;
import com.livenaked.common.core.BaseServiceImpl;
import com.livenaked.model.PUser;
import com.livenaked.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<PUser, Long> implements UserServiceIntf {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
