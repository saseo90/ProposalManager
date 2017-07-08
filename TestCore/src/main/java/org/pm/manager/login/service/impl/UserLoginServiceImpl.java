package org.pm.manager.login.service.impl;

import org.pm.manager.login.service.LoginService;
import org.pm.manager.login.vo.LoginAccessVo;
import org.springframework.stereotype.Service;
/**
 * 사용자 로그인 페이지 처리를 위한 서비스 인터페이스 구현체 클래스
 * @author 이성현
 * @since 2017.06.26
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일             수정자       수정내용
 *  ------------ ------ ----------------------------
 *   2017.06.26   이성현      최초 생성
 *  
 * </pre>
 */
@Service(value="userLoginService")
public class UserLoginServiceImpl implements LoginService{

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
