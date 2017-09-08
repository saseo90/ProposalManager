package org.commons.util.connecter.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 통합전산센터 클로킹 한 레코드의 리스트 View Object 클래스
 * 
 * @author 이성현
 * @since 2017.08.26
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일             수정자       수정내용
 *  ------------ ------ ----------------------------
 *   2017.08.26   이성현      최초 생성
 * 
 * </pre>
 *
 */
public class DocumentVo {
    String conType = null;
    String readDate = null;
    List<TongjeonRecodVo> resultVo = null;
    
    public DocumentVo(String conType, String readDate){
        this(conType, readDate, new ArrayList<TongjeonRecodVo>());
    }
    public DocumentVo(String conType, String readDate, List<TongjeonRecodVo> resultVo) {
        this.conType = conType;
        this.readDate = readDate;
        this.resultVo = resultVo;
    }
    public String getConType() {
        return conType;
    }
    public String getReadDate() {
        return readDate;
    }
    @Override
    public String toString() {
        return "DocumentVo [conType=" + conType + ", readDate=" + readDate
                + ", resultVo=" + resultVo + "]";
    }
}
