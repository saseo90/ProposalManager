package org.manager.portal.Specification.service.impl;

import java.util.List;

import org.manager.portal.Specification.MSGSpecificationVO;
import org.manager.portal.Specification.OperationVO;
import org.manager.portal.Specification.ServiceVO;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/** 
 * 포털 명세서 출력을 위한 데이터 접근 객체 구현체
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
@Repository("portalSpecificationDAO")
public class PortalSpecificationDAO extends EgovAbstractMapper {

    public int insertServiceInfo(ServiceVO serviceVO) {
        return insert("specification.insertServiceInfo", serviceVO);
    }
    
    public int insertOpertationInfo(OperationVO opInfo) {
        return insert("specification.insertOpInfo", opInfo);
    }
    
    public int insertOpertationInfo(String COM_SE_ID) {
        return insert("specification.updateOpInfo", COM_SE_ID);
    }
    
    public int insertMSGInfo(MSGSpecificationVO msgVO) {
        return insert("specification.inserMSGInfo", msgVO);
    }
    
    public void insertMSGRspList(MSGSpecificationVO msgVO) {
        insert("specification.inserMSGRspsInfo", msgVO);
    }
    /**
     * 2.1.1.전체조회_서비스
     * @return
     */
    public List<ServiceVO> selectServiceInfoALL() {
        return selectList("specification.selectServiceInfoALL");
    }

    /**
     * 2.1.2.전체조회_오퍼레이션 : 특정 서비스의 오퍼레이션을 전체조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<OperationVO> selectOpInfoALL(String COM_SE_ID) {
        return selectList("specification.selectOpInfoALL", COM_SE_ID);
    }
    /**
     * 2.1.3.1.전체조회_메시지 : 특정 오퍼레이션의 메시지 전제를 조회한다.
     * @param COM_SE_ID 통합서비스아이디(서비스 아이디)
     * @return
     */
    public List<MSGSpecificationVO> selectMSGInfoALL1(String COM_SE_ID) {
        return selectList("specification.selectMSGInfoALL1", COM_SE_ID);
    }
    /**
     * 2.1.3.2.전체조회_메시지 : 특정 오퍼레이션의 메시지 전제를 조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<MSGSpecificationVO> selectMSGInfoALL2(String COM_SE_ID) {
        return selectList("specification.selectMSGInfoALL2", COM_SE_ID);
    }
    /**
     * 2.1.3.3.전체조회_요청 메시지 : 특정 오퍼레이션의 요청 메시지 전제를 조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<MSGSpecificationVO> selectMSGRqsInfoALL(String COM_SE_ID) {
        return selectList("specification.selectMSGRqsInfoALL", COM_SE_ID);
    }
    /**
     * 2.1.3.4.전체조회_응답 메시지 : 특정 오퍼레이션의 응답 메시지 전제를 조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<MSGSpecificationVO> selectMSGRspInfoALL(String COM_SE_ID) {
        return selectList("specification.selectMSGRspInfoALL", COM_SE_ID);
    }
    /**
     * 2.2.1.단일조회_서비스 : 특정 서비스의 정보를 조회한다.
     * @param MSG_SPECIFY_NO : 메시지번호
     * @return
     */
    public ServiceVO selectServiceInfo(String COM_SE_ID) {
        return selectOne("specification.selectServiceInfo", COM_SE_ID);
    }
    /**
     *2.2.2.단일조회_오퍼레이션 : 특정 오퍼래이션의 정보를 조회한다.
     * @param MSG_SPECIFY_NO : 메시지번호
     * @return
     */
    public OperationVO selectOpInfo(String COM_SE_ID) {
        return selectOne("specification.selectOpInfo", COM_SE_ID);
    }
    /**
     * 2.2.3.단일조회_메시지 : 특정 메시지를 조회한다.
     * @param MSG_SPECIFY_NO : 메시지번호
     * @return
     */
    public MSGSpecificationVO selectMSGInfo(String MSG_SPECIFY_NO) {
        return selectOne("specification.selectMSGInfo", MSG_SPECIFY_NO);
    }
    /**
     * 2.3.1.단일조회_서비스(하위포함) : 오퍼레이션 및 메시지 포함
     * @return
     */
    public ServiceVO selectServiceInfos(String COM_SE_ID) {
        return selectOne("specification.selectServiceInfos",COM_SE_ID);
    }
    /**
     * 2.3.2.단일조회_오퍼레이션(하위포함) : 메시지 포함
     * @return
     */
    public OperationVO selectOpInfos(String COM_SE_ID) {
        return selectOne("specification.selectOperationInfos",COM_SE_ID);
    }
}
