package com.Runner;

import java.util.ArrayList;

import com.Runner.CustomException;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	String featurefilename=null, featurefilenameTestSheet=null ;
	int testCaseYCnt = 0;
	List<String> testcasename = new ArrayList<String>() ; // List of all the executable test cases (Flag 'Y') from scenario sheet
	List<String> featurefilelistTestSheet = null ;					// List of feature files present on individual Test cases sheet
	List<List<String>> featureFileListOFListTestSheet =  new ArrayList<List<String>>()  ;// List of List of feature files present on all TC sheet with execution flag Y
	List<String> featurefilelist ;
	List<List<String>> featurefilelistOFlist = new ArrayList<List<String>>() ; //Contains all feature files and each entry contains feature file list for a TC 

	public List<String> executableTestCase(XSSFWorkbook workbook){
		XSSFSheet worksheet = workbook.getSheetAt(0);
		int testcasecount = worksheet.getLastRowNum();			// Test case count from scenario sheet
     System.out.println("Total number of testcase: "+testcasecount);
		//		int testCaseYCnt = 0;
//		List<String> testcasename = new ArrayList<String>() ;	// List of all the executable test cases (Flag 'Y') from scenario sheet
//		List<String> featurefilelist ;
//		List<List<String>> featurefilelistOFlist = new ArrayList<List<String>>() ; //Contains all feature files and each entry contains feature file list for a TC 
		Row row;
		Cell cell;
		for(int i=1;i<=testcasecount;++i){
			row = worksheet.getRow(i);
			featurefilelist = new ArrayList<String>() ;
			cell = row.getCell(0);
			if(cell==null)break;
			if((cell.toString()).equalsIgnoreCase("Y")){
				int featurefilecount;
				testcasename.add(row.getCell(1).toString()); 						
				featurefilecount = worksheet.getRow(testCaseYCnt+1).getLastCellNum(); // Feature file count in each row of scenario sheet
				for( int k=1 ; k<=featurefilecount-2;++k){
					featurefilename = worksheet.getRow(i).getCell(k+1).toString();
					if(featurefilename.equals("")){
						break;    						// If cells have been written over once they will add to the count of feature files
					}
					featurefilelist.add(featurefilename);
				}
				featurefilelistOFlist.add(featurefilelist);  // List of list of feature file with all TC having flag as Y
				++testCaseYCnt; 
			}
		}
		System.out.println("Total Executable Cases : " + testCaseYCnt);
		return testcasename;
	}

	public List<List<String>> executableFeatureFileList(XSSFWorkbook workbook){
//		List<String> featurefilelistTestSheet = null ;					// List of feature files present on individual Test cases sheet
//		List<List<String>> featureFileListOFListTestSheet =  new ArrayList<List<String>>()  ;// List of List of feature files present on all TC sheet with execution flag Y
		Sheet TestCsSht = null;
		for(int j = 1; j <= testCaseYCnt; ++j){
//			if(testcasename.get(j-1).equals(sheetNames.get(j))){
//				TestCsSht = workbook.getSheet(sheetNames.get(j));
				TestCsSht = workbook.getSheet(testcasename.get(j-1));
				featurefilelistTestSheet =  new ArrayList<String>()  ;			    // List is reset for each iteration
				int featurefilecntTstSht = TestCsSht.getRow(0).getLastCellNum();    // Feature file count in each row for particular TC sheet Ex. (TC1)
				for( int l=0 ; l<=featurefilecntTstSht-1;++l){
					featurefilenameTestSheet = TestCsSht.getRow(0).getCell(l+1).toString();
					if(featurefilenameTestSheet.equals("")){
						break;    						// If cells have been written over once they will add to the count of feature files
					}
					if(!featurefilelistTestSheet.contains(featurefilenameTestSheet)){
						featurefilelistTestSheet.add(featurefilenameTestSheet);
					}
				}
				featureFileListOFListTestSheet.add(featurefilelistTestSheet);
			}
		return featureFileListOFListTestSheet;
	}
	
	public void findMissingExecutableScenario() throws CustomException{//	Compare both the list to check if the feature files are missing (Use for Log Sheet)
		for(int k = 0 ; k <= testCaseYCnt-1; ++k){				
			if(!featurefilelistOFlist.get(k).equals(featureFileListOFListTestSheet.get(k))){
				throw new CustomException(featurefilelistOFlist, featureFileListOFListTestSheet, testcasename, k);
			}
		}
		System.out.println("No Mismatch in Feature Files name on Scenario and TC Sheets");
	}
	
	public List<Row> getExecutionIterationRows(XSSFWorkbook workbook, String testCaseNameToExecute){
		List<Row> testCaseExecuteRowObject = new ArrayList<Row>();
		Row yesRowObject = null ;
//		for (int k=0 ; k<=testcasename.size()-1;++k){
			int i,yFlagCountTC = 0;
//			int rowCountSheet = workbook.getSheet(testcasename.get(k)).getLastRowNum();
			int rowCountSheet = workbook.getSheet(testCaseNameToExecute).getLastRowNum();
			for(i=0;i<=rowCountSheet-2;++i){
//				if(workbook.getSheet(testcasename.get(k)).getRow(i+2).getCell(0).toString().equalsIgnoreCase("Y")){
				if(workbook.getSheet(testCaseNameToExecute).getRow(i+2).getCell(0).toString().equalsIgnoreCase("Y")){
					yesRowObject = workbook.getSheet(testCaseNameToExecute).getRow(i+2);
					testCaseExecuteRowObject.add(yesRowObject);
//					++yFlagCountTC;
//					System.out.println(yFlagCountTC);
				}
			}
//		}
		return testCaseExecuteRowObject;
	}
	
}
