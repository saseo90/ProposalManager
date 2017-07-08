package org.pm.manager.login.service.impl;

import javax.annotation.Resource;

import org.pm.commons.util.service.EgovFileScrty;
import org.pm.manager.login.dao.LoginDao;
import org.pm.manager.login.service.LoginService;
import org.pm.manager.login.vo.LoginAccessVo;
import org.springframework.stereotype.Service;



/**
 * 관리자 로그인 페이지 처리를 위한 서비스 인터페이스 구현체 클래스
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
@Service(value="adminLoginService")
public class AdminLoginServiceImpl implements LoginService{

    @Resource(name = "adminLoginDao")
    private LoginDao loginDAO;
    
    
    @Override
    public Boolean loginAdmin(LoginAccessVo vo) throws Exception {
        // 1. 입력한 비밀번호를 암호화한다.
        String enpassword = EgovFileScrty.encryptPassword(vo.getAdminPassword(), vo.getAdminId());
        vo.setAdminPassword(enpassword);

        // 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
        LoginAccessVo loginVO = loginDAO.loginAdmin(vo);

        // 3. 결과를 리턴한다.
        if (loginVO != null && !loginVO.getAdminId().equals("") && !loginVO.getAdminPassword().equals("")) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public void logoutAdmin() throws Exception {
        // TODO Auto-generated method stub
        
    }

}
