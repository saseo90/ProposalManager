package org.manager.portal.site.survey;

/**
 * 설문조사 이벤트 정보 객체 클래스
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
public class SurveryENVVO {
    String SURVERY_NO; 
    String SURVERY_SUBJECT; 
    String SURVERY_TITLE; 
    String SURVERY_CONT; 
    int MAXITEM ; 
    int MAXANSWER;
    public String getSURVERY_NO() {
        return SURVERY_NO;
    }
    public void setSURVERY_NO(String sURVERY_NO) {
        SURVERY_NO = sURVERY_NO;
    }
    public String getSURVERY_SUBJECT() {
        return SURVERY_SUBJECT;
    }
    public void setSURVERY_SUBJECT(String sURVERY_SUBJECT) {
        SURVERY_SUBJECT = sURVERY_SUBJECT;
    }
    public String getSURVERY_TITLE() {
        return SURVERY_TITLE;
    }
    public void setSURVERY_TITLE(String sURVERY_TITLE) {
        SURVERY_TITLE = sURVERY_TITLE;
    }
    public String getSURVERY_CONT() {
        return SURVERY_CONT;
    }
    public void setSURVERY_CONT(String sURVERY_CONT) {
        SURVERY_CONT = sURVERY_CONT;
    }
    public int getMAXITEM() {
        return MAXITEM;
    }
    public void setMAXITEM(int mAXITEM) {
        MAXITEM = mAXITEM;
    }
    public int getMAXANSWER() {
        return MAXANSWER;
    }
    public void setMAXANSWER(int mAXANSWER) {
        MAXANSWER = mAXANSWER;
    }
    @Override
    public String toString() {
        return "SurveryENVVO [SURVERY_NO=" + SURVERY_NO + ", SURVERY_SUBJECT=" + SURVERY_SUBJECT + ", SURVERY_TITLE="
                + SURVERY_TITLE + ", SURVERY_CONT=" + SURVERY_CONT + ", MAXITEM=" + MAXITEM + ", MAXANSWER=" + MAXANSWER
                + "]";
    }
    
    
}
