package org.manager.portal.site.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.manager.portal.site.survey.SurveryENVVO;
import org.manager.portal.site.survey.SurveryItemVO;
import org.manager.portal.site.survey.SurveryResultVO;
import org.manager.portal.site.survey.service.SurveryService;
import org.springframework.stereotype.Service;
/**
 * 설문조사 를 위한 서비스 클래스
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
@Service(value="surveryService")
public class SurveryServiceImpl implements SurveryService {

    @Resource(name="surveryDAO")
    SurveryDAO surveryDAO;

    @Override
    public List<SurveryResultVO> excelList(SurveryItemVO vo){
        try {
            return surveryDAO.excelList(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SurveryENVVO surveryInfo(int SURVERY_NO){
        try {
            return surveryDAO.surveryInfo(SURVERY_NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SurveryItemVO> surveryItemList(int SURVERY_NO){
        try {
            return surveryDAO.surveryItemList(SURVERY_NO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
