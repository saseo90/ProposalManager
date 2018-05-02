package org.manager.portal.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * 서비스명세서 SPECIFY_SE_TB 를 위한 View Object 클래스
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
public class ServiceVO  extends SpecificationCOM {    
    
    private static final long serialVersionUID = 1L;
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
