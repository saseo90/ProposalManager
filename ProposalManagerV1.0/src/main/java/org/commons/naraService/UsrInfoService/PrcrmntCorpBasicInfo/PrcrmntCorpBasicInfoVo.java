package org.commons.naraService.UsrInfoService.PrcrmntCorpBasicInfo;
/**
 * 빠른 검색기능 서비스 의 Item View Object 클래스
 * 
 * (서비스)조달업체 기본정보 조회 (service)PrcrmntCorpBasicInfo
 * 
 * 필수항목(2) 
 * String bizno= "사업자등록번호", String hdoffceDivNm= "본사구분명"
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
public class PrcrmntCorpBasicInfoVo {
    
    private String bizno= "사업자등록번호";//필수
    private String corpNm= "업체명";
    private String engCorpNm= "영문업체명";
    private String opbizDt= "개업일시";
    private String rgnCd= "지역코드";
    private String rgnNm= "지역명";
    private String zip= "우편번호";
    private String adrs= "주소";
    private String dtlAdrs= "상세주소";
    private String telNo= "전화번호";
    private String faxNo= "팩스번호";
    private String cntryNm= "국가명";
    private String hmpgAdrs= "홈페이지주소";
    private String mnfctDivCd= "제조구분코드";
    private String mnfctDivNm= "제조구분명";
    private String emplyeNum= "종업원수";
    private String corpBsnsDivCd= "업체업무구분코드";
    private String corpBsnsDivNm= "업체업무구분명";
    private String hdoffceDivNm= "본사구분명";//필수
    private String rgstDt= "등록일시";
    private String chgDt= "변경일시";
    private String esntlNoCertRgstYn= "고유번호증명등록여부";
    private String ceoNm= "대표자명";

    public String getBizno() {
        return bizno;
    }
    public void setBizno(String bizno) {
        this.bizno = bizno;
    }
    public String getCorpNm() {
        return corpNm;
    }
    public void setCorpNm(String corpNm) {
        this.corpNm = corpNm;
    }
    public String getEngCorpNm() {
        return engCorpNm;
    }
    public void setEngCorpNm(String engCorpNm) {
        this.engCorpNm = engCorpNm;
    }
    public String getOpbizDt() {
        return opbizDt;
    }
    public void setOpbizDt(String opbizDt) {
        this.opbizDt = opbizDt;
    }
    public String getRgnCd() {
        return rgnCd;
    }
    public void setRgnCd(String rgnCd) {
        this.rgnCd = rgnCd;
    }
    public String getRgnNm() {
        return rgnNm;
    }
    public void setRgnNm(String rgnNm) {
        this.rgnNm = rgnNm;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getAdrs() {
        return adrs;
    }
    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }
    public String getDtlAdrs() {
        return dtlAdrs;
    }
    public void setDtlAdrs(String dtlAdrs) {
        this.dtlAdrs = dtlAdrs;
    }
    public String getTelNo() {
        return telNo;
    }
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    public String getFaxNo() {
        return faxNo;
    }
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }
    public String getCntryNm() {
        return cntryNm;
    }
    public void setCntryNm(String cntryNm) {
        this.cntryNm = cntryNm;
    }
    public String getHmpgAdrs() {
        return hmpgAdrs;
    }
    public void setHmpgAdrs(String hmpgAdrs) {
        this.hmpgAdrs = hmpgAdrs;
    }
    public String getMnfctDivCd() {
        return mnfctDivCd;
    }
    public void setMnfctDivCd(String mnfctDivCd) {
        this.mnfctDivCd = mnfctDivCd;
    }
    public String getMnfctDivNm() {
        return mnfctDivNm;
    }
    public void setMnfctDivNm(String mnfctDivNm) {
        this.mnfctDivNm = mnfctDivNm;
    }
    public String getEmplyeNum() {
        return emplyeNum;
    }
    public void setEmplyeNum(String emplyeNum) {
        this.emplyeNum = emplyeNum;
    }
    public String getCorpBsnsDivCd() {
        return corpBsnsDivCd;
    }
    public void setCorpBsnsDivCd(String corpBsnsDivCd) {
        this.corpBsnsDivCd = corpBsnsDivCd;
    }
    public String getCorpBsnsDivNm() {
        return corpBsnsDivNm;
    }
    public void setCorpBsnsDivNm(String corpBsnsDivNm) {
        this.corpBsnsDivNm = corpBsnsDivNm;
    }
    public String getHdoffceDivNm() {
        return hdoffceDivNm;
    }
    public void setHdoffceDivNm(String hdoffceDivNm) {
        this.hdoffceDivNm = hdoffceDivNm;
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
    public String getEsntlNoCertRgstYn() {
        return esntlNoCertRgstYn;
    }
    public void setEsntlNoCertRgstYn(String esntlNoCertRgstYn) {
        this.esntlNoCertRgstYn = esntlNoCertRgstYn;
    }
    public String getCeoNm() {
        return ceoNm;
    }
    public void setCeoNm(String ceoNm) {
        this.ceoNm = ceoNm;
    }

    
}
