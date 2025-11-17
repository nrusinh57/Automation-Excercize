package baseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	// Constuctor
	 protected WebDriver driver;
    public WebDriverWait wait;


	public BaseTest(WebDriver driver) {

		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ Initialize wait

		// initialize All Element with PAgeFactory
		PageFactory.initElements(driver, this);

	}
}
