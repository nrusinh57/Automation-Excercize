package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import masterClass.BaseClass;
import pageObject.LoginPage;
import utilities.DataProviders;

public class TC004_Register extends BaseClass {

	@Test(dataProvider = "RegisterData", dataProviderClass = DataProviders.class)
	public void validatewithoutemail(String name, String email, String scenario, String exp) {
		scenario = (scenario == null ? "" : scenario)
	            .replace("\u00A0", "")  // remove non-breaking space
	            .replaceAll("[\\t\\n\\r]", "")  // tabs & hidden chars
	            .trim()
	            .toLowerCase();

		LoginPage lp = new LoginPage(driver);
		lp.setname(name);
		lp.setEmail(email);
		lp.click_signUp();
		String actualmsg = " ";
		switch (scenario.toLowerCase()) {
		case "empty_email":
			actualmsg = lp.getValidationMessage(lp.getSignupEmailField());
			break;
		case "name":
			actualmsg = lp.getValidationMessage(lp.getSignupNameField());
			break;
		case "invalid_emailformat":
			actualmsg = lp.getValidationMessage(lp.getSignupEmailField());
			break;
		case "existing_email":
			actualmsg = lp.getExistingEmailError();
			break;

		default:
			Assert.fail("Invalid scenario name in Excel: " + scenario);
			return;
		}
		Assert.assertEquals(actualmsg.trim(), exp.trim(), "Validation message mismatch for scenario: " + scenario);

	}

}
