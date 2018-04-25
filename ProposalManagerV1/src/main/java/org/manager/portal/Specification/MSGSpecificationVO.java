package org.manager.portal.Specification;
/**
 * 
 * 메시지명세서 SPECIFY_MSG_TB
 *
 */
public class MSGSpecificationVO {
    String MSG_SPECIFY_NO;//(PK)메시지명세번호
    String COM_SE_ID;//(FK)통합서비스아이디(오퍼레이션_아이디)
    String MSG_GB;//메시지구분(req|rsp)
    String ITEM_NM_KR;//항목국문이름
    String ITEM_NM_EN;//항목영문이름
    String ITEM_SIZE;//항목크기
    String ITEM_GB;//항목구분
    String SAMPLE_DATA;//샘플데이터
    String ITEM_CONT;//항목설명
    
    public String getMSG_SPECIFY_NO() {
        return MSG_SPECIFY_NO;
    }
    public void setMSG_SPECIFY_NO(String mSG_SPECIFY_NO) {
        MSG_SPECIFY_NO = mSG_SPECIFY_NO;
    }
    public String getCOM_SE_ID() {
        return COM_SE_ID;
    }
    public void setCOM_SE_ID(String cOM_SE_ID) {
        COM_SE_ID = cOM_SE_ID;
    }
    public String getITEM_NM_KR() {
        return ITEM_NM_KR;
    }
    public void setITEM_NM_KR(String iTEM_NM_KR) {
        ITEM_NM_KR = iTEM_NM_KR;
    }
    public String getITEM_NM_EN() {
        return ITEM_NM_EN;
    }
    public void setITEM_NM_EN(String iTEM_NM_EN) {
        ITEM_NM_EN = iTEM_NM_EN;
    }
    public String getITEM_SIZE() {
        return ITEM_SIZE;
    }
    public void setITEM_SIZE(String iTEM_SIZE) {
        ITEM_SIZE = iTEM_SIZE;
    }
    public String getITEM_GB() {
        return ITEM_GB;
    }
    public void setITEM_GB(String iTEM_GB) {
        ITEM_GB = iTEM_GB;
    }
    public String getSAMPLE_DATA() {
        return SAMPLE_DATA;
    }
    public void setSAMPLE_DATA(String sAMPLE_DATA) {
        SAMPLE_DATA = sAMPLE_DATA;
    }
    public String getITEM_CONT() {
        return ITEM_CONT;
    }
    public void setITEM_CONT(String iTEM_CONT) {
        ITEM_CONT = iTEM_CONT;
    }
    public String getMSG_GB() {
        return MSG_GB;
    }
    public void setMSG_GB(String mSG_GB) {
        MSG_GB = mSG_GB;
    }
    @Override
    public String toString() {
        return "MSGSpecificationVO [MSG_SPECIFY_NO=" + MSG_SPECIFY_NO
                + ", COM_SE_ID=" + COM_SE_ID + ", MSG_GB=" + MSG_GB
                + ", ITEM_NM_KR=" + ITEM_NM_KR + ", ITEM_NM_EN=" + ITEM_NM_EN
                + ", ITEM_SIZE=" + ITEM_SIZE + ", ITEM_GB=" + ITEM_GB
                + ", SAMPLE_DATA=" + SAMPLE_DATA + ", ITEM_CONT=" + ITEM_CONT
                + "]";
    }
    
}
