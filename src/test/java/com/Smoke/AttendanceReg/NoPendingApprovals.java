package com.Smoke.AttendanceReg;

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
	private static final Logger log = Logger.getLogger(Keyword.class) ;
	
	@Test
	public void toVerifyNoPendingApprovals() {
	keyword.waitElementToBePresent(Locators.dashBoardNoPendingApprls);
	keyword.waitElementToBePresent(Locators.dashBoardNoPendingApprls);
	keyword.performClick(Locators.dashBoardNoPendingApprls);
	
	
	String title = "Approval Inbox";
	
	//keyword.windowHamdleUsingTitle(title);
	keyword.waitElementToBePresent(Locators.ApprovalInboxtxt);
	  WebElement text = keyword.driver.findElement(By.xpath(Locators.ApprovalInboxtxt));
	  String actualTextOfApprovalInboxtxt = text.getText();
     
	log.info(actualTextOfApprovalInboxtxt);
	Assert.assertEquals(actualTextOfApprovalInboxtxt, "Approval Inbox" );
	keyword.takeScreenShot();
}
	
	@Test
	public void name() {
		String title = keyword.titileOfApp();
		log.info(title);
	}

}
