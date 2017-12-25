package com.livenaked.service.impl;

import com.livenaked.common.ResponseCode;
import com.livenaked.common.exception.SystemException;
import com.livenaked.common.tools.Utils;
import com.livenaked.dao.intf.FunctionDaoIntf;
import com.livenaked.entity.FunctionStatusEnum;
import com.livenaked.model.PFunction;
import com.livenaked.service.intf.FunctionServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FunctionServiceImpl implements FunctionServiceIntf {
    @Autowired
    private FunctionDaoIntf functionDao;

    @Override
    public PFunction findFunction(String route) {
        List<PFunction> functions = functionDao.findFunction(route);
        if (!Utils.isEmptyByCollection(functions)) {
            return functions.get(0);
        }
        return null;
    }

    @Override
    public boolean hasFunction(String route) {
        PFunction pFunction = findFunction(route);
        return pFunction != null;
    }

    @Override
    public FunctionStatusEnum getFunctionStatus(String route) throws SystemException {
        PFunction pFunction = findFunction(route);
        while (pFunction != null && pFunction.getParentId() != null) {
            FunctionStatusEnum status = FunctionStatusEnum.getByValue(pFunction.getStatus());
            if (!status.equals(FunctionStatusEnum.ENABLED)) {
                return status;
            }

            pFunction = functionDao.findValidFunction(pFunction.getParentId());
        }

        if (pFunction != null) {
            if (pFunction.getParentId() != null) {
            }
            return FunctionStatusEnum.getByValue(pFunction.getStatus());
        } else {
            throw new SystemException(ResponseCode.SYSTEM_ERROR);
        }
    }
}
