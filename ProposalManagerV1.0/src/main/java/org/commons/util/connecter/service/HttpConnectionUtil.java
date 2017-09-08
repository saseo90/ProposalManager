package org.commons.util.connecter.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.commons.util.connecter.vo.DocumentVo;
import org.commons.util.connecter.vo.TongjeonRecodVo;
/**
 * 
 * 통합전산센터 홈페이지 정보받아오는 서비스 클래스
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
public class HttpConnectionUtil implements TongjeonConnection {
    URL url = null;
    HttpURLConnection httpconn=null;
    DocumentVo docVo=null;
    String ncisUrl = "http://www.ncis.go.kr/ncia_MJS/board/dev/board/board.jsp?id=data_102&menu_num=3012";
    String nciaUrl = "http://www.ncia.go.kr/ncia_MJS/board/dev/board/board.jsp?id=data_102&menu_num=3012";
    
    String html =null;//응답결과
    String contentType=null;//응답해더
    String sdata=null;//응답서버시간
    
    public HttpConnectionUtil(){}
    @Override
    public DocumentVo connNcis() throws IOException {
        url = new URL(ncisUrl);        
        connect();        
        JsoupPaserUtil jpu = new JsoupPaserUtil();
        List<TongjeonRecodVo> resultVo = jpu.docPaser(html);        
        return docVo = new DocumentVo(contentType, sdata ,resultVo);
    }

    @Override
    public DocumentVo connNcia() throws IOException {
        url = new URL(nciaUrl);
        connect();        
        JsoupPaserUtil jpu = new JsoupPaserUtil();
        List<TongjeonRecodVo> resultVo = jpu.docPaser(html);        
        return docVo = new DocumentVo(contentType, sdata ,resultVo);
    }
    
    private void connect() throws IOException{
        httpconn = (HttpURLConnection) url.openConnection();
        httpconn.getContent();
        long d1 = httpconn.getDate();
        InputStream in = httpconn.getInputStream();
        InputStreamReader inr = new InputStreamReader(in, "UTF-8");
        BufferedReader outReader = new BufferedReader(inr);
        StringBuffer outSB = new StringBuffer();
        String read = "";
        while ((read=outReader.readLine())!=null) {
            outSB.append(read);
        }
        httpconn.disconnect();
        contentType = httpconn.getContentType();
        Date d = new Date(d1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        sdata = format.format(d);
        html = outSB.toString();
//      System.out.println(outSB);
//      System.out.println("Content Type :" + contentType);
//      System.out.println("읽어온 시간 : "+ sdata);
    }
}
