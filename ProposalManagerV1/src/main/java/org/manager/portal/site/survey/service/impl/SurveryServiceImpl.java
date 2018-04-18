package org.manager.portal.site.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.manager.portal.site.survey.SurveryENVVO;
import org.manager.portal.site.survey.SurveryItemVO;
import org.manager.portal.site.survey.SurveryResultVO;
import org.manager.portal.site.survey.service.SurveryService;
import org.springframework.stereotype.Service;

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
