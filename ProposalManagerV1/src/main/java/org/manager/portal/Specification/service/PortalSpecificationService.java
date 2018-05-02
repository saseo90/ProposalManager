package org.manager.portal.Specification.service;

import java.io.InputStream;
import java.util.List;

import org.manager.portal.Specification.MSGSpecificationVO;
import org.manager.portal.Specification.OperationVO;
import org.manager.portal.Specification.ServiceVO;

/**
 * 포털 명세서 출력 호출을 위한 서비스 인터페이스
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
public interface PortalSpecificationService {
    /**
     * 라이브러리 종속 : poi-ooxml : XWPFDocument
     * int code : Object Type Code
     * int i    : index
     * @param 인푿스트림
     * @throws Exception
     */
    public void insertSpecificationDOC(InputStream is) throws Exception;
    /**
     * 2.1.1.전체조회_서비스
     * @throws Exception
     */
    public List<ServiceVO> selectServiceInfoALL() throws Exception;
    /**
     * 2.1.2.전체조회_오퍼레이션 : 특정 서비스의 오퍼레이션을 전체조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<OperationVO> selectOpInfoALL(String COM_SE_ID) throws Exception;
    /**
     * 2.1.3.전체조회_요청 메시지 : 특정 오퍼레이션의 요청 메시지 전제를 조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<MSGSpecificationVO> selectMSGRqsInfoALL(String COM_SE_ID) throws Exception;
    /**
     * 2.1.4.전체조회_응답 메시지 : 특정 오퍼레이션의 응답 메시지 전제를 조회한다.
     * @param COM_SE_ID 통합서비스아이디(오퍼레이션 아이디)
     * @return
     */
    public List<MSGSpecificationVO> selectMSGRspInfoALL(String COM_SE_ID) throws Exception;
    
    /**
     * 특정 서비스의 클래스파일을 생성한다.
     * @param  COM_SE_ID 통합서비스아이디(서비스아이디)
     * @throws Exception
     */
    public void createServiceInfo(String COM_SE_ID) throws Exception;
}
