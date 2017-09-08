package org.commons.naraService.UsrInfoService.PrcrmntCorpSplyPrdctInfo;
/**
 * 빠른 검색기능 서비스 의 Item View Object 클래스
 * 
 * (서비스)조달업체공급물품정보조회 (service)getPrcrmntCorpSplyPrdctInfo
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
public class PrcrmntCorpSplyPrdctInfoVo {
    public PrcrmntCorpSplyPrdctInfoVo(){};
    private String bizno= "사업자등록번호";
    private String dtilPrdctClsfcNoNm= "세부품명";
    private String dtilPrdctClsfcNo= "세부품명번호";
    private String rgstDt= "등록일시";
    private String chgDt= "변경일시";
    private String rprsntPrdctClsfcNoNmYn= "대표품명여부";
    public String getBizno() {
        return bizno;
    }
    public void setBizno(String bizno) {
        this.bizno = bizno;
    }
    public String getDtilPrdctClsfcNoNm() {
        return dtilPrdctClsfcNoNm;
    }
    public void setDtilPrdctClsfcNoNm(String dtilPrdctClsfcNoNm) {
        this.dtilPrdctClsfcNoNm = dtilPrdctClsfcNoNm;
    }
    public String getDtilPrdctClsfcNo() {
        return dtilPrdctClsfcNo;
    }
    public void setDtilPrdctClsfcNo(String dtilPrdctClsfcNo) {
        this.dtilPrdctClsfcNo = dtilPrdctClsfcNo;
    }
    public String getRgstDt() {
        return rgstDt;
    }
    public void setRgstDt(String rgstDt) {
        this.rgstDt = rgstDt;
    }
    public String getChgDt() {
        return chgDt;
    }
    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }
    public String getRprsntPrdctClsfcNoNmYn() {
        return rprsntPrdctClsfcNoNmYn;
    }
    public void setRprsntPrdctClsfcNoNmYn(String rprsntPrdctClsfcNoNmYn) {
        this.rprsntPrdctClsfcNoNmYn = rprsntPrdctClsfcNoNmYn;
    }
    

}
