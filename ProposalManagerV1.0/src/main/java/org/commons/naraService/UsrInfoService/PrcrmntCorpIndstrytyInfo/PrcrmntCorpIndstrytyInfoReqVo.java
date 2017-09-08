package org.commons.naraService.UsrInfoService.PrcrmntCorpIndstrytyInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

/**
 * 요청 URI 를 만들기 위한 클래스
 * 
 * (서비스)조달업체업종정보조회 (service)getPrcrmntCorpIndstrytyInfo
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
public class PrcrmntCorpIndstrytyInfoReqVo {
    protected Logger log = Logger.getLogger(this.getClass());
    /** (필수)baseURI */
    private String baseURI;
    /** (필수)서비스URI */
    private String serviceURI="UsrInfoService";
    /** (필수)Operation URI */
    private String operationURI="getPrcrmntCorpIndstrytyInfo";
    /** (필수)서비스키 */
    private String ServiceKey;
    /** (필수)한 페이지 결과 수 */
    private String numOfRows = "100";
    /** (필수)페이지 번호 */
    private String pageNo = "1";
    /** (필수)사업자등록번호 */
    private String bizno = null;
    
    public PrcrmntCorpIndstrytyInfoReqVo(){};
    /**
     * 
     * 사업자등록번호 기준으로 조달업체업종정보조회
     * 
     * @param bizno 사업자등록번호 
     * 
     */
    public String searchBizno(String bizno){
        this.bizno = bizno;
        return makeUriBizno(bizno);
    }
    private String makeUriBizno(String bizno){
        String baseURI = this.baseURI+serviceURI+"/"+operationURI
                +"?"+"&ServiceKey="+ServiceKey+"numOfRows="+numOfRows+"&pageNo="+pageNo+"&bizno="+bizno;
        //log.error(""+baseURI);
        return baseURI;
    }

}
