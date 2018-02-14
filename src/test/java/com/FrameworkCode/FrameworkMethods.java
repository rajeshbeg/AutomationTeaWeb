package com.FrameworkCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FrameworkMethods {
	
	public static Properties prop = new Properties();
	public static String currentdir = System.getProperty("user.dir");
	public static String configpath = currentdir + "\\src\\test\\resources\\Property Files\\config.properties" ;
	
	
	public static String loadconfigfile(){
		String featurefilelocation = null;
		try {
			FileInputStream file = new FileInputStream(configpath);
			prop.load(file);
			featurefilelocation = prop.getProperty("datasheetpath");
				
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
	}
		return featurefilelocation;
	}
	
}

