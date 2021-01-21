package com.facebook.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	
	public ReadConfig()  {
		File src = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	public String getAplicationUrl() {
		String url = prop.getProperty("Url");
		return url;
	}

	public String getChromedriverPath() {
		String chropath = prop.getProperty("chromedriverpath");
		return chropath;
	}
	
	public String getfirfoxdriverpath() {
		String firefoxpath = prop.getProperty("firfoxdriverpath");
		return firefoxpath;
	}
	
	public String getIedriverPath() {
		String iepath = prop.getProperty("IedriverPath");
		return iepath;
	}
	
	public String getPageTitle() {
		String pageTitle = prop.getProperty("pageTitle");
		return pageTitle;
	}
}
