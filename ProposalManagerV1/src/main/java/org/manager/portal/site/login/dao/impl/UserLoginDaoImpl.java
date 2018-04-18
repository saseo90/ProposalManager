package org.manager.portal.site.login.dao.impl;

import org.manager.portal.site.login.LoginAccessVo;
import org.manager.portal.site.login.dao.LoginDao;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository(value="userLoginDao")
public class UserLoginDaoImpl extends EgovAbstractMapper implements LoginDao{

    @Override
    public LoginAccessVo loginAdmin(LoginAccessVo LoginAccessVo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
