package org.proposal.manager.login.service.impl;

import javax.annotation.Resource;

import org.proposal.manager.login.dao.LoginDao;
import org.proposal.manager.login.service.LoginService;
import org.proposal.manager.login.vo.LoginAccessVo;
import org.springframework.stereotype.Service;

@Service("userLoginService")
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
