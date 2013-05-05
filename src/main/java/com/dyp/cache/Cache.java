package com.dyp.cache;

import java.io.File;
import java.util.Hashtable;

import com.dyp.util.ParseXMLToObject;

public class Cache {
	 // cache用来放置各种需要缓存的数据    
    private   static  Hashtable cache = new  Hashtable();   
    // lastModifyTime用于维护配置文件的最后修改时间，从而确定是直接从Cache读数据还是需要重新解析配置文件    
    private   static   long  lastModifyTime;  
    
    public  Object getObject(String name,String path,String parseClass,String className) {   
        // 如果配置文件被修改过则直接解析文件，否则直接从cache中取得相应的对象    
         if (checkModifyTime(path))  {   
           System.out.println( " get Object from file " );   
            return  getObjectFromFile(name,path,className);   
       }    
        return  getObjectFromCache(name);   
   }    
      
    // 直接从缓存中获取相应的对象    
     public  Object getObjectFromCache(String name)  {   
       System.out.println( " get Object from cache " );   
        return  cache.get(name);
     }
     
    // 解析配置文件获取相应的对象    
   @SuppressWarnings( " unchecked " )   
     public  Object getObjectFromFile(String name,String path,String className) {   
       String key = "key" ;   
         synchronized (key)  {   
           ParseXMLToObject pxt = new  ParseXMLToObject();   
           Object obj = pxt.getObject(name, path, className);   
           cache.put(name, obj);   
           return  obj;   
         }    
     }
      
    // 判断配置文件是否被修改过    
     public   boolean  checkModifyTime(String path) {   
       String absPath = this .getClass().getResource(path).getPath();   
        long  time = ( new  File(absPath)).lastModified();   
         if (lastModifyTime == 0L || time > lastModifyTime)  {   
           lastModifyTime = time;   
            return   true ;   
       }    
        return   false ;   
   }     
}
