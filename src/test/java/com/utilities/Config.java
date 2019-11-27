package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config 
{
	File src;
	FileInputStream fis;
	Properties prop;

	public void loadPropertyFile() throws Exception 
	{
		src = new File("./Config/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	}

	public String getProperty(String propKey) 
	{
		return prop.getProperty(propKey);
	}
}