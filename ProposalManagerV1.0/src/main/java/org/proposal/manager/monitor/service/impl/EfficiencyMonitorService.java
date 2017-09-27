package org.proposal.manager.monitor.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.proposal.manager.monitor.service.MonitorService;
import org.springframework.stereotype.Service;

import egovframework.com.utl.sim.service.EgovSysInfo;

@Service("efficiencyMonitorService")
public class EfficiencyMonitorService implements MonitorService{
    protected Logger logger = Logger.getLogger(getClass());
    
    @Override
    public Map<String,Object> monitorOsInfo() throws Exception {
        Map<String,Object> result = new HashMap<String, Object>();
        String osName = EgovSysInfo.getOSName();
        String osPrductor = EgovSysInfo.getOSPrductor();
        String osVersion = EgovSysInfo.getOSVersion();
        result.put("osName", osName);
        result.put("osPrductor", osPrductor);
        result.put("osVersion", osVersion);
        logger.error("os정보 "+result);
        return result;
    }

    @Override
    public Map<String,Object> monitorCpu() throws Exception {
        Map<String,Object> result = new HashMap<String, Object>();
        return result;
    }

    @Override
    public Map<String,Object> monitorMem() throws Exception {
        Map<String,Object> result = new HashMap<String, Object>();
        float  moryUsed = EgovSysInfo.getMoryUsedCpcty();//"메모리사용용량(MB)"
        float  moryFree = EgovSysInfo.getMoryFreeCpcty();//"메모리유효용량(MB)"
        float  moryFull = EgovSysInfo.getMoryFullCpcty();//"메모리전체용량(MB)"
        result.put("moryUsed", moryUsed);
        result.put("moryFree", moryFree);
        result.put("moryFull", moryFull);
        return result;
    }

    @Override
    public Map<String,Object> monitorDisk() throws Exception {

        Map<String,Object> result = new HashMap<String, Object>();
        return result;
    }
}
