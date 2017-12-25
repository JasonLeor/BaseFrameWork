package com.livenaked.service.impl;

import com.livenaked.common.tools.Utils;
import com.livenaked.dao.intf.UserFunctionDaoIntf;
import com.livenaked.model.PUserFunction;
import com.livenaked.service.intf.UserFunctionServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFunctionServiceImpl implements UserFunctionServiceIntf {
    @Autowired
    private UserFunctionDaoIntf userFunctionDaoIntf;

    @Override
    public boolean hasFunction(Long userId, Long functionId) {
        List<PUserFunction> userFunctions = userFunctionDaoIntf.findByUserIdAndFunctionId(userId, functionId);
        return !Utils.isEmptyByCollection(userFunctions);
    }
}
