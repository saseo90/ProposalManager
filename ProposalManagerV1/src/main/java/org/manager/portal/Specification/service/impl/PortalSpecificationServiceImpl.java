package org.manager.portal.Specification.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.manager.portal.Specification.MSGSpecificationVO;
import org.manager.portal.Specification.OperationVO;
import org.manager.portal.Specification.ServiceVO;
import org.manager.portal.Specification.service.PortalSpecificationService;
import org.springframework.stereotype.Service;


/**
 * 포털 명세서 출력 호출을 위한 서비스 인터페이스 구현체 서비스
 * @author 이성현
 * @since 2018.04.22
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일             수정자       수정내용
 *  ------------ ------ ----------------------------
 *   2018.04.22   이성현      최초 생성
 *  
 * </pre>
 */
@Service("portalSpecificationService")
public class PortalSpecificationServiceImpl implements PortalSpecificationService{

    @Resource(name="portalSpecificationDAO")
    PortalSpecificationDAO psDAO;
    
    /**
     * 라이브러리 종속 : poi-ooxml : XWPFDocument
     * int code : Object Type Code
     * int i    : index
     */
    @Override
    public void insertSpecificationDOC() {
        FileInputStream fis = null;
        String fileName = "D:\\조달청_OpenAPI활용가이드_나라장터_계약정보서비스_1.3_1.docx";
        try {
            File file = new File(fileName);
            fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            
            List<IBodyElement> bodyList = document.getBodyElements();
            int code = -2;
            int i = 0;
            List<ServiceVO> result = new ArrayList<ServiceVO>();
            ServiceVO tempVO = null;
            for (IBodyElement iBodyElement : bodyList) {
            String text = iBodyElement.getElementType().name();
            if("PARAGRAPH".equals(text)){
                XWPFParagraph para =  (XWPFParagraph) iBodyElement;
                String temp = para.getParagraphText();
                if(temp!=null){
                    if(temp.contentEquals("서비스 개요")){
                        code = 0;
                    } else if (temp.contains("오퍼레이션 목록")) {
//                        code = 1;
                    } else if (temp.contains("오퍼레이션 명세")) {
                        code = 2;
                    } else if (temp.contentEquals("요청 메시지 명세")) {
                        code = 3;
                    } else if (temp.contentEquals("응답 메시지 명세")) {
                        code = 4;
                    }
                } 
            }else if("TABLE".equals(text)) {
                if(0==code){//서비스 개요
                    ServiceVO serviceVO = new ServiceVO();
                    XWPFTable table = null;
                    table = document.getTables().get(i);
                    List<XWPFTableRow> rows = table.getRows();
                    for(XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        String text1 = null;
                        for (XWPFTableCell cell : cells) {
                            String text2 = cell.getText();
                            if(text1!=null){
                            if("서비스명(국문)".equals(text1)) {
                                serviceVO.setSE_NM_KR(text2);
                            }else if("서비스명(영문)".equals(text1)) {
                                serviceVO.setSE_NM_EN(text2);
                            }else if("서비스 설명".equals(text1)) {
                                serviceVO.setSE_CONT(text2);
                            }else if("서비스 인증/권한".equals(text1)) {
                                serviceVO.setSECU_CE(text2);
                            }else if("전송 레벨 암호화".equals(text1)) {
                                serviceVO.setSECU_TLE(text2);
                            }else if("교환 데이터 표준".equals(text1)) {
                                serviceVO.setAT_IDS(text2);
                            }else if("인터페이스 표준".equals(text1)) {
                                serviceVO.setAT_IS(text2);
                            }else if("개발환경".equals(text1)) {
                                serviceVO.setURL_DEV(text2);
                            }else if("운영환경".equals(text1)) {
                                serviceVO.setURL_OP(text2);
                            }else if("서비스 버전".equals(text1)) {
                                serviceVO.setDEP_VER(text2);
                            }else if("서비스 시작일".equals(text1)) {
                                serviceVO.setDEP_STR_DT(text2);
                            }else if("배포 일자".equals(text1)) {
                                serviceVO.setDEP_DEP_DT(text2);
                            }else if("서비스 이력".equals(text1)) {
                                serviceVO.setCONS_CONT(text2);
                            }
                            }
                            text1 = text2;
                        }//for
                    }//for
                    result.add(serviceVO);
                    code = -1;
                }else if(1==code){//오퍼레이션 목록 
                    XWPFTable table = null;
                    XWPFTableRow row = null;
                    table = document.getTables().get(i);
                    List<XWPFTableRow> rows = table.getRows();
                    for (int j = 1; j < rows.size(); j++) {
                        row = rows.get(j);
                        List<XWPFTableCell> cells = row.getTableCells();
                        if(!cells.isEmpty()){
                            String cont = cells.get(0).getText();
                            cont = cells.get(1).getText();//일련번호
                            cont = cells.get(2).getText();//서비스명(국문)
                            cont = cells.get(3).getText();//오퍼레이션명(영문)
                            cont = cells.get(4).getText();//오퍼레이션명(국문)
                            cont = cells.get(5).getText();//메시지명(영문)
                        }
                    }
                    code = -1;
                }else if(2==code){//오퍼레이션 명세
                    OperationVO opInfo = new OperationVO();
                    XWPFTable table = null;
                    table = document.getTables().get(i);
                    List<XWPFTableRow> rows = table.getRows();
                    for(XWPFTableRow row : rows) {
                        List<XWPFTableCell> cells = row.getTableCells();
                        String text1 = null;
                        for (XWPFTableCell cell : cells) {
                            String text2 = cell.getText();
                            if(text1!=null){
                            if("오퍼레이션명(국문)".equals(text1)){
                                opInfo.setSE_NM_KR(text2);
                            }else if("오퍼레이션명(영문)".equals(text1)) {
                                opInfo.setSE_NM_EN(text2);
                            }else if("오퍼레이션 설명".equals(text1)) 
                                opInfo.setSE_CONT(text2);{
                            }
                            }
                            text1 = text2;
                        }//for
                    }//for
                    result.get(result.size()-1).setOpInfos(opInfo);
                    code = -1; 
                }else if(3==code){//요청 메시지 명세
                    List<MSGSpecificationVO> msgListReq = createMSGReqList(document, i);
                    result.get(result.size()-1).getOpInfoLast().setMsgListReq(msgListReq);
                    code = -1;
                }else if(4==code){//응답 메시지 명세
                    List<MSGSpecificationVO> msgListRsp = createMSGRspList(document, i); 
                    result.get(result.size()-1).getOpInfoLast().setMsgListRsp(msgListRsp);
                    code = -1; 
                }//if
                i++;
            }//if(PARAGRAPH|table)
            }//for
            
            for (ServiceVO serviceVO : result) {
                psDAO.insertServiceInfo(serviceVO);
                List<OperationVO> opInfos = serviceVO.getOpInfos();
                for (OperationVO opInfo : opInfos) {                    
                    psDAO.insertOpertationInfo(opInfo);
                    opInfo.getMsgListReq();
                    opInfo.getMsgListRsp();
                }
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static List<MSGSpecificationVO> createMSGRspList(XWPFDocument document,int i) {
        return createMSGList(document,"rsp", i);
    }
    
    private static List<MSGSpecificationVO> createMSGReqList(XWPFDocument document,int i) {
        return createMSGList(document,"req", i);
    }
    
    private static List<MSGSpecificationVO> createMSGList(XWPFDocument document,String MSG_GB,int i) {
        XWPFTable table = null;
        table = document.getTables().get(i);
        MSGSpecificationVO sv = new MSGSpecificationVO();
        List<XWPFTableRow> rows = table.getRows();
        XWPFTableRow row = null;
        List<MSGSpecificationVO> msgList = new ArrayList<MSGSpecificationVO>();
        for (int j = 1; j < rows.size(); j++) {
            row = rows.get(j);
            List<XWPFTableCell> cells = row.getTableCells();
            MSGSpecificationVO msgVO = new MSGSpecificationVO();
            msgVO.setMSG_GB(MSG_GB);
            if(!cells.isEmpty()){
                String cont = cells.get(0).getText();
                msgVO.setITEM_NM_EN(cont);
                cont = cells.get(1).getText();
                msgVO.setITEM_NM_KR(cont);
                cont = cells.get(2).getText();
                msgVO.setITEM_SIZE(cont);
                cont = cells.get(3).getText();
                msgVO.setITEM_GB(cont);
                cont = cells.get(4).getText();
                msgVO.setSAMPLE_DATA(cont);
                cont = cells.get(5).getText();
                msgVO.setITEM_CONT(cont);
            }
            msgList.add(msgVO);
        }
        return msgList;
    }
}
