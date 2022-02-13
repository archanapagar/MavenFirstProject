package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtilities {
//it contain code for reading property file
	public static String readproperty(String key){
		Properties properties = new Properties();
		try{
			//System.getProperty it gives path of our project
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			properties.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return properties.getProperty(key);
	
	}
}
