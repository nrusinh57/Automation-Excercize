package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import masterClass.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import utilities.DataProviders;

public class TC003_DDTLogin extends BaseClass {
	// verify login using Xl sheet
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void ddtLoginTest(String user, String pwd, String exp) {
		logger.info("***TC003_DDTLogin Test Started");
		try {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername(user);
			lp.enterPassword(pwd);
			lp.clickLogin();
			// homepage object
			HomePage hp = new HomePage(driver);
			boolean msg_Login = hp.isdisplayLoginAs();
			// validData-->loginpass-->logut-->passTest
			// validData-->loginfail-->failTest
			// Invalid-->loginpass-->logout-->failTest
			// invalid-->loginFail-->passTest
			if (exp.equalsIgnoreCase("valid")) {
				if (msg_Login == true) {
					hp.click_Logout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				if (msg_Login == true) {
					hp.click_Logout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("***TC003_DDTLogin Test ENDED");
	}

}