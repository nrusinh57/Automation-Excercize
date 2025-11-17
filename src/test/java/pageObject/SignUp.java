package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.BaseTest;

public class SignUp extends BaseTest {
	
	public SignUp(WebDriver driver) {
		super(driver);

	}
	// Locators

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement radio_mr;

	@FindBy(xpath = "//input[@id='name']")
	WebElement txt_name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement txt_email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement txt_Firstname;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement txt_lastname;
	@FindBy(xpath = "//input[@id='company']")
	WebElement txt_commpany;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement txt_add1;
	@FindBy(xpath = "//input[@id='address2']")
	WebElement txt_add2;
	@FindBy(xpath = "//input[@id='state']")
	WebElement txt_state;
	@FindBy(xpath = "//input[@id='city']")
	WebElement txt_city;
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement txt_zipCode;
	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement txt_Mobile;

	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	WebElement btn_createAcc;
	// dropdown WebElement
	@FindBy(css = "select[id='days']")
	WebElement day_drop;
	@FindBy(id = "months")
	WebElement month_drop;
	@FindBy(id = "years")
	WebElement year_drop;
	@FindBy(id = "country")
	WebElement country_drop;
	// Acc created Sussucfull
	@FindBy(xpath = "//*[text()='Congratulations! Your new account has been successfully created!']")
	WebElement acccreationmsg;
	// continue btn
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement btn_continue;

	// Actions Methods
	public void setRadio() {
		radio_mr.click();
	}

	public void setname(String name) {
		txt_name.clear();
		txt_name.sendKeys(name);

	}

	public boolean isEmailFieldEnabled() {
		boolean emailEnabled = txt_email.isEnabled();
		return emailEnabled;
	}

	public void setpassword(String pwd) {
		txt_password.sendKeys(pwd);
	}

	public void dob_dropdown(String day, String month, String year) {
		Select sel_day = new Select(day_drop);
		sel_day.selectByVisibleText(day);
		Select sel_month = new Select(month_drop);
		sel_month.selectByVisibleText(month);
		Select sel_year = new Select(year_drop);
		sel_year.selectByVisibleText(year);
	}

	public void setFirstName(String fname) {
		txt_Firstname.sendKeys(fname);
	}

	public void setlastName(String lname) {
		txt_lastname.sendKeys(lname);
	}

	public void setcomapny(String company) {
		txt_commpany.sendKeys(company);
	}

	public void setAdd1(String add1) {
		txt_add1.sendKeys(add1);
	}

	public void setAdd2(String add2) {
		txt_add2.sendKeys(add2);
	}

	public void setstate(String state) {
		txt_state.sendKeys(state);
	}

	public void setCity(String city) {
		txt_city.sendKeys(city);
	}

	public void setZipCode(String zip) {
		txt_zipCode.sendKeys(zip);
	}

	public void setMobile(String mobile) {
		txt_Mobile.sendKeys(mobile);
	}

	public void countryDrop(String country) {
		Select sel_country = new Select(country_drop);
		sel_country.selectByVisibleText(country);
	}

	public void clickCREATacc() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_createAcc));
		btn_createAcc.click();
	}

	public boolean AccCreated() {
		wait.until(ExpectedConditions.visibilityOf(acccreationmsg));
		boolean verifymsg = acccreationmsg.isDisplayed();
		return verifymsg;
	}

	public void click_contione() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btn_continue));
		btn_continue.click();
	}

}