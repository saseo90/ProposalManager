package org.manager.portal.site.login.dao.impl;

import org.manager.portal.site.login.LoginAccessVo;
import org.manager.portal.site.login.dao.LoginDao;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * 로그인 처리를 위한 데이터 접근 객체 구현체
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
@Repository(value="userLoginDao")
public class UserLoginDaoImpl extends EgovAbstractMapper implements LoginDao{

    @Override
    public LoginAccessVo loginAdmin(LoginAccessVo LoginAccessVo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
