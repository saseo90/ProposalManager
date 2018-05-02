package org.manager.portal.site.survey.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.manager.portal.site.survey.SurveryENVVO;
import org.manager.portal.site.survey.SurveryItemVO;
import org.manager.portal.site.survey.service.SurveryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 설문조사 를 위한 컨트롤러 클래스
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
public class SurveyController {
    protected final Log logger = LogFactory.getLog(getClass());

    @Resource(name="surveryService")
    SurveryService surveryService;
    
    @RequestMapping(value="{siteCode}/survey/fileDouwnload.do")
    public String douwnloadExcel(@ModelAttribute SurveryItemVO surveryItemVO,
            @PathVariable String siteCode,
            Model model ,Integer fileNo,HttpServletRequest rq,HttpServletResponse rs){
        int SURVERY_NO = surveryItemVO.getSURVERY_NO();
        SURVERY_NO=1;
        System.out.println("SURVERY_NO:::"+SURVERY_NO);
        logger.debug("SURVERY_NO:::"+SURVERY_NO);
        SurveryENVVO surveryENV =  surveryService.surveryInfo(SURVERY_NO);
        System.out.println("surveryENV:::"+surveryENV);
        model.addAttribute("surveryENV", surveryENV);
        String returnURL = "redirect:/main.do";
        if("portal".equals(siteCode)){
            returnURL = siteCode+"/survey/excel.tiles";
            returnURL = "portal/survey/excel.tiles";
            logger.info(returnURL);
        }
        return returnURL;
    }
}
