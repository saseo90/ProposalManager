package org.commons.util.connecter.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.commons.util.connecter.vo.DocumentVo;
import org.commons.util.connecter.vo.TongjeonRecodVo;

public class UrlConnectionUtil implements TongjeonConnection {
    URL url = null;
    URLConnection urlcon=null;
    DocumentVo docVo=null;
    String ncisUrl = "http://www.ncis.go.kr/ncia_MJS/board/dev/board/board.jsp?id=data_102&menu_num=3012";
    String nciaUrl = "http://www.ncia.go.kr/ncia_MJS/board/dev/board/board.jsp?id=data_102&menu_num=3012";
    
    String html =null;//응답결과
    String contentType=null;//응답해더
    String sdata=null;//응답서버시간
    public UrlConnectionUtil(){}
    
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
    
    private void connect() throws IOException {
        urlcon = url.openConnection();
        
        InputStream in = urlcon.getInputStream();
        InputStreamReader inr = new InputStreamReader(in, "UTF-8");
        BufferedReader outReader = new BufferedReader(inr);
        StringBuffer outSB = new StringBuffer();
        String read = "";
        while ((read=outReader.readLine())!=null) {
            outSB.append(read);
        }
        html = outSB.toString();

        contentType = urlcon.getContentType();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        long d1 = urlcon.getDate();
        Date d = new Date(d1);
        sdata = format.format(d);

        //System.out.println("Content Type :" + contentType);
        //System.out.println("읽어온 시간 : "+ sdata);
        //System.out.println("본문 : \n" + outSB);
    }
}
