package org.manager.portal.site.login.service.impl;

import javax.annotation.Resource;

import org.manager.portal.site.login.LoginAccessVo;
import org.manager.portal.site.login.dao.LoginDao;
import org.manager.portal.site.login.service.LoginService;
import org.springframework.stereotype.Service;

@Service(value="adminLoginService")
public class AdminLoginService implements LoginService {

    @Resource(name="adminLoginDao")
    LoginDao adminLoginDao;
    
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
