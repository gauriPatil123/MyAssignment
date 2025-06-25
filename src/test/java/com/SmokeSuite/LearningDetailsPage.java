package com.SmokeSuite;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Locators.Locators;
import com.keywords.Keyword;

public class LearningDetailsPage extends BaseClass{

	
	Keyword keyword = new Keyword();
	private static final Logger log = Logger.getLogger(LearningDetailsPage.class) ;

	
	@Test
public void toVerifyAttendance_Regularization_System() {
		
		keyword.waitElementToBePresent(Locators.DashboardLearningDetails);
		keyword.performClick(Locators.DashboardLearningDetails);
		keyword.waitElementToBePresent(Locators.MyLearningAllDetails);
		String actualTextOfMyLearning = keyword.getActualtext(Locators.MyLearningAllDetails);
		log.info(actualTextOfMyLearning);
		Assert.assertEquals(actualTextOfMyLearning, "My Learning", "Not able to click on Learing Details " );
		keyword.takeScreenShot();
}
}
