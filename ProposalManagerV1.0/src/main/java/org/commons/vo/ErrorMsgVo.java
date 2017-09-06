package org.commons.vo;

/**
 * 에러 메시지 레코드 상세정보 view object 클래스 
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
public class ErrorMsgVo {
    
    private String codeName=null;//Code(01~32)
    private String codeValue=null;//코드값
    private String codeCont=null;//설명
    private String codePlan=null;//조치방안    
    
    public ErrorMsgVo(){};
    
    public String getCodeName() {
        return codeName;
    }
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    public String getCodeValue() {
        return codeValue;
    }
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
    public String getCodeCont() {
        return codeCont;
    }
    public void setCodeCont(String codeCont) {
        this.codeCont = codeCont;
    }
    public String getCodePlan() {
        return codePlan;
    }
    public void setCodePlan(String codePlan) {
        this.codePlan = codePlan;
    }
   
}
