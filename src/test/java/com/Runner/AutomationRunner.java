package com.Runner;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.text.Element;

import com.FrameworkCode.FrameworkMethods;

public class AutomationRunner {
	public static void main(String[] args) throws  SecurityException, IllegalArgumentException, IllegalAccessException, CustomException, ClassNotFoundException {
		try {
			String filepath = FrameworkMethods.loadconfigfile(); //gets datasheet path from property file
			File file = new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			ExcelReader ex = new ExcelReader();
			TC tcObject = new TC();
			
			List<String> testCaseListToExecute = ex.executableTestCase(workbook);
//			ex.findMissingExecutableScenario();       // Checks if the scenario file and sheets file feature match
//			String testCaseToExecute = "TC1";
			List<Row> executeCases = ex.getExecutionIterationRows(workbook, testCaseListToExecute.get(0));  // Saves the test case name and execute flag 'Y' count (for each executable case) in a hash map for each TC sheet
			List<List<String>> featureFileList = ex.executableFeatureFileList(workbook);   // List of all the executable test scenarios with each executable feature file 
            // get the data whic we have to excute 
			List<Integer> rowToexecute = ex.getRowcounttoExecute(workbook);
//			tcObject.createTCObj(executeCases,featureFileList);
            
//			   for(List<String> x : featureFileList ){
//				   for(String y : x ){
//				   System.out.println(y);				  
			for(List<String> x : featureFileList ){
				for(String currentFeatureFile : x ){
				System.out.println(currentFeatureFile);
				for(Integer YFlagRow : rowToexecute)
				{
				HashMap<String,String> dataMap = ex.getDatamap(workbook,testCaseListToExecute.get(0),currentFeatureFile,YFlagRow); 
		    Set keys = dataMap.keySet();
			    Iterator itr = keys.iterator();
			    
		    String userName;
			    String value;
			    
			    while (itr.hasNext())
			    {
			    	userName= (String)itr.next();
			    	value=(String)dataMap.get(userName);
			    	System.out.println(userName+ " - " + value);
			    }
				for ( String datatoinsert : dataMap.keySet() )
		        {
		            System.out.println( dataMap.get( datatoinsert ) );
		        }
				
				}
					
				   
				   String clasname = "com.Scenarios."+currentFeatureFile;
					Class c2 = Class.forName(clasname);
				   
			TestListenerAdapter tla = new TestListenerAdapter();
			TestNG testng = new TestNG();
		//	testng.setTestClasses(new Class[] {com.Scenarios.Login.class });
			
			testng.setTestClasses(new Class[] {c2});
			testng.addListener(tla);
			testng.run();

				   }
			   }
			} 			

		catch (IOException  e) {
			e.printStackTrace();
		}
	}// Main Ends
}
