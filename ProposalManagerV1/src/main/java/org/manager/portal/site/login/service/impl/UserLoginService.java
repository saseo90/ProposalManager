package org.manager.portal.site.login.service.impl;

import javax.annotation.Resource;

import org.manager.portal.site.login.LoginAccessVo;
import org.manager.portal.site.login.dao.LoginDao;
import org.manager.portal.site.login.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * 로그인 처리를 서비스 객체 구현체
 * @author 이성현
 * @since 2018.04.22
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일             수정자       수정내용
 *  ------------ ------ ----------------------------
 *   2018.04.22   이성현      최초 생성
 *  
 * </pre>
 */
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
