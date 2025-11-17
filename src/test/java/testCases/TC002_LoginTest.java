package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import masterClass.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;

public class TC002_LoginTest extends BaseClass {
//Positive Login Test With valid Creantials
	@Test
	public void validLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(p.getProperty("usename"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		// homepage object
		HomePage hp = new HomePage(driver);
		boolean msg_Login = hp.isdisplayLoginAs();
		Assert.assertTrue(msg_Login, "Login is Not Sucessfull");
		

	}
}
