package org.commons.UsrInfoService.PrcrmntCorpBasicInfo;

import org.springframework.beans.factory.annotation.Value;

/**
 * 요청 URI 를 만들기 위한 클래스
 * 
 * (서비스)조달업체 기본정보 조회 (service)PrcrmntCorpBasicInfo
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
public class PrcrmntCorpBasicInfoReqVo {
    /** (필수)한 페이지 결과 수 */
    private String numOfRows = null;
    /** (필수)페이지 번호 */
    private String pageNo = null;
    /** (필수)서비스키 */
    @Value("${Globals.serviceKey}")
    private String ServiceKey;
    /** 조회구분 1: 등록일기준 검색, 2: 변경일기준 검색, 3: 사업자등록번호 기준검색 */
    private String inqryDiv = "조회구분";//필수
    /** 조회기준시작일시 "YYYYMMDDHHMM" */
    private String inqryBgnDt = "조회기준시작일시";
    /** 조회기준종료일시 "YYYYMMDDHHMM" */
    private String inqryEndDt = "조회기준종료일시";
    /** 업체명 */
    private String corpNm = "업체명";
    /** 사업자등록번호 */
    private String bizno = "사업자등록번호";
    

    /**
     * 조회구분 inqryDiv 의 값 
     * 3: 사업자등록번호 기준검색
     * 
     * @param bizno
     */
    public void searchBizno(String bizno){
        inqryDiv = "3";
        this.bizno = bizno;
    }
    
    /**
     * 조회구분 inqryDiv 의 값 
     * 2: 변경일기준 검색
     * 
     * @param bizno 사업자등록번호
     * @param inqryBgnDt 변경일 시작일시
     * @param inqryEndDt 변경일 종료일시
     * @param corpNm 업체명
     */
    public void searchChDt(String bizno,String inqryBgnDt,String inqryEndDt,String corpNm){
        inqryDiv = "2";
        this.bizno = bizno;
        this.inqryBgnDt = inqryBgnDt;
        this.inqryEndDt = inqryEndDt;
        this.corpNm = corpNm;
    }
    
    /**
     * 조회구분 inqryDiv 의 값 
     * 1: 등록일기준 검색
     * 
     * @param bizno 사업자등록번호
     * @param inqryBgnDt 등록일 시작일시
     * @param inqryEndDt 등록일 종료일시
     * @param corpNm 업체명
     */
    public void searchRgDt(String bizno,String inqryBgnDt,String inqryEndDt,String corpNm){
        inqryDiv = "1";
        this.bizno = bizno;
        this.inqryBgnDt = inqryBgnDt;
        this.inqryEndDt = inqryEndDt;
        this.corpNm = corpNm;
    }
}
