package org.commons.naraService.UsrInfoService;

import java.util.List;

/**
 * 
 * 응답받은 내용 XML 을 변환한 결과 View Object
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
public class ItemsVo {
    public ItemsVo(){};
    /** 결과코드 */
    private String resultCode= "결과코드";
    /** 결과메시지 */
    private String resultMsg= "결과메세지";
    /** Item */
    private List<Object> itemObject = null;//item
    /** 한 페이지 결과 수 */
    private String numOfRows= "한 페이지 결과 수";
    /** 페이지 번호" */
    private String pageNo= "페이지 번호";
    /** 전체 결과 수 */
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
    public List<Object> getItemObject() {
        return itemObject;
    }
    public void setItemObject(List<Object> itemObject) {
        this.itemObject = itemObject;
    }
    @Override
    public String toString() {
        return "ItemsVo [resultCode=" + resultCode + ", resultMsg=" + resultMsg + ", itemObject=" + itemObject
                + ", numOfRows=" + numOfRows + ", pageNo=" + pageNo + ", totalCount=" + totalCount + "]";
    }
}
