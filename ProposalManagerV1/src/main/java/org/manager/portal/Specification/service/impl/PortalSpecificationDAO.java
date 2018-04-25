package org.manager.portal.Specification.service.impl;

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

    public void insertServiceInfo(ServiceVO serviceVO) {
        insert("specification.insertServiceInfo", serviceVO);
    }
    
    public String insertOpertationInfo(OperationVO opInfo) {
        insert("specification.insertOpInfo", opInfo);
        return "";
    }
    
    public void insertMSGRspList(MSGSpecificationVO msgVO) {
        insert("specification.inserMSGRspsInfo", msgVO);
    }
    
    public void insertMSGReqList(MSGSpecificationVO msgVO) {
        insert("specification.insertMSGReqsInfo", msgVO);
    }
}
