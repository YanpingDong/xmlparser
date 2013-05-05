package com.dyp.model;

public class Subject {
	private  String port;   
    private  String servletName; 
    public  String getPort() {   
        return  port;   
   }    
    public   void  setPort(String port) {   
        this.port  =  port;   
   }    
    public  String getServletName()  {   
        return  servletName;   
   }    
    public   void  setServletName(String servletName) {   
        this.servletName  =  servletName;   
   }    
    public  Subject()  {}    
   @Override  
    public  String toString()  {     
        return  port + " , " + servletName;   
   }     
}
