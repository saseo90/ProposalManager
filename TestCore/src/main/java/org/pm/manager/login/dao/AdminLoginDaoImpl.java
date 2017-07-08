package org.pm.manager.login.dao;

import javax.annotation.Resource;

import org.pm.manager.login.vo.LoginAccessVo;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
/**
 * 로그인 처리를 위한 데이터 접근 객체 구현체
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
@Resource(name="adminLoginDao")
public class AdminLoginDaoImpl extends EgovAbstractDAO implements LoginDao{

    @Override
    public LoginAccessVo loginAdmin(LoginAccessVo vo) throws Exception {
        return (LoginAccessVo) select("", vo);
    }

}
