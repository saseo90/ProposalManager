package org.manager.portal.site.survey.service;

import java.util.List;

import org.manager.portal.site.survey.SurveryENVVO;
import org.manager.portal.site.survey.SurveryItemVO;
import org.manager.portal.site.survey.SurveryResultVO;
/**
 * 설문조사 를 위한 인터페이스
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
public interface SurveryService {

    /**
     * 설문조사 엑셀 다운로드 위한조회
     * @param vo
     * @return
     * @throws Exception
     */
    public List<SurveryResultVO> excelList(SurveryItemVO vo);
    /**
     * 설문조사 한건 상세조회
     * @param SURVERY_NO
     * @return
     * @throws Exception
     */
    public SurveryENVVO surveryInfo(int SURVERY_NO);
    /**
     * 설문조사 전체조회(조건검색 포함)
     * @param SURVERY_NO
     * @return
     * @throws Exception
     */
    public List<SurveryItemVO> surveryItemList(int SURVERY_NO);
}
