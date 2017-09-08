package org.proposal.manager.UsrInfoService.service;

import org.commons.naraService.UsrInfoService.DminsttInfo.DminsttInfoReqVo;
import org.commons.naraService.UsrInfoService.PrcrmntCorpBasicInfo.PrcrmntCorpBasicInfoReqVo;
import org.commons.naraService.UsrInfoService.PrcrmntCorpIndstrytyInfo.PrcrmntCorpIndstrytyInfoReqVo;
import org.commons.naraService.UsrInfoService.PrcrmntCorpSplyPrdctInfo.PrcrmntCorpSplyPrdctInfoReqVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
/**
 * 
 * 사용자정보서비스
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
@Service("usrInfoService")
public class UsrInfoServiceImpl {

    /** (필수)baseURI */
    @Value("#{serviceConfig.baseURI}")
    private String baseURI;
    /** (필수)서비스키 */
    @Value("#{serviceConfig.serviceKey}")
    private String ServiceKey;
    
    /**
     * 4.(서비스)조달업체공급물품정보조회 
     *   (service)getPrcrmntCorpSplyPrdctInfo
     * 사업자등록번호 기준으로 조달업체업종정보조회 요청
     * 
     * @param bizno 사업자등록번호 
     */
    public void searchSplyPrdctBizno(String bizno){
        PrcrmntCorpSplyPrdctInfoReqVo reqVo = new PrcrmntCorpSplyPrdctInfoReqVo();
        reqVo.searchBizno(bizno);
    }
    /**
     * 3.(서비스)조달업체업종정보조회 
     *   (service)getPrcrmntCorpIndstrytyInfo
     * 사업자등록번호 기준으로 조달업체업종정보조회 요청
     * 
     * @param bizno 사업자등록번호 
     */
    public void searchIndstrytyBizno(String bizno){
        PrcrmntCorpIndstrytyInfoReqVo reqVo = new PrcrmntCorpIndstrytyInfoReqVo();
        reqVo.searchBizno(bizno);
    }
    /**
     * 2.3.(서비스)조달업체 기본정보 조회 
     *   (service)getPrcrmntCorpBasicInfo
     * 사업자등록번호 기준으로 조달업체 기본정보 조회  요청
     * 
     * @param bizno 사업자등록번호 
     */
    public void searchBasicBizno(String bizno){
        PrcrmntCorpBasicInfoReqVo reqVo = new PrcrmntCorpBasicInfoReqVo();
        reqVo.searchBizno(bizno);
    }    /**
     * 2.2.(서비스)조달업체 기본정보 조회 
     * (service)getPrcrmntCorpBasicInfo
     * 변경일기준 검색으로 조달업체 기본정보 조회  요청
     * 
     * @param inqryBgnDt 변경일 시작일시
     * @param inqryEndDt 변경일 종료일시
     * @param corpNm 업체명
     */
    public void searchBasicChDt(String inqryBgnDt,String inqryEndDt,String corpNm){
        PrcrmntCorpBasicInfoReqVo reqVo = new PrcrmntCorpBasicInfoReqVo();
        reqVo.searchChDt(inqryBgnDt, inqryEndDt, corpNm);
    }    /**
     * 2.1.(서비스)조달업체 기본정보 조회 
     * (service)getPrcrmntCorpBasicInfo
     * 등록일기준 검색으로 조달업체 기본정보 조회  요청
     * 
     * @param inqryBgnDt 등록일 시작일시
     * @param inqryEndDt 등록일 종료일시
     * @param corpNm 업체명
     */
    public void searchBasicRgDt(String inqryBgnDt,String inqryEndDt,String corpNm){
        PrcrmntCorpBasicInfoReqVo reqVo = new PrcrmntCorpBasicInfoReqVo();
        reqVo.searchRgDt(inqryBgnDt, inqryEndDt, corpNm);
    }
    
    /**
     * 1.3.(서비스)수요기관정보조회 
     *     (service)getDminsttInfo
     * 사업자등록번호 기준으로 수요기관정보조회 요청
     * 
     * @param bizno 사업자등록번호 
     */
    public void searchDminsttBizno(String bizno){
        DminsttInfoReqVo reqVo = new DminsttInfoReqVo();
        reqVo.searchBizno(bizno);
    }    /**
     * 1.2.(서비스)수요기관정보조회 
     *     (service)getDminsttInfo
     * 변경일기준 검색으로 수요기관정보조회 요청
     * 
     * @param inqryBgnDt 조회기준시작일시
     * @param inqryEndDt 조회기준종료일시
     * @param dminsttCd 수요기관코드
     * @param dminsttNm 수요기관명
     */
    public void searchDminsttChDt(String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        DminsttInfoReqVo reqVo = new DminsttInfoReqVo();
        reqVo.searchChDt(inqryBgnDt, inqryEndDt, dminsttCd, dminsttNm);
    }    /**
     * 1.1.(서비스)수요기관정보조회 
     *     (service)getDminsttInfo
     * 등록일기준 검색으로 수요기관정보조회 요청
     * 
     * @param inqryBgnDt 조회기준시작일시
     * @param inqryEndDt 조회기준종료일시
     * @param dminsttCd 수요기관코드
     * @param dminsttNm 수요기관명
     */
    public void searchDminsttRgDt(String inqryBgnDt,String inqryEndDt,String dminsttCd,String dminsttNm){
        DminsttInfoReqVo reqVo = new DminsttInfoReqVo();
        reqVo.searchRgDt(inqryBgnDt, inqryEndDt, dminsttCd, dminsttNm);
    }
    
    
}
