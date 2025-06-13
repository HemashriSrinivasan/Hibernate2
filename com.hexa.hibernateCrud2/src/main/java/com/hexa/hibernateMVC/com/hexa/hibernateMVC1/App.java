package com.hexa.hibernateMVC.com.hexa.hibernateMVC1;

import org.hibernate.service.spi.ServiceRegistryAwareService;

import service.StudentService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentService service= new StudentService();
    	//service.saveStudent();
    	//service.removeByStudRoll();
   	//service.updateByRoll1();
    	//service.searchByStudRoll();
    	//service.searchByStudName();
    	//service.searchByStudNameMarks();
    	//service.ShowData1();
    	//service.greaterMarks();
    	//service.removebyRollHQL();
    	//service.updateNameByRollNo();
    	service.ShowData2();
    	
        System.out.println( "Hello World!" );
    }
}
