package org.commons.util.connecter.vo;

/**
 * 통합전산센터 클로킹 한 레코드 View Object 클래스
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
public class TongjeonRecodVo {
    /** 작설글 번호 */
    String recodeNum = null;// 작설글 번호
    /** 작성글 제목 */
    String recodeTitle = null;// 작성글 제목
    /** 작성글 작성자 */
    String recodeWriter = null;// 작성들 작성자
    /** 작성글 작성일 */
    String recodeDate = null;// 작성들 작성일
    /** 작성글 조회수 */
    String recodeReadCount = null;// 작성글 조회수

    public TongjeonRecodVo(String recodeNum, String recodeTitle, String recodeWriter, String recodeDate, String recodeReadCount) {
        super();
        this.recodeNum = recodeNum;
        this.recodeTitle = recodeTitle;
        this.recodeWriter = recodeWriter;
        this.recodeDate = recodeDate;
        this.recodeReadCount = recodeReadCount;
    }
    public String getRecodeNum() {
        return recodeNum;
    }
    public void setRecodeNum(String recodeNum) {
        this.recodeNum = recodeNum;
    }
    public String getRecodeTitle() {
        return recodeTitle;
    }
    public void setRecodeTitle(String recodeTitle) {
        this.recodeTitle = recodeTitle;
    }
    public String getRecodeWriter() {
        return recodeWriter;
    }
    public void setRecodeWriter(String recodeWriter) {
        this.recodeWriter = recodeWriter;
    }
    public String getRecodeDate() {
        return recodeDate;
    }
    public void setRecodeDate(String recodeDate) {
        this.recodeDate = recodeDate;
    }
    public String getRecodeReadCount() {
        return recodeReadCount;
    }
    public void setRecodeReadCount(String recodeReadCount) {
        this.recodeReadCount = recodeReadCount;
    }
    @Override
    public String toString() {
        return "[recodeNum=" + recodeNum + ", recodeTitle="
                + recodeTitle + ", recodeWriter=" + recodeWriter
                + ", recodeDate=" + recodeDate + ", recodeReadCount="
                + recodeReadCount + "]";
    }
}
