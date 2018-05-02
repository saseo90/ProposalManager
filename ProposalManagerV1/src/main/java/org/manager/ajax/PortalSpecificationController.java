package org.manager.ajax;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.common.util.CommonUtil;
import org.manager.portal.Specification.OperationVO;
import org.manager.portal.Specification.service.impl.PortalSpecificationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 포털 명세서 출력관련 ajax 호출을 위한 컨트롤러 클래스
 * 
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
     * 특정 서비스의 오퍼레이션 리스트를 반환한다.
     * @param serviceKey : COM_SE_ID : 통합서비스아이디(서비스아이디)
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/portal/specification/operationInfoList.ajax"}, method={RequestMethod.POST})
    public @ResponseBody HashMap<String, Object> selectOpInfoALL(String serviceKey, HttpServletRequest req) throws Exception{
        HashMap<String, Object> result = new HashMap<String, Object>();
        String state = "성공";
        List<OperationVO> selectOpInfoALL = null;
        Boolean flag = CommonUtil.matchesNumber(serviceKey);
        if(flag){
            selectOpInfoALL = psService.selectOpInfoALL(serviceKey);
            result.put("OperationInfoList", selectOpInfoALL);
        }else{
            state="실패";
        }
        result.put("state", state);
        return result;
    }
}
