package org.commons.UsrInfoService.DminsttInfo;

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

    /** 한 페이지 결과 수 */
    private String numOfRows = null;//필수
    /** 페이지 번호 */
    private String pageNo = null;//필수
    /** 서비스키 */
    private String ServiceKey = null;//필수
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
     * @param bizno
     */
    public void searchBizno(String bizno){
        this.inqryDiv = "3";
        this.bizno = bizno;
    }
    
    /**
     * 조회구분 inqryDiv 의 값 
     * 2: 변경일기준 검색
     * 
     * @param bizno
     * @param inqryBgnDt
     * @param inqryEndDt
     * @param dminsttCd
     * @param dminsttNm
     */
    public void searchChDt(String bizno,String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        this.inqryDiv = "2";
        this.bizno = bizno;
        this.inqryBgnDt = inqryBgnDt;
        this.inqryEndDt = inqryEndDt;
        this.dminsttCd = dminsttCd;
        this.dminsttNm = dminsttNm;
    }
    
    /**
     * 조회구분 inqryDiv 의 값 
     * 1: 등록일기준 검색
     * 
     * @param bizno
     * @param inqryBgnDt
     * @param inqryEndDt
     * @param dminsttCd
     * @param dminsttNm
     */
    public void searchRgDt(String bizno,String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        this.inqryDiv = "1";
        this.bizno = bizno;
        this.inqryBgnDt = inqryBgnDt;
        this.inqryEndDt = inqryEndDt;
        this.dminsttCd = dminsttCd;
        this.dminsttNm = dminsttNm;
    }
}
