package org.manager.portal.Specification;

import java.util.List;

/**
 * 
 * 메시지명세서 SPECIFY_MSG_TB
 *
 */
public class OperationVO extends SpecificationCOMVO {
    
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
