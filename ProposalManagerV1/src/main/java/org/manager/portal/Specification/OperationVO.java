package org.manager.portal.Specification;

import java.util.List;

/**
 * 서비스(오퍼레이션)명세서 SPECIFY_SE_TB 를 위한 View Object 클래스
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
public class OperationVO extends SpecificationCOM {

    private static final long serialVersionUID = 1L;
    List<MSGSpecificationVO> msgListReq;//요청 메시지명세서 SPECIFY_MSG_TB
    List<MSGSpecificationVO> msgListRsp;//응답 메시지명세서 SPECIFY_MSG_TB
    public List<MSGSpecificationVO> getMsgListReq() {
        return msgListReq;
    }
    public void setMsgListReq(List<MSGSpecificationVO> msgListReq) {
        this.msgListReq = msgListReq;
    }
    public List<MSGSpecificationVO> getMsgListRsp() {
        return msgListRsp;
    }
    public void setMsgListRsp(List<MSGSpecificationVO> msgListRsp) {
        this.msgListRsp = msgListRsp;
    }
    @Override
    public String toString() {
        return "OperationVO ["+super.toString() + "msgListReq=" + msgListReq + ", msgListRsp=" + msgListRsp + "]";
    }    
}
