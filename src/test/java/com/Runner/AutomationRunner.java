package com.Runner;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.FrameworkCode.FrameworkMethods;

public class AutomationRunner {
	public static void main(String[] args) throws  SecurityException, IllegalArgumentException, IllegalAccessException, CustomException {
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

			
//			tcObject.createTCObj(executeCases,featureFileList);
			
			
			
			TestListenerAdapter tla = new TestListenerAdapter();
			TestNG testng = new TestNG();
			testng.setTestClasses(new Class[] {com.Scenarios.Login.class });
			testng.addListener(tla);
			testng.run();


		} 			

		catch (IOException  e) {
			e.printStackTrace();
		}
	}// Main Ends
}
