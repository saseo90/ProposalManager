package org.manager.portal.Specification.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.manager.portal.Specification.OperationVO;
import org.manager.portal.Specification.ServiceVO;
import org.manager.portal.Specification.service.impl.PortalSpecificationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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
    public String moveMainPage(Model model) throws Exception{
        List<ServiceVO> selectServiceInfoALL = psService.selectServiceInfoALL();
        model.addAttribute("ServiceInfoList", selectServiceInfoALL);
        return "portal/specification/main.tiles";
    }
    
    /**
     * 포털 명세서 홈페이지 (입력)
     * API 문서를 DB 에 IMPORT 한다.
     * @param files : 반드시 .DOCX 파일을 전달받아야 한다.
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/portal/specification/insertDOC.do"}, method=RequestMethod.POST)
    public String insertSpecificationDOC(@RequestParam("files") MultipartFile[] files, HttpServletRequest req) throws Exception{
        if(files != null && files.length > 0){
            for (MultipartFile file : files) {
                if(file.isEmpty()){
                    return "portal/specification/main.tiles";
                }
//                String contentType = file.getContentType();
//                String name = file.getName();
//                String originalFilename = file.getOriginalFilename();
//                long size = file.getSize();
//                System.out.println("contentType::"+contentType);
//                System.out.println("name::"+name);
//                System.out.println("originalFilename::"+originalFilename);
//                System.out.println("size::"+size);
                psService.insertSpecificationDOC(file.getInputStream());  
            }
        }
        return "portal/specification/main.tiles";
    }
    
    /**
     * 특정 서비스의 오퍼레이션 리스트를 반환한다.
     * @param serviceKey : COM_SE_ID : 통합서비스아이디(서비스아이디)
     * @param req
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value={"/portal/specification/operationInfoList.ajax"}, method={RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody HashMap<String, Object> selectOpInfoALL(String serviceKey, HttpServletRequest req) throws Exception{
        HashMap<String, Object> result = new HashMap<String, Object>();
        String state = "성공";
        List<OperationVO> selectOpInfoALL = null;
        if(!"".equals(serviceKey)){
            selectOpInfoALL = psService.selectOpInfoALL(serviceKey);
            result.put("OperationInfoList", selectOpInfoALL);
        }
        if(selectOpInfoALL==null||selectOpInfoALL.size()<1){
            state="실패";
        }
        result.put("state", state);
        return result;
    }
}
