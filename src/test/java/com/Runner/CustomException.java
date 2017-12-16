package com.Runner;

import java.util.List;

@SuppressWarnings("serial")
public class CustomException  extends Exception {

	CustomException(List<List<String>> featurefilelistOFlist,List<List<String>> featureFileListOFListTestSheet,List<String> testcasename,int k ){  
		System.out.println("Error : Feature Files name DO NOT MATCH on Scenario and TC Sheets for : "+ testcasename.get(k).toString());
		System.out.println("Feature Files Names on Scenario Sheet : "+ featurefilelistOFlist.get(k));
		System.out.println("Feature Files Names on TC Sheet : " + featureFileListOFListTestSheet.get(k));
	}  

}
