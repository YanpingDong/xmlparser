package com.dyp.xmlparser;

import java.util.Iterator;
import java.util.List;


import com.dyp.util.ParseXMLToObject;


class myClass{
	public void cout()
	{
		System.out.println(this.getClass().getResource("/testfile.xml").getPath());
	}
}

public class App 
{
    public static void main( String[] args )
    {
    	ParseXMLToObject pxt = new  ParseXMLToObject();   
    	List list = (List)pxt.getObject( "subjects" , "/testfile.xml" , "com.dyp.model.Subject" );   
    	Iterator it = list.iterator();   
        while (it.hasNext()) {   
        	System.out.println(it.next());   
        }     
    }
}
