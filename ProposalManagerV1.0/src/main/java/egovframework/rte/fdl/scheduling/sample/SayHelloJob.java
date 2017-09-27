package egovframework.rte.fdl.scheduling.sample;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SayHelloJob extends QuartzJobBean {
    
    private String name;
 
    public void setName (String name) {
        this.name = name;   
    }

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Hello, " + name);
    }
}