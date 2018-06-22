package amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.SignInPage;
import amazon.qa.pages.pwdSignPage;

public class PwdSignInPageTest extends TestBase {
	
	HomePage homePage;
	pwdSignPage pwdsngpg;
	SignInPage esignin;

	public PwdSignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		pwdsngpg = new pwdSignPage();
		esignin = new SignInPage();
		homePage.helloSigninhover();
		esignin.email(prop.getProperty("email"));
	}
	
	
	@Test(priority=1)
	public void pwdTest() {
		pwdsngpg.signin(prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
