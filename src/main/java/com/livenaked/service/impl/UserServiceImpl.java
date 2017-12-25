package com.livenaked.service.impl;

import com.livenaked.common.Constants;
import com.livenaked.common.tools.Utils;
import com.livenaked.dao.intf.UserDaoIntf;
import com.livenaked.model.PUser;
import com.livenaked.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserServiceIntf {
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private UserDaoIntf userDao;

    @Override
    public boolean checkLoginStatus(String token) {
        return false;
    }

    @Override
    public PUser getUser(String token) {
        return new PUser(1L);
    }

    @Override
    public PUser getCurrentLoginUser() {
        String token = httpServletRequest.getParameter(Constants.USER_LOGIN_TOKEN_FIELD);
        if (!Utils.isEmpty(token)) {
            PUser user = userDao.findUser(token);
        }
        return new PUser(1L);
    }
}
