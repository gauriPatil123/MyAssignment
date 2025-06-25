package com.SmokeSuite;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Locators.Locators;
import com.keywords.Keyword;

public class NoPendingApprovals extends BaseClass{
	Keyword keyword = new Keyword();
	private static final Logger log = Logger.getLogger(NoPendingApprovals.class) ;
	
	@Test
	public void toVerifyNoPendingApprovals() {
		keyword.waitElementToBePresent(Locators.dashBoardNoPendingApprls);
		keyword.performClick(Locators.dashBoardNoPendingApprls);
		
		keyword.waitElementToBePresent(Locators.ApprovalInboxtxt);
		String actualTextOfAttedPage = keyword.getActualtext(Locators.ApprovalInboxtxt);
		log.info(actualTextOfAttedPage);
		Assert.assertEquals(actualTextOfAttedPage, "Approval Inbox" );
		keyword.takeScreenShot();
}
	
	//@Test
	public void name() {
		String title = keyword.titileOfApp();
		log.info(title);
	}

}
