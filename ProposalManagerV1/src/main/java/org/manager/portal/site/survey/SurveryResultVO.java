package org.manager.portal.site.survey;

public class SurveryResultVO {

    int SURVERY_NO;
    int ITEM_NO;
    int ANSWER_NO;
    String ANSWER_CONT; 
    String MEM_NAME;
    String MEM_ID;
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
    public String getANSWER_CONT() {
        return ANSWER_CONT;
    }
    public void setANSWER_CONT(String aNSWER_CONT) {
        ANSWER_CONT = aNSWER_CONT;
    }
    public String getMEM_NAME() {
        return MEM_NAME;
    }
    public void setMEM_NAME(String mEM_NAME) {
        MEM_NAME = mEM_NAME;
    }
    public String getMEM_ID() {
        return MEM_ID;
    }
    public void setMEM_ID(String mEM_ID) {
        MEM_ID = mEM_ID;
    }
    @Override
    public String toString() {
        return "SurveryResultVO [SURVERY_NO=" + SURVERY_NO + ", ITEM_NO=" + ITEM_NO + ", ANSWER_NO=" + ANSWER_NO
                + ", ANSWER_CONT=" + ANSWER_CONT + ", MEM_NAME=" + MEM_NAME + ", MEM_ID=" + MEM_ID + "]";
    }
    
    
}
