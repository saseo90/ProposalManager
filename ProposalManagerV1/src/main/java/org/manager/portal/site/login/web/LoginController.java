package org.manager.portal.site.login.web;

import javax.annotation.Resource;

import org.manager.portal.site.login.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 로그인 페이지 호출을 위한 컨트롤러 클래스
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
@Controller
public class LoginController {
    
    /** 관리자 로그인 서비스 구현체  */
    @Resource(name = "adminLoginService")
    private LoginService adminLoinService;
    /** 사용자 로그인 서비스 구현체  */
    @Resource(name = "userLoginService")
    private LoginService userLoinService;
    
//    /** DefaultBeanValidator */
//    @Autowired
//    private DefaultBeanValidator beanValidator;
//    
//    /** EgovMessageSource */
//    @Resource(name="egovMessageSource")
//    EgovMessageSource egovMessageSource;
    
    /**
     * 로그인 페이지로 이동한다.
     * login
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/login.do"})
    public String moveLoginPage() throws Exception{
        return "onepage/login.tiles";
    }
    
    /**
     * 관리자 로그아웃 .
     * logout
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/adminLogout.do"})
    public String adminLogoutPage() throws Exception{
        return "redirect:/main.do";
    }
    
    /**
     * 사용자 로그아웃 .
     * logout
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/usrLogout.do"})
    public String userLogoutPage() throws Exception{
        return "redirect:/main.do";
    }
    
}
