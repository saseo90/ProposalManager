package org.commons.UsrInfoService.PrcrmntCorpSplyPrdctInfo;

import org.springframework.beans.factory.annotation.Value;

/**
 * 요청 URI 를 만들기 위한 클래스
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
 *
 */
public class PrcrmntCorpSplyPrdctInfoReqVo {
    /** (필수)baseURI */
    @Value("${Globals.baseURI}")
    private String baseURI;
    /** (필수)한 페이지 결과 수 */
    private String numOfRows = "100";
    /** (필수)페이지 번호 */
    private String pageNo = "1";
    /** (필수)서비스키 */
    @Value("${Globals.serviceKey}")
    private String ServiceKey;
    /** (필수)사업자등록번호 */
    private String bizno = null;
    
    public PrcrmntCorpSplyPrdctInfoReqVo(){};
    /**
     * 사업자등록번호 기준으로 조달업체업종정보조회
     * 
     * @param bizno 사업자등록번호 
     */
    public void searchBizno(String bizno){
        this.bizno = bizno;
    }
    private void makeUri(){
        makeUri(null, null);
    }
    private void makeUri(String serviceName){
        makeUri(null, null);
    }
    private void makeUri(String operationName, String serviceName){
        String baseURI="http://apis.data.go.kr/1230000/UsrInfoService/getPrcrmntCorpSplyPrdctInfo?";
        baseURI += "numOfRows="+numOfRows+"&pageNo="+pageNo+"&ServiceKey="+ServiceKey+"&bizno="+bizno;
        
    }
    
}
