package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import masterClass.BaseClass;
import pageObject.DeletAcc_Page;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.SignUp;

public class TC001_SignUp extends BaseClass {
	String fname= alphabetic();

	@Test
	public void verifyLandingpage() {
		logger.info("**** verifyLandingpage Test is Started ****");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");
		System.out.println("page Title is :-" + driver.getTitle());
		logger.info("**** verifyLandingpage Test is Ended ****");
	}

	@Test(priority=1)
	public void signUp() {
		logger.info("**** signUp Test is Started ****");
		LoginPage lp = new LoginPage(driver);
		lp.setname(fname);
		lp.setEmail(alphabetic()+"@gmail.com");
		lp.click_signUp();
		SignUp sign = new SignUp(driver);
		sign.setRadio();
		sign.setname(fname);
		Assert.assertFalse(sign.isEmailFieldEnabled());
		logger.info("EmailField IS Not Enabled");
		sign.setpassword(alphanumric());
		sign.dob_dropdown("20", "August", "1992");
		sign.setFirstName(fname);
		sign.setlastName(alphabetic());
		sign.setcomapny(alphabetic());
		sign.setAdd1(alphabetic());
		sign.setAdd2(alphabetic());
		sign.countryDrop("India");
		sign.setstate("Maharastra");
		sign.setCity("solapur");
		sign.setZipCode("413255");
		sign.setMobile(numric());
		sign.clickCREATacc();
		Assert.assertTrue(sign.AccCreated(),"Account is Not Created");
		logger.info("Account is created Sucesfully");
		sign.click_contione();
		logger.info("**** signUp Test is Ended ****");
	}
@Test(priority=2)
	public void verifyUserName() {    
	logger.info("**** verifyUserName Test is Started ****");
		// HomePage Object
	HomePage hp = new HomePage(driver);
	Assert.assertEquals(fname, hp.verifyUsername());// verify username Display same as GIven NAme
	logger.info("Login user is same as Registerrd User");
	logger.info("**** verifyUserName Test is Ended ****");

	}
@Test(priority=3)
public void deletAcc() {
	logger.info("**** deletAcc Test is Started ****");

	//object of homePage
	HomePage hp= new HomePage(driver);
	hp.deletAcc();
	//object of deletpage 
	DeletAcc_Page dp=new DeletAcc_Page(driver);
	Assert.assertEquals("Your account has been permanently deleted!",dp.verifyAccDelet());
	logger.info("Account is Deleted");
	dp.Click_Continue();
	logger.info("**** deletAcc Test is Ended ****");

}

}