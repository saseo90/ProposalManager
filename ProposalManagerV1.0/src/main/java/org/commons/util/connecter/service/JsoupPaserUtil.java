package org.commons.util.connecter.service;

import java.util.ArrayList;
import java.util.List;

import org.commons.util.connecter.vo.TongjeonRecodVo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * 
 * @author LEESH
 *
 */
public class JsoupPaserUtil {
    public JsoupPaserUtil(){}
    public List<TongjeonRecodVo> docPaser(String html){
        List<TongjeonRecodVo> resultVo = null;
        String recodeNum = null;
        String recodeTitle= null;
        String recodeWriter = null;
        String recodeDate = null;
        String recodeReadCount = null;
        
        Document doc = Jsoup.parse(html);
        Elements link =  doc.select("ul.board_list");

        for (Element el : link) {
            resultVo = new ArrayList<TongjeonRecodVo>();
            List<Node> colNodes = el.childNodes();
            for (Node colNode : colNodes) {
                if(colNode.attr("class").equals("li01")){
                  //게시글 번호
                  recodeNum = colNode.childNode(0).toString();
                }else if(colNode.attr("class").equals("li02")){
                    //게시글 제목
                  recodeTitle = colNode.childNode(0).childNode(0).attr("title").toString();
                }else if(colNode.attr("class").equals("li03")){
                  //게시글 작성자
                  recodeWriter = colNode.childNode(0).toString();
                }else if(colNode.attr("class").equals("li04")){
                  //게시글 작성일
                  recodeDate = colNode.childNode(0).childNode(0).toString();
                }else if(colNode.attr("class").equals("li06")){
                  //게시글 조회수
                  recodeReadCount = colNode.childNode(0).toString();
                }//if
            }//for
            TongjeonRecodVo trVo = new TongjeonRecodVo(recodeNum, recodeTitle, recodeWriter, recodeDate, recodeReadCount);
            resultVo.add(trVo);
        }
        //System.out.println(resultVo.toString());
        return resultVo;
    }//docPaser
}
