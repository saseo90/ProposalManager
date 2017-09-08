package org.commons.naraService.UsrInfoService;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * 요청할 URI 변수의 기본내용
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
public class ReqVo {
    /** (필수)한 페이지 결과 수 */
    private String numOfRows = null;
    /** (필수)페이지 번호 */
    private String pageNo = null;
    /** (필수)서비스키 */
    @Value("${Globals.serviceKey}")
    private String ServiceKey;
    
    private void makeUri(){
        String baseURI="http://apis.data.go.kr/1230000/UsrInfoService/getPrcrmntCorpSplyPrdctInfo?";
    }
}
