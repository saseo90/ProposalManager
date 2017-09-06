package org.commons.util.error;

import java.util.ArrayList;
import java.util.List;

import org.commons.vo.ErrorMsgVo;

/**
 * 에러 메시지 레코드 리스트 유틸
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
public class ErrorMsgUtil {
    
    private static List<ErrorMsgVo> errorMsgList=null;
    
    public ErrorMsgUtil() {
        if(errorMsgList==null){
            setCodeInfo();
        }
    }
    
    /**
     * 에러 메시지 레코드 리스트 전체반환
     * @return List<ErrorMsgVo> errorMsgList
     * 
     */
    public List<ErrorMsgVo> getErrorMsgList() {
        return errorMsgList;
    }
    
    /**
     * 특정 코드명의 상세정보를 반환한다.
     * 
     * @param codeName 코드명
     * @return ErrorMsgVo
     */
    public ErrorMsgVo getErrorMsg(String codeName) {
        ErrorMsgVo result = null;
        for (ErrorMsgVo errorMsgVo : errorMsgList) {
            if(errorMsgVo.getCodeName().equals(codeName)){
                result = errorMsgVo;
                break;
            }
        }
        return result;
    }
    
    /**
     * 에러코드 및 메시지 정보로드한다.
     * 최초 실행 시 한번만 로드한다.
     * 2017년 08월 26일 기준 
     */
    private void setCodeInfo(){
        String[][] errorMsgTable ={
        { "01" , "Application Error" , "제공기관 서비스 제공 상태가 원할하지 않습니다." , "서비스 제공기관의 관리자에게 문의하시기 바랍니다." }, 
        { "02" , "DB Error" , "제공기관 서비스 제공 상태가 원할하지 않습니다." , "서비스 제공기관의 관리자에게 문의하시기 바랍니다." }, 
        { "03" , "No Data" , "데이터 없음 에러" , "" }, 
        { "04" , "HTTP Error" , "제공기관 서비스 제공 상태가 원할하지 않습니다." , "서비스 제공기관의 관리자에게 문의하시기 바랍니다." }, 
        { "05" , "service time out" , "제공기관 서비스 제공 상태가 원할하지 않습니다" , "서비스 제공기관의 관리자에게 문의하시기 바랍니다." }, 
        { "06" , "날짜Format 에러" , "날짜 Default, Format Error" , "날짜형식을 확인 하시기 바랍니다." }, 
        { "07" , "입력범위값 초과 에러" , "요청하신 OpenAPI의 파라미터 입력값 범위가 초과 되었습니다." , "기술문서를 다시 한번 확인하여 주시기 바랍니다." }, 
        { "08" , "필수값 입력 에러" , "요청하신 OpenAPI의 필수 파라미터가 누락되었습니다." , "기술문서를 다시 한번 확인하여 주시기 바랍니다." },
        { "10" , "잘못된 요청 파라미터 에러" , "OpenAPI 요청시 ServiceKey 파라미터가 없음" , "1. OpenAPI 요청시 ServiceKey 파라미터가 누락되었습니다. 2. OpenAPI 요청 URL을 확인하시기 바랍니다." }, 
        { "11" , "필수 요청 파라미터가 없음" , "요청하신 OpenAPI의 필수 파라미터가 누락되었습니다." , "기술문서를 다시 한번 확인하시어 주시기 바랍니다." }, 
        { "12" , "해당 오픈API 서비스가 없거나 폐기됨" , "OpenAPI 호출시 URL이 잘못됨" , "제공기관 관리자에게 폐기된 서비스인지 확인바랍니다. 폐기된 서비스가 아니면 개발가이드에서 OpenAPI요청 URL을 다시 확인하시기 바랍니다." }, 
        { "20" , "서비스 접근 거부" , "활용승인이 되지 않은 OpenAPI호출" , "1. OpenAPI활용신청정보의 승인상태를 확인하시기 바랍니다. 2. 활용신청에 대해 제공기관 담당자가 확인 후 '승인'이후 부터 사용할 수 있습니다. 3. 신청 후 2~3일 소요되고 결과는 회원가입 시 등록한 e-mail로 발송됩니다." }, 
        { "22" , "서비스 요청 제한 횟수 초과 에러" , "일일 활용건수가 초과함(활용건수 증가 필요)" , "1. OpenAPI활용신청정보의 서비스 상세기능별 일일 트래픽량을 확인하시기 바랍니다. 2. 개발계정의 경우 제공기관에서 정의한 트래픽을 초과하여 활용할 수 없습니다. 3. 운영계정의 경우 변경신청을 통해서 일일트래픽량을 변경 할 수 있습니다. " }, 
        { "30" , "등록되지 않은 서비스 키" , "잘못된 서비스키를 사용하였거나 서비스키를 URL인코딩하지 않았습니다." , "1. OpenAPI활용신청정보의 발급받은 서비스키를 다시 확인하시기 바랍니다. 2. 서비스키 값이 같다면 서비스키가 URL 인코등 되었는지 다시 확인하시기 바랍니다." }, 
        { "31" , "기한 만료된 서비스 키" , "OpenAPI 사용기간이 만료됨(활용연장신청 후 사용가능)" , "1. OpenAPI 활용신청정보의 활용기간을 확인합니다. 2. 활용기간이 지난 서비스는 이용할 수 없으며 연장신청을 통해 승인 받은 후 다시 이용가능 합니다." }, 
        { "32" , "등록되지 않은 도메인명 또는 IP주소" , "활용신청한 서버의 IP와 실제 OpenAPI호출한 서버가 다를 경우" , "1. OpenAPI 활용신청정보의 등록된 도메인명이나 IP주소를 다시 확인합니다. 2. IP나 도메인의 정보를 변경하기 위해 변경신청을 할 수 있습니다." }
        };

        List<ErrorMsgVo> errorMsgListTemp = new ArrayList<ErrorMsgVo>();
        ErrorMsgVo errorMsgTemp = null;

        for (String[] strings : errorMsgTable) {
            errorMsgTemp = new ErrorMsgVo();
            errorMsgTemp.setCodeName(strings[0]);
            errorMsgTemp.setCodeValue(strings[1]);
            errorMsgTemp.setCodeCont(strings[2]);
            errorMsgTemp.setCodePlan(strings[3]);
            errorMsgListTemp.add(errorMsgTemp);
        }
        errorMsgList = errorMsgListTemp;
    }
}
