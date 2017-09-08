package org.commons.naraService.UsrInfoService.PrcrmntCorpIndstrytyInfo;
/**
 * 빠른 검색기능 서비스 의 Item View Object 클래스
 * 
 * (서비스)조달업체업종정보조회 (service)getPrcrmntCorpIndstrytyInfo
 * 
 * 필수항목(1) 
 * String bizno= "사업자등록번호"
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
 */
public class PrcrmntCorpIndstrytyInfoVo {
    public PrcrmntCorpIndstrytyInfoVo(){};
    private String bizno= "사업자등록번호";
    private String indstrytyNm= "업종명";
    private String indstrytyCd= "업종코드";
    private String rgstDt= "등록일시";
    private String vldPrdExprtDt= "유효기간만료일시";
    private String systmRgstDt= "시스템등록일시";
    private String chgDt= "변경일시";
    private String indstrytyStatsNm= "업종상태명";
    private String rprsntIndstrytyYn= "대표업종여부";
    
    public String getBizno() {
        return bizno;
    }
    public void setBizno(String bizno) {
        this.bizno = bizno;
    }
    public String getIndstrytyNm() {
        return indstrytyNm;
    }
    public void setIndstrytyNm(String indstrytyNm) {
        this.indstrytyNm = indstrytyNm;
    }
    public String getIndstrytyCd() {
        return indstrytyCd;
    }
    public void setIndstrytyCd(String indstrytyCd) {
        this.indstrytyCd = indstrytyCd;
    }
    public String getRgstDt() {
        return rgstDt;
    }
    public void setRgstDt(String rgstDt) {
        this.rgstDt = rgstDt;
    }
    public String getVldPrdExprtDt() {
        return vldPrdExprtDt;
    }
    public void setVldPrdExprtDt(String vldPrdExprtDt) {
        this.vldPrdExprtDt = vldPrdExprtDt;
    }
    public String getSystmRgstDt() {
        return systmRgstDt;
    }
    public void setSystmRgstDt(String systmRgstDt) {
        this.systmRgstDt = systmRgstDt;
    }
    public String getChgDt() {
        return chgDt;
    }
    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }
    public String getIndstrytyStatsNm() {
        return indstrytyStatsNm;
    }
    public void setIndstrytyStatsNm(String indstrytyStatsNm) {
        this.indstrytyStatsNm = indstrytyStatsNm;
    }
    public String getRprsntIndstrytyYn() {
        return rprsntIndstrytyYn;
    }
    public void setRprsntIndstrytyYn(String rprsntIndstrytyYn) {
        this.rprsntIndstrytyYn = rprsntIndstrytyYn;
    }

    
}
