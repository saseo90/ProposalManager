package egovframework.rte.fdl.scheduling.sample;

public class SayHelloService {
    
    private String name;
 
    public void setName (String name) {
        this.name = name;   
    }
 
    public void sayHello () {
        System.out.println("HelloService, " + this.name);
    }
}