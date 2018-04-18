package org.manager.portal.site.login.service.impl;

import javax.annotation.Resource;

import org.manager.portal.site.login.LoginAccessVo;
import org.manager.portal.site.login.dao.LoginDao;
import org.manager.portal.site.login.service.LoginService;
import org.springframework.stereotype.Service;

@Service(value="userLoginService")
public class UserLoginService implements LoginService{

    @Resource(name="userLoginDao")
    LoginDao userLoginDao;
    
    @Override
    public Boolean loginAdmin(LoginAccessVo vo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void logoutAdmin() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
