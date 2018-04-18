package org.manager.portal.site.survey.service.impl;

import java.util.List;

import org.manager.portal.site.survey.SurveryENVVO;
import org.manager.portal.site.survey.SurveryItemVO;
import org.manager.portal.site.survey.SurveryResultVO;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository(value="surveryDAO")
public class SurveryDAO extends EgovAbstractMapper {

    public List<SurveryResultVO> excelList(SurveryItemVO vo) throws Exception{
        return selectList("survery.surveryExcel",vo);
    }
    public SurveryENVVO surveryInfo(int SURVERY_NO) throws Exception{
        return selectOne("survery.surveryInfo",SURVERY_NO);
    }
    public List<SurveryItemVO> surveryItemList(int SURVERY_NO)throws Exception {
        return selectList("survery.surveryItemList",SURVERY_NO);
    }
}
