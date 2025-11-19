package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import masterClass.BaseClass;
import pageObject.LoginPage;

public class TC005_NegativeRegister extends BaseClass {
	LoginPage lp;
	String exist = "Email Address already exist!";


	@BeforeMethod
	public void setup() {
		lp = new LoginPage(driver);
	}

	@Test(description = "verify Registration when name filed isempty")

	public void validateEmptyName() {
		lp.setname("");
		lp.setEmail(p.getProperty("usename"));
		lp.click_signUp();
		String errormsg = lp.getValidationMessage(lp.getSignupNameField());
		Assert.assertEquals(errormsg, "Please fill out this field.");

	}

	@Test(description = "verify Register without Email id ")
	public void validateEmptyEmail() {
		lp.setname(p.getProperty("name"));
		lp.setEmail("");
		lp.click_signUp();
		String errormsg = lp.getValidationMessage(lp.getSignupEmailField());
		Assert.assertEquals(errormsg, "Please fill out this field.");

	}

	@Test(description = "verify the user is already registered")
	public void validateExstingUser() {
		lp.setname(p.getProperty("name"));
		lp.setEmail(p.getProperty("usename"));
		lp.click_signUp();
		String errormsg = lp.getExistingEmailError();
		Assert.assertEquals(errormsg, exist);

	}

	@Test(description = "verify proper email add format is placed ")
	public void validateEmailformat() {
		lp.setname(p.getProperty("name"));
		lp.setEmail(p.getProperty("invalid_emailFormat"));
		lp.click_signUp();
		String errormsg = lp.getValidationMessage(lp.getSignupEmailField());
		Assert.assertTrue(errormsg.toLowerCase().contains("please enter a part following"));

	}
}
