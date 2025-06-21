package com.Smoke.AttendanceReg;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Locators.Locators;
import com.keywords.Keyword;



public class Attendance_Regularization_System extends BaseClass{
	Keyword keyword = new Keyword();
	private static final Logger log = Logger.getLogger(Keyword.class) ;

	
	@Test
public void toVerifyAttendance_Regularization_System() {
		
		keyword.waitElementToBePresent(Locators.dashBoardNoPendingApprls);
		keyword.performClick(Locators.dashBoardNoPendingApprls);

		keyword.waitElementToBePresent(Locators.AttendanceData);
		String actualTextOfAttedPage = keyword.getActualtext(Locators.AttendanceData);
		log.info(actualTextOfAttedPage);
		Assert.assertEquals(actualTextOfAttedPage, "Persona & Attendance (P&A) Adherence"," unable to Redirect on Persona & Attendance (P&A) Adherence page" );
		keyword.takeScreenShot();
		
		

}

}
