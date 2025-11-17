package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import baseTest.BaseTest;

public class LoginPage extends BaseTest {
//constructor
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// WebElement
	@FindBy(xpath = "//input[@name='name']")
	WebElement txt_username;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement txt_emailID;
	@FindBy(xpath = "//button[normalize-space()='Signup']")
	WebElement btn_submit;
	// login Requird Element
	@FindBy(css = "input[data-qa='login-email']")
	WebElement txt_loginemail;
	@FindBy(css = "input[data-qa='login-password']")
	WebElement txt_loginpass;
	@FindBy(css = "button[data-qa='login-button']")
	WebElement btn_login;

//Actions Methods 
	public void setname(String name) {
		txt_username.sendKeys(name);
	}

	public void setEmail(String email) {
		txt_emailID.sendKeys(email);
	}

	public void click_signUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", btn_submit);

	}

	// Action Method For Login Element
	public void enterUsername(String email) {
		txt_loginemail.clear();
		txt_loginemail.sendKeys(email);
	}

	public void enterPassword(String pwd) {
		txt_loginpass.clear();
		txt_loginpass.sendKeys(pwd);
	}

	public void clickLogin() {
		btn_login.click();
	}
}
