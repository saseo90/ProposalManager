package org.commons.UsrInfoService.PrcrmntCorpSplyPrdctInfo;

import java.util.List;

import org.commons.UsrInfoService.DminsttInfo.DminsttInfoVo;

/**
 * 빠른 검색기능 서비스 의 Items View Object 클래스
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
public class PrcrmntCorpSplyPrdctInfoList {
    public PrcrmntCorpSplyPrdctInfoList(){};
    
    private String resultCode= "결과코드";
    private String resultMsg= "결과메세지";
    private List<DminsttInfoVo> dminsttInfoList = null;//item
    private String numOfRows= "한 페이지 결과 수";
    private String pageNo= "페이지 번호";
    private String totalCount= "전체 결과 수";
    
    public String getResultCode() {
        return resultCode;
    }
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    public String getResultMsg() {
        return resultMsg;
    }
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
    public String getNumOfRows() {
        return numOfRows;
    }
    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }
    public String getPageNo() {
        return pageNo;
    }
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }
    public String getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
    public List<DminsttInfoVo> getDminsttInfoList() {
        return dminsttInfoList;
    }
    public void setDminsttInfoList(List<DminsttInfoVo> dminsttInfoList) {
        this.dminsttInfoList = dminsttInfoList;
    }
}
