package org.proposal.manager.monitor.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.commons.naraService.UsrInfoService.DminsttInfo.DminsttInfoList;
import org.proposal.manager.monitor.service.MonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 모니터  페이지 호출을 위한 컨트롤러 클래스
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
@Controller("/proposal/monitor")
public class MoniterController {
    protected Logger logger = Logger.getLogger(getClass());
    
    /** 모니터 서비스 구현체  */
    @Resource(name = "efficiencyMonitorService")
    private MonitorService efficiencyService;
    
    /**
     * 
     * 성능모니터 페이지로 이동한다.
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/monitor"})
    public String moveMonitorPage(Model model) throws Exception{
        Map<String,Object> memResult= efficiencyService.monitorMem();
        Map<String,Object> osResult= efficiencyService.monitorOsInfo();
        model.addAttribute("memResult", memResult);
        model.addAttribute("osResult", osResult);
        logger.error("null : "+osResult.toString());
        return "monitorEfficiency";
    }
    
    /**
     * 
     * 성능모니터 페이지로 이동한다.
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/monitor/ajaxConn"},method={RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody Map<String, Object> moveMonitorPage( DminsttInfoList dminsttInfoList) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("상태", "성공");
        if(dminsttInfoList==null){
            logger.error("null : "+dminsttInfoList.toString());
        }else{
            logger.error("value : "+dminsttInfoList.toString());
        }        
        return result;
    }

}
