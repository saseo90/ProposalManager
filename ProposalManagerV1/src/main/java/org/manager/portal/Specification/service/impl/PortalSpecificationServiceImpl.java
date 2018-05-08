package org.manager.portal.Specification.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
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
    
    @Override
    public void insertSpecificationDOC(InputStream is) throws Exception{
//        FileInputStream fis = null;
////        String fileName = "D:\\조달청_OpenAPI활용가이드_나라장터_계약정보서비스_1.3_1.docx";
//        String fileName = "D:\\조달청_OpenAPI활용가이드_나라장터_계약정보서비스_1.3.docx";
//        File file = new File(fileName);
//        fis = new FileInputStream(file.getAbsolutePath());
        XWPFDocument document = new XWPFDocument(is);
        
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
                if(temp.contains("서비스 개요")){
                    code = 0;
                } else if (temp.contains("오퍼레이션 목록")) {//사용하지 않음
//                        code = 1;
                } else if (temp.contains("오퍼레이션 명세")) {
                    code = 2;
                } else if (temp.contentEquals("요청 메시지 명세")) {
                    code = 3;
                } else if (temp.contentEquals("응답 메시지 명세")||temp.contentEquals("응답 메시지 예제")) {//2018.04.30 문서의 소제목이 다른경우 발생함.
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
                    String beforeText = null;
                    for (XWPFTableCell cell : cells) {
                        String currentText = cell.getText();
                        if(beforeText==null){
                        }else if("서비스명(국문)".equals(beforeText)) {
                            serviceVO.setSE_NM_KR(currentText);
                        }else if("서비스명(영문)".equals(beforeText)) {
                            serviceVO.setSE_NM_EN(currentText);
                        }else if("서비스 설명".equals(beforeText)) {
                            serviceVO.setSE_CONT(currentText);
                        }else if("개발환경".equals(beforeText)) {
                            if(serviceVO.getURL_DEV()==null)serviceVO.setURL_DEV(currentText);
                        }else if("운영환경".equals(beforeText)) {
                            if(serviceVO.getURL_OP()==null)serviceVO.setURL_OP(currentText);
                        }else if("서비스 인증/권한".equals(beforeText)) {
                            serviceVO.setSECU_CE(currentText);
                        }else if("전송 레벨 암호화".equals(beforeText)) {
                            serviceVO.setSECU_TLE(currentText);
                        }else if("교환 데이터 표준".equals(beforeText)) {
                            serviceVO.setAT_IDS(currentText);
//                                System.out.println("교환 데이터 표준"+currentText);
                        }else if("인터페이스 표준".equals(beforeText)) {
                            serviceVO.setAT_IS(currentText);
//                                System.out.println("인터페이스 표준"+currentText);
                        }else if("서비스 버전".equals(beforeText)) {
                            serviceVO.setDEP_VER(currentText);
//                                System.out.println("서비스 버전"+currentText);
                        }else if("서비스 시작일".equals(beforeText)) {
                            serviceVO.setDEP_STR_DT(currentText);
//                                System.out.println("서비스 시작일"+currentText);
                        }else if("배포 일자".equals(beforeText)) {
                            serviceVO.setDEP_DEP_DT(currentText);
//                                System.out.println("배포 일자"+currentText);
                        }else if("사용 제약 사항 (비고)".contains(beforeText)) {
                            serviceVO.setCONS_CONT(currentText);
//                                System.out.println("사용 제약 사항"+currentText);
                        }
                        beforeText = currentText;
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
                if(msgListReq!=null&&msgListReq.size()>0){//2018.04.30 명세서의 소제목 이름 다를 경우, 빈 객체만 생성되는 문제발생함. size 0 보다 클 때만 결과에 추가함.
                    result.get(result.size()-1).getOpInfoLast().setMsgListReq(msgListReq);
                }
                code = -1;
            }else if(4==code){//응답 메시지 명세
                List<MSGSpecificationVO> msgListRsp = createMSGRspList(document, i);
                if(msgListRsp!=null&&msgListRsp.size()>0){//2018.04.30 명세서의 소제목 이름 다를 경우, 빈 객체만 생성되는 문제발생함. size 0 보다 클 때만 결과에 추가함.
                    result.get(result.size()-1).getOpInfoLast().setMsgListRsp(msgListRsp);
                }
                code = -1; 
            }//if
            i++;
        }//if(PARAGRAPH|table)
        }//for
        
        for (ServiceVO serviceVO : result) {
            String successCount = ""+psDAO.insertServiceInfo(serviceVO);
//                System.out.println("성공::"+successCount);
//                System.out.println("Service PK::"+serviceVO.getCOM_SE_ID());
            List<OperationVO> opInfos = serviceVO.getOpInfos();
            for (OperationVO opInfo : opInfos) {
                opInfo.setCOM_SE_ID(serviceVO.getCOM_SE_ID());
                opInfo.setSE_LV(serviceVO.getCOM_SE_ID());
//                System.out.println("COM_SE_ID::"+opInfo.getCOM_SE_ID());
//                System.out.println("SE_LV::"+opInfo.getSE_LV());
//                System.out.println("OP_ID::"+opInfo.getOP_ID());
                String successCountOP = ""+psDAO.insertOpertationInfo(opInfo);
//                System.out.println("성공::"+successCountOP);
                String operationPK=opInfo.getCOM_SE_ID();
//                System.out.println("Service PK(Operation ID)::"+operationPK);
                String successCountUp = ""+psDAO.insertOpertationInfo(operationPK);
//                System.out.println("Operation_LV_UPdate::"+successCountUp);
                List<MSGSpecificationVO> msgListReq = opInfo.getMsgListReq();
//                System.out.println(msgListReq);
                for (MSGSpecificationVO msgVO : msgListReq) {
                    msgVO.setCOM_SE_ID(operationPK);
//                        System.out.println("항목영문::"+msgVO.getITEM_NM_EN());
//                        System.out.println("항목국문::"+msgVO.getITEM_NM_KR());
//                        System.out.println("항목크기::"+msgVO.getITEM_SIZE());
//                        System.out.println("항목구분::"+msgVO.getITEM_GB());
//                        System.out.println("생플::"+msgVO.getSAMPLE_DATA());
//                        System.out.println("항목설명::"+msgVO.getITEM_CONT());
                    int successCountMSG = psDAO.insertMSGInfo(msgVO);
//                        System.out.println("성공_요청메시지::"+successCountMSG);
//                        throw new Exception();//트랜젝션 테스트 2018.04.30
                }
                List<MSGSpecificationVO> msgListRsp = opInfo.getMsgListRsp();
                for (MSGSpecificationVO msgVO : msgListRsp) {
                    msgVO.setCOM_SE_ID(operationPK);
                    int successCountMSG = psDAO.insertMSGInfo(msgVO);
//                        System.out.println("성공_응답메시지::"+successCountMSG);
                }
            }
        }
    }
    
    private  List<MSGSpecificationVO> createMSGRspList(XWPFDocument document,int i) {
        return createMSGList(document,"RSP", i);
    }
    
    private  List<MSGSpecificationVO> createMSGReqList(XWPFDocument document,int i) {
        return createMSGList(document,"RQS", i);
    }
    
    private  List<MSGSpecificationVO> createMSGList(XWPFDocument document,String MSG_GB,int i) {
        XWPFTable table = null;
        table = document.getTables().get(i);
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

    @Override
    public List<ServiceVO> selectServiceInfoALL() throws Exception {
        return psDAO.selectServiceInfoALL();
    }

    @Override
    public List<OperationVO> selectOpInfoALL(String COM_SE_ID)  throws Exception {
        return psDAO.selectOpInfoALL(COM_SE_ID);
    }

    @Override
    public List<MSGSpecificationVO> selectMSGRqsInfoALL(String COM_SE_ID) throws Exception {
        return psDAO.selectMSGRqsInfoALL(COM_SE_ID);
    }

    @Override
    public List<MSGSpecificationVO> selectMSGRspInfoALL(String COM_SE_ID) throws Exception {
        return psDAO.selectMSGRspInfoALL(COM_SE_ID);
    }

    @Override
    public void createServiceInfo(String COM_SE_ID) throws Exception {
        ServiceVO serviceVO = psDAO.selectServiceInfos(COM_SE_ID);
        if(serviceVO!=null){
            String fileName = serviceVO.getSE_NM_EN()+"COM.java";
//            System.out.println(serviceVO);
//            System.out.println(serviceVO.getOpInfos());
            StringBuffer sb = new StringBuffer();
            sb.append("package org.manager.portal.Specification.web;");
            sb.append(System.getProperty( "line.separator"));
            sb.append("import org.springframework.stereotype.Controller;");
            sb.append(System.getProperty( "line.separator"));
            sb.append("@Controller");
            sb.append(System.getProperty( "line.separator"));
            sb.append("public class PortalSpecificationController {");
            sb.append(System.getProperty( "line.separator"));
            sb.append("}");
            File f = new File("D:/temp/output.java");
            f.exists();
            f.isDirectory();
            f.isAbsolute();
            f.canExecute();
            f.canRead();
            f.isFile();
            f.canWrite();
            f.createNewFile();
            f.delete();
            f.isHidden();
            f.mkdirs();
            f.mkdir();
            f.renameTo(new File("fileName.text"));
            f.setExecutable(true);
            f.setExecutable(true, true);
            f.setReadOnly();
            f.setReadable(true);
            f.setReadable(true, true);
            f.setWritable(true);
            f.setWritable(true, true);
            f.setLastModified(new Long(1));
                
            FileUtils.writeStringToFile(f, sb.toString() , "UTF-8");
        }
    }
}
