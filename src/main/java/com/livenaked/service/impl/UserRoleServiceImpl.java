package com.livenaked.service.impl;

import com.livenaked.common.tools.Utils;
import com.livenaked.dao.intf.RoleFunctionDaoIntf;
import com.livenaked.dao.intf.UserRoleDaoIntf;
import com.livenaked.model.PRoleFunction;
import com.livenaked.model.PUserRole;
import com.livenaked.service.intf.UserRoleServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleServiceIntf {
    @Autowired
    private UserRoleDaoIntf userRoleDaoIntf;
    @Autowired
    private RoleFunctionDaoIntf roleFunctionDao;

    @Override
    public boolean hasFunction(Long userId, Long functionId) {
        List<PUserRole> userRoles = userRoleDaoIntf.findByUserId(userId);
        if (!Utils.isEmptyByCollection(userRoles)) {
            List<PRoleFunction> functions = roleFunctionDao.findByFunctionIdAndRoleIdIn(functionId, userRoles.stream().map(pUserRole -> pUserRole.getRoleId()).collect(Collectors.toList()));
            if (!Utils.isEmptyByCollection(functions)) {
                return true;
            }
        }
        return false;
    }
}
