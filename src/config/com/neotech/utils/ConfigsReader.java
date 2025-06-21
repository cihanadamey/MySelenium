 package com.neotech.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigsReader {
	
	private static Properties prop;
	
	public static void readProperties(String filePath) {
		FileInputStream fis;
		try {
			fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
