package org.commons.naraService.UsrInfoService.DminsttInfo;
/**
 * 빠른 검색기능 서비스 의 Item View Object 클래스
 * 
 * (서비스)수요기관정보조회 (service)getDminsttInfo
 * 
 * 필수항목(1) 
 * String dminsttCd= "수요기관코드"
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
public class DminsttInfoVo {

    public DminsttInfoVo(){};
    

    private String dminsttCd= "수요기관코드";// 필수
    private String vldPrdBgnDt= "유효기간시작일시";
    private String vldPrdEndDt= "유효기간종료일시";
    private String dminsttNm= "수요기관명";
    private String dminsttAbrvtNm= "수요기관약어명";
    private String dminsttEngNm= "수요기관영문명";
    private String corprtRgstNo= "법인등록번호";
    private String bizno= "사업자등록번호";
    private String jrsdctnDivNm= "소관구분명";
    private String insttTyCdLrgclsfcNm= "기관유형코드대분류명";
    private String insttTyCdMidclsfcNm= "기관유형코드중분류명";
    private String insttTyCdSmlclsfcNm= "기관유형코드소분류명";
    private String bizcndtnNm= "업태명";
    private String indstrytyNm= "업종명";
    private String ofclFaxNo= "담당자팩스번호";
    private String rgnCd= "지역코드";
    private String rgnNm= "지역명";
    private String zip= "우편번호";
    private String adrs= "주소";
    private String dtlAdrs= "상세주소";
    private String telNo= "전화번호";
    private String faxNo= "팩스번호";
    private String hmpgAdrs= "홈페이지주소";
    private String dltYn= "삭제여부";
    private String toplvlInsttCd= "최상위기관코드";
    private String toplvlInsttNm= "최상위기관명";
    private String rgstDt= "등록일시";
    private String chgDt= "변경일시";
    

    public String getDminsttCd() {
        return dminsttCd;
    }
    public void setDminsttCd(String dminsttCd) {
        this.dminsttCd = dminsttCd;
    }
    public String getVldPrdBgnDt() {
        return vldPrdBgnDt;
    }
    public void setVldPrdBgnDt(String vldPrdBgnDt) {
        this.vldPrdBgnDt = vldPrdBgnDt;
    }
    public String getVldPrdEndDt() {
        return vldPrdEndDt;
    }
    public void setVldPrdEndDt(String vldPrdEndDt) {
        this.vldPrdEndDt = vldPrdEndDt;
    }
    public String getDminsttNm() {
        return dminsttNm;
    }
    public void setDminsttNm(String dminsttNm) {
        this.dminsttNm = dminsttNm;
    }
    public String getDminsttAbrvtNm() {
        return dminsttAbrvtNm;
    }
    public void setDminsttAbrvtNm(String dminsttAbrvtNm) {
        this.dminsttAbrvtNm = dminsttAbrvtNm;
    }
    public String getDminsttEngNm() {
        return dminsttEngNm;
    }
    public void setDminsttEngNm(String dminsttEngNm) {
        this.dminsttEngNm = dminsttEngNm;
    }
    public String getCorprtRgstNo() {
        return corprtRgstNo;
    }
    public void setCorprtRgstNo(String corprtRgstNo) {
        this.corprtRgstNo = corprtRgstNo;
    }
    public String getBizno() {
        return bizno;
    }
    public void setBizno(String bizno) {
        this.bizno = bizno;
    }
    public String getJrsdctnDivNm() {
        return jrsdctnDivNm;
    }
    public void setJrsdctnDivNm(String jrsdctnDivNm) {
        this.jrsdctnDivNm = jrsdctnDivNm;
    }
    public String getInsttTyCdLrgclsfcNm() {
        return insttTyCdLrgclsfcNm;
    }
    public void setInsttTyCdLrgclsfcNm(String insttTyCdLrgclsfcNm) {
        this.insttTyCdLrgclsfcNm = insttTyCdLrgclsfcNm;
    }
    public String getInsttTyCdMidclsfcNm() {
        return insttTyCdMidclsfcNm;
    }
    public void setInsttTyCdMidclsfcNm(String insttTyCdMidclsfcNm) {
        this.insttTyCdMidclsfcNm = insttTyCdMidclsfcNm;
    }
    public String getInsttTyCdSmlclsfcNm() {
        return insttTyCdSmlclsfcNm;
    }
    public void setInsttTyCdSmlclsfcNm(String insttTyCdSmlclsfcNm) {
        this.insttTyCdSmlclsfcNm = insttTyCdSmlclsfcNm;
    }
    public String getBizcndtnNm() {
        return bizcndtnNm;
    }
    public void setBizcndtnNm(String bizcndtnNm) {
        this.bizcndtnNm = bizcndtnNm;
    }
    public String getIndstrytyNm() {
        return indstrytyNm;
    }
    public void setIndstrytyNm(String indstrytyNm) {
        this.indstrytyNm = indstrytyNm;
    }
    public String getOfclFaxNo() {
        return ofclFaxNo;
    }
    public void setOfclFaxNo(String ofclFaxNo) {
        this.ofclFaxNo = ofclFaxNo;
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
    public String getHmpgAdrs() {
        return hmpgAdrs;
    }
    public void setHmpgAdrs(String hmpgAdrs) {
        this.hmpgAdrs = hmpgAdrs;
    }
    public String getDltYn() {
        return dltYn;
    }
    public void setDltYn(String dltYn) {
        this.dltYn = dltYn;
    }
    public String getToplvlInsttCd() {
        return toplvlInsttCd;
    }
    public void setToplvlInsttCd(String toplvlInsttCd) {
        this.toplvlInsttCd = toplvlInsttCd;
    }
    public String getToplvlInsttNm() {
        return toplvlInsttNm;
    }
    public void setToplvlInsttNm(String toplvlInsttNm) {
        this.toplvlInsttNm = toplvlInsttNm;
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

    
}
