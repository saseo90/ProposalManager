package org.manager.portal.Specification.web;

import javax.annotation.Resource;

import org.manager.portal.Specification.service.impl.PortalSpecificationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 포털 명세서 출력 호출을 위한 컨트롤러 클래스
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
public class PortalSpecificationController {

    @Resource(name="portalSpecificationService")
    PortalSpecificationServiceImpl psService;
    
    /**
     * 포털 명세서 홈페이지로 이동한다.
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/portal/specification/main.do"})
    public String moveMainPage() throws Exception{
        return "portal/specification/main.tiles";
    }
    
    /**
     * 포털 명세서 홈페이지 (입력)
     * API 문서를 DB 에 IMPORT 한다.
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/portal/specification/main.do"})
    public String insertSpecificationDOC() throws Exception{
        
        return "portal/specification/main.tiles";
    }
}
