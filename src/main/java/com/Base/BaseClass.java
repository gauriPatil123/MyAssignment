package com.Base;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.keywords.Keyword;


public class BaseClass {
	Keyword keyword = new Keyword();
	private static final Logger log = Logger.getLogger(BaseClass.class) ;
	
	
	@BeforeMethod
	public void setup() {
		keyword.launchBrowser("Edge");
		keyword.launchURL("https://ultimaworks.ltimindtree.com/home");
	
	}
	
	@AfterMethod
	public void tesrDown() {
		keyword.driver.quit();
		log.info("Browser closed");
	}
}