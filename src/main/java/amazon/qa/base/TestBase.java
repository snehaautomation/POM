package amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import amazon.qa.util.TestUtil;
import amazon.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
	
		try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\sneha\\eclipse-workspace\\AmazonTestProject\\src\\main\\java\\amazon\\qa\\config\\config.properties");
		prop.load(fis);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}


}



