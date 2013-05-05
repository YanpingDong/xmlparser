package com.dyp.xmlparser;

import java.util.Iterator;
import java.util.List;

import com.dyp.cache.Cache;

public class testCache {

	 public   static   void  main(String[] args)  {   
       
          for ( int  i = 0 ;i < 10 ;i ++ )  {   
            System.out.println( " 第 " + i + " 次获取缓存数据： " );   
            Cache cache = new  Cache();   
            List list = (List)cache.getObject( "subjects" , "/testfile.xml" ,  "com.dyp.util.ParseXMLToObject" ,  "com.dyp.model.Subject" );   
            Iterator it = list.iterator();   
              while (it.hasNext())  {   
                System.out.println(it.next());   
            }    
              try    {   
                Thread.sleep( 3000 );   
             }   catch  (InterruptedException e)   {   
                 //  TODO Auto-generated catch block    
                e.printStackTrace();   
            }    
        }    
  
    }     
}
