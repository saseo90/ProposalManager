package org.manager.portal.site.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 매인 페이지 호출을 위한 컨트롤러 클래스
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
public class MainController {
    
    
//    /** EgovBBSUseInfoManageService */
//    @Resource(name = "EgovBBSUseInfoManageService")
//    private EgovBBSUseInfoManageService bbsUseService;
//    
//    /** DefaultBeanValidator */
//    @Autowired
//    private DefaultBeanValidator beanValidator;
//    
//    /** EgovMessageSource */
//    @Resource(name="egovMessageSource")
//    EgovMessageSource egovMessageSource;
    
    /**
     * 홈페이지로 이동한다.
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/","main.do",""})
    public String moveMainPage() throws Exception{
        return "portal/main.tiles";
    }

    /**
     * 신규 회원가입 페이지로 이동한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"register.do"})
    public String moveRegisterPage() throws Exception{
        return "onepage/register.tiles";
    }
    
    /**
     * 잠금화면으로 이동한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"lockscreen.do"})
    public String movelockscreenPage() throws Exception{
        return "onepage/lockscreen.tiles";
    }
    
    /**
     * 에러페이지로 이동한다.
     * 기본 페이지 404
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"error.do"})
    public String moveErrorPage() throws Exception{
        return "error/error.tiles";
    }
    
    /**
     * 404 에러페이지로 이동한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"error_404.do"})
    public String moveError404Page() throws Exception{
        return "error/error-404.tiles";
    }
    
    /**
     * 500 에러페이지로 이동한다.
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"error_500.do"})
    public String moveError500Page() throws Exception{
        return "error/error-500.tiles";
    }
    
    
//    public String addBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model) throws Exception {
//
//        if (!checkAuthority(model)) return "cmm/uat/uia/EgovLoginUsr";  // server-side 권한 확인
//
//        return "cop/com/EgovBoardUseInfRegist";
//    }
    
}
