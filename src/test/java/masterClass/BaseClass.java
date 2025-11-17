package masterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties p; // properties File Object
	WebDriverWait wait;
	public Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws IOException {
		File src = new File(".//src//test//resources//config.properties");
		FileInputStream file = new FileInputStream(src);
		p = new Properties();
		p.load(file);
		logger= LogManager.getLogger(this.getClass());
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Broser");

		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String alphabetic() {
		String alphabeticvalue=RandomStringUtils.randomAlphabetic(5);
		return alphabeticvalue;
		
	}
	public String numric() {
		String alphanumricvalue=RandomStringUtils.randomNumeric(10);
		return alphanumricvalue;
		
	}
	public String alphanumric() {
		String alphabeticvalue=RandomStringUtils.randomAlphabetic(5);
		String alphanumricvalue=RandomStringUtils.randomNumeric(5);
		return alphabeticvalue+"@"+alphanumricvalue;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
