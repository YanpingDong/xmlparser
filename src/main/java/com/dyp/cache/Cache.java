package com.dyp.cache;

import java.io.File;
import java.util.Hashtable;

import com.dyp.util.ParseXMLToObject;

public class Cache {
	 // cache�������ø�����Ҫ���������    
    private   static  Hashtable cache = new  Hashtable();   
    // lastModifyTime����ά�������ļ�������޸�ʱ�䣬�Ӷ�ȷ����ֱ�Ӵ�Cache�����ݻ�����Ҫ���½��������ļ�    
    private   static   long  lastModifyTime;  
    
    public  Object getObject(String name,String path,String parseClass,String className) {   
        // ��������ļ����޸Ĺ���ֱ�ӽ����ļ�������ֱ�Ӵ�cache��ȡ����Ӧ�Ķ���    
         if (checkModifyTime(path))  {   
           System.out.println( " get Object from file " );   
            return  getObjectFromFile(name,path,className);   
       }    
        return  getObjectFromCache(name);   
   }    
      
    // ֱ�Ӵӻ����л�ȡ��Ӧ�Ķ���    
     public  Object getObjectFromCache(String name)  {   
       System.out.println( " get Object from cache " );   
        return  cache.get(name);
     }
     
    // ���������ļ���ȡ��Ӧ�Ķ���    
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
      
    // �ж������ļ��Ƿ��޸Ĺ�    
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
