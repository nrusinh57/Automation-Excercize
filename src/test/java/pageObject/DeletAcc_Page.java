package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseTest.BaseTest;

public class DeletAcc_Page extends BaseTest {

	public DeletAcc_Page(WebDriver driver) {
		super(driver);

	}

	// Element
	@FindBy(xpath = "//*[text()='Your account has been permanently deleted!']")
	WebElement msg_deletAcc;
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement btn_continue;

	// Actions Methods
	public String verifyAccDelet() {
		String actual_msg = msg_deletAcc.getText();
		return actual_msg;
	}

	public void Click_Continue() {
		btn_continue.click();
	}
}
