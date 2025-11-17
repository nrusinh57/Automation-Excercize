package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseTest.BaseTest;

public class HomePage extends BaseTest {
//Constructor
	public HomePage(WebDriver driver) {
		super(driver);

	}

	// WebElement
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li//a//b")
	WebElement login_Usernametxt;

	@FindBy(css = "a[href='/delete_account']")
	WebElement link_deletAcc;
	@FindBy(css = "a[href='/logout']")
	WebElement link_Logout;
	@FindBy(xpath = "//ul[@class='nav navbar-nav'] //*[text()=' Logged in as ']")
	WebElement msg_Loginas;

	// Action Methods
	public String verifyUsername() {
		String act_username = login_Usernametxt.getText();
		return act_username;
	}

	public void deletAcc() {
		link_deletAcc.click();
	}

	public void click_Logout() {
		link_Logout.click();
	}

	public boolean isdisplayLoginAs() {
		try {
			return (msg_Loginas.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}
}