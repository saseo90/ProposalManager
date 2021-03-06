package org.manager.portal.site.survey;
/**
 * 설문조사 문항 정보 객체 클래스
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
public class SurveryItemVO {
    int SURVERY_NO; 
    int ITEM_NO; 
    int ANSWER_NO; 
    String ITEM_CONT; 
    String ITEM_TYPE;
    public int getSURVERY_NO() {
        return SURVERY_NO;
    }
    public void setSURVERY_NO(int sURVERY_NO) {
        SURVERY_NO = sURVERY_NO;
    }
    public int getITEM_NO() {
        return ITEM_NO;
    }
    public void setITEM_NO(int iTEM_NO) {
        ITEM_NO = iTEM_NO;
    }
    public int getANSWER_NO() {
        return ANSWER_NO;
    }
    public void setANSWER_NO(int aNSWER_NO) {
        ANSWER_NO = aNSWER_NO;
    }
    public String getITEM_CONT() {
        return ITEM_CONT;
    }
    public void setITEM_CONT(String iTEM_CONT) {
        ITEM_CONT = iTEM_CONT;
    }
    public String getITEM_TYPE() {
        return ITEM_TYPE;
    }
    public void setITEM_TYPE(String iTEM_TYPE) {
        ITEM_TYPE = iTEM_TYPE;
    }
    @Override
    public String toString() {
        return "SurveryItemVO [SURVERY_NO=" + SURVERY_NO + ", ITEM_NO=" + ITEM_NO + ", ANSWER_NO=" + ANSWER_NO
                + ", ITEM_CONT=" + ITEM_CONT + ", ITEM_TYPE=" + ITEM_TYPE + "]";
    }
    
    
}
