package org.manager.portal.site.login.dao;

import org.manager.portal.site.login.LoginAccessVo;

/**
 * 
 * 공통 로그인 처리를 위한 DAO 인터페이스
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
public interface LoginDao {
    
    /** 로그인 */
    public LoginAccessVo loginAdmin(LoginAccessVo LoginAccessVo) throws Exception;

}
