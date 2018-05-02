package org.manager.portal.Specification;

import java.io.Serializable;

/**
 * 서비스 OR 오퍼레이션 명세서 SPECIFY_SE_TB 를 위한 Common View Object 클래스
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
public class SpecificationCOM implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String COM_SE_ID;//(PK)통합서비스아이디
    String OP_ID;//오퍼레이션아이디
    String SPECIFY_GB;//명세서구분(SE|OP)
    String SE_LV;//     서비스레밸
    String OP_LV;//     오퍼레이션레밸
    String SE_NM_KR;//  국문이름
    String SE_NM_EN;//  영문이름
    String SE_CONT;//   설명
    String OP_CD;//     오퍼레이션구분(조회(목록)|조회(단일))
    String URL_DEV;//   서비스URL_개발환경
    String URL_OP;//    서비스URL_운영환경
    String SECU_IP;//   서비스보안_IP제한여부
    String SECU_CE;//   서비스보안_인증
    String SECU_ROLE;// 서비스보안_권한
    String SECU_TLE;//  서비스보안_전송계층암호화
    String AT_IS;//     적용기술수준_인터페이스표준
    String AT_IDS;//    적용기술수준_교환데이터표준
    String AT_ETC;//    적용기술수준_기타표준
    String DEP_VER;//   서비스배포정보_버전
    String DEP_STR_DT;//서비스배포정보_시작일
    String DEP_DEP_DT;//서비스배포정보_배포일
    String CONS_CONT;// 제약사항_비고
    String REG_DT;//    등록일
    public String getCOM_SE_ID() {
        return COM_SE_ID;
    }
    public void setCOM_SE_ID(String cOM_SE_ID) {
        COM_SE_ID = cOM_SE_ID;
    }
    public String getOP_ID() {
        return OP_ID;
    }
    public void setOP_ID(String oP_ID) {
        OP_ID = oP_ID;
    }
    public String getSPECIFY_GB() {
        return SPECIFY_GB;
    }
    public void setSPECIFY_GB(String sPECIFY_GB) {
        SPECIFY_GB = sPECIFY_GB;
    }
    public String getSE_NM_KR() {
        return SE_NM_KR;
    }
    public void setSE_NM_KR(String sE_NM_KR) {
        SE_NM_KR = sE_NM_KR;
    }
    public String getSE_NM_EN() {
        return SE_NM_EN;
    }
    public void setSE_NM_EN(String sE_NM_EN) {
        SE_NM_EN = sE_NM_EN;
    }
    public String getSE_CONT() {
        return SE_CONT;
    }
    public void setSE_CONT(String sE_CONT) {
        SE_CONT = sE_CONT;
    }
    public String getSE_LV() {
        return SE_LV;
    }
    public void setSE_LV(String sE_LV) {
        SE_LV = sE_LV;
    }
    public String getOP_LV() {
        return OP_LV;
    }
    public void setOP_LV(String oP_LV) {
        OP_LV = oP_LV;
    }
    public String getOP_CD() {
        return OP_CD;
    }
    public void setOP_CD(String oP_CD) {
        OP_CD = oP_CD;
    }
    public String getURL_DEV() {
        return URL_DEV;
    }
    public void setURL_DEV(String uRL_DEV) {
        URL_DEV = uRL_DEV;
    }
    public String getURL_OP() {
        return URL_OP;
    }
    public void setURL_OP(String uRL_OP) {
        URL_OP = uRL_OP;
    }
    public String getSECU_IP() {
        return SECU_IP;
    }
    public void setSECU_IP(String sECU_IP) {
        SECU_IP = sECU_IP;
    }
    public String getSECU_CE() {
        return SECU_CE;
    }
    public void setSECU_CE(String sECU_CE) {
        SECU_CE = sECU_CE;
    }
    public String getSECU_ROLE() {
        return SECU_ROLE;
    }
    public void setSECU_ROLE(String sECU_ROLE) {
        SECU_ROLE = sECU_ROLE;
    }
    public String getSECU_TLE() {
        return SECU_TLE;
    }
    public void setSECU_TLE(String sECU_TLE) {
        SECU_TLE = sECU_TLE;
    }
    public String getAT_IDS() {
        return AT_IDS;
    }
    public void setAT_IDS(String aT_IDS) {
        AT_IDS = aT_IDS;
    }
    public String getAT_IS() {
        return AT_IS;
    }
    public void setAT_IS(String aT_IS) {
        AT_IS = aT_IS;
    }
    public String getAT_ETC() {
        return AT_ETC;
    }
    public void setAT_ETC(String aT_ETC) {
        AT_ETC = aT_ETC;
    }
    public String getCONS_CONT() {
        return CONS_CONT;
    }
    public void setCONS_CONT(String cONS_CONT) {
        CONS_CONT = cONS_CONT;
    }
    public String getDEP_VER() {
        return DEP_VER;
    }
    public void setDEP_VER(String dEP_VER) {
        DEP_VER = dEP_VER;
    }
    public String getDEP_STR_DT() {
        return DEP_STR_DT;
    }
    public void setDEP_STR_DT(String dEP_STR_DT) {
        DEP_STR_DT = dEP_STR_DT;
    }
    public String getDEP_DEP_DT() {
        return DEP_DEP_DT;
    }
    public void setDEP_DEP_DT(String dEP_DEP_DT) {
        DEP_DEP_DT = dEP_DEP_DT;
    }
    public String getREG_DT() {
        return REG_DT;
    }
    public void setREG_DT(String rEG_DT) {
        REG_DT = rEG_DT;
    }
    @Override
    public String toString() {
        return "[COM_SE_ID=" + COM_SE_ID + ", SPECIFY_GB="
                + SPECIFY_GB + ", SE_NM_KR=" + SE_NM_KR + ", SE_NM_EN="
                + SE_NM_EN + ", SE_CONT=" + SE_CONT + ", SE_LV=" + SE_LV
                + ", OP_LV=" + OP_LV + ", OP_CD=" + OP_CD + ", URL_DEV="
                + URL_DEV + ", URL_OP=" + URL_OP + ", SECU_IP=" + SECU_IP
                + ", SECU_CE=" + SECU_CE + ", SECU_ROLE=" + SECU_ROLE
                + ", SECU_TLE=" + SECU_TLE + ", AT_IDS=" + AT_IDS + ", AT_IS="
                + AT_IS + ", AT_ETC=" + AT_ETC + ", CONS_CONT=" + CONS_CONT
                + ", DEP_VER=" + DEP_VER + ", DEP_STR_DT=" + DEP_STR_DT
                + ", DEP_DEP_DT=" + DEP_DEP_DT + ", REG_DT=" + REG_DT + "]";
    }
}
