package com.Runner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

public class TC {

	String caseName ;
	String scenario;
	HashMap<String,String> fieldValueMap = new HashMap<String,String>(); 
	List<String> scenarioList;

	public void createTCObj(HashMap<String, Row> executeCases,List<List<String>> featureFileList) {
		Iterator it1 = executeCases.entrySet().iterator(); 
		Iterator<List<String>> it2 = featureFileList.iterator();
//		while (Typekey tcName : executeCases.keySet()  && it2.hasNext()) {
		for (String tcName : executeCases.keySet()) {
//		   this.caseName = it1.next();
//		   this.scenarioList = it2.next();
		   System.out.println(executeCases.size());
		   System.out.println(tcName);
		}	
	}
}
