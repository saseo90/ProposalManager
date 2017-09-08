package org.commons.naraService.UsrInfoService.DminsttInfo;

/**
 * 요청 URI 를 만들기 위한 클래스
 * 
 * (서비스)수요기관정보조회 (service)getDminsttInfo
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
public class DminsttInfoReqVo {
    public DminsttInfoReqVo(){};
    /** (필수)baseURI */
    private String baseURI;
    /** (필수)서비스URI */
    private String serviceURI="UsrInfoService";
    /** (필수)Operation URI */
    private String operationURI="getDminsttInfo";
    /** (필수)서비스키 */
    private String ServiceKey;
    /** (필수)한 페이지 결과 수 */
    private String numOfRows = "100";
    /** (필수)페이지 번호 */
    private String pageNo = "1";
    /** 조회구분 1: 등록일기준 검색, 2: 변경일기준 검색, 3: 사업자등록번호 기준검색  */
    private String inqryDiv = null;//필수
    /** 조회기준시작일시 "YYYYMMDDHHMM" */
    private String inqryBgnDt = null;
    /** 조회기준종료일시 "YYYYMMDDHHMM" */
    private String inqryEndDt = null;
    /** 수요기관코드 */
    private String dminsttCd = null;
    /** 수요기관명 */
    private String dminsttNm = null;
    /** 사업자등록번호 */
    private String bizno = null;

    /**
     * 조회구분 inqryDiv 의 값 
     * 3: 사업자등록번호 기준검색
     * 
     * @param bizno 사업자등록번호
     */
    public String searchBizno(String bizno){
        this.inqryDiv = "3";
//        this.bizno = bizno;
        return makeUriBizno(bizno);
    }
    
    /**
     * 조회구분 inqryDiv 의 값 
     * 2: 변경일기준 검색
     * 
     * @param inqryBgnDt 조회기준시작일시
     * @param inqryEndDt 조회기준종료일시
     * @param dminsttCd 수요기관코드
     * @param dminsttNm 수요기관명
     */
    public String searchChDt(String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        this.inqryDiv = "2";
//        this.inqryBgnDt = inqryBgnDt;
//        this.inqryEndDt = inqryEndDt;
//        this.dminsttCd = dminsttCd;
//        this.dminsttNm = dminsttNm;
        return makeUriDate(inqryBgnDt,inqryEndDt,dminsttCd,dminsttNm);
    }
    
    /**
     * 조회구분 inqryDiv 의 값 
     * 1: 등록일기준 검색
     * 
     * @param inqryBgnDt 조회기준시작일시
     * @param inqryEndDt 조회기준종료일시
     * @param dminsttCd dminsttCd
     * @param dminsttNm 수요기관명
     */
    public String searchRgDt(String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        this.inqryDiv = "1";
        //this.inqryBgnDt = inqryBgnDt;
        //this.inqryEndDt = inqryEndDt;
        //this.corpNm = corpNm;
        return makeUriDate(inqryBgnDt,inqryEndDt,dminsttCd,dminsttNm);
    }
    
    private String makeUriBizno(String bizno){
        String baseURI = this.baseURI+serviceURI+"/"+operationURI+"?"+"&ServiceKey="+ServiceKey+"numOfRows="+numOfRows+"&pageNo="+pageNo+"&inqryDiv="+inqryDiv
                +"&bizno="+bizno;
        //log.error(""+baseURI);
        return baseURI;
    }
    
    private String makeUriDate(String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        String baseURI = this.baseURI+serviceURI+"/"+operationURI+"?"+"&ServiceKey="+ServiceKey+"numOfRows="+numOfRows+"&pageNo="+pageNo
                +"&inqryDiv="+inqryDiv+"&inqryBgnDt="+inqryBgnDt+"&inqryEndDt="+inqryEndDt+"&dminsttCd="+dminsttCd+"&dminsttNm="+dminsttNm;
        //log.error(""+baseURI);
        return baseURI;
    }
}
