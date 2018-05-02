package org.manager.portal.site.survey.service.impl;

import java.util.List;

import org.manager.portal.site.survey.SurveryENVVO;
import org.manager.portal.site.survey.SurveryItemVO;
import org.manager.portal.site.survey.SurveryResultVO;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
/**
 * 설문조사 를 위한 데이터 접근 객체 구현체
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
