package org.manager.portal.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 메시지명세서 SPECIFY_SE_TB
 *
 */
public class ServiceVO  extends SpecificationCOMVO {    
    List<OperationVO> opInfos;

    public List<OperationVO> getOpInfos() {
        return opInfos;
    }

    public void setOpInfos(List<OperationVO> opInfos) {
        this.opInfos = opInfos;
    }
    public void setOpInfos(OperationVO opInfo) {
        if(this.opInfos==null){
            this.opInfos = new ArrayList<OperationVO>(); 
        }
        this.opInfos.add(opInfo);
    }

    public OperationVO getOpInfoLast() {
        return opInfos.get(opInfos.size()-1);
    }
    
    @Override
    public String toString() {
        return "ServiceVO ["+super.toString()+" opInfos=" + opInfos + "]";
    }
    
}
