package org.proposal.manager.monitor.service;

import java.util.Map;

/**
 * 모니터링 페이지 처리를 위한 서비스 인터페이스
 * OS 정보, CPU, MEM, DISK 사용량
 * 
 * @author 이성현
 * @since 2017.06.26
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일             수정자       수정내용
 *  ------------ ------ ----------------------------
 *   2017.06.26   이성현      최초 생성
 *  
 * </pre>
 */
public interface MonitorService {

    /** OS 정보 */
    public Map<String,Object> monitorOsInfo() throws Exception;
    /** CPU 정보 */
    public Map<String,Object> monitorCpu() throws Exception;
    /** MEM 정보 */
    public Map<String,Object> monitorMem() throws Exception;
    /** DISK 정보 */
    public Map<String,Object> monitorDisk() throws Exception;
}
