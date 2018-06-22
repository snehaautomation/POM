package amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.CreateAccountPage;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.SignInPage;
import amazon.qa.pages.pwdSignPage;

public class EmailSignInPageTest extends TestBase {
	
	HomePage homePage;
	SignInPage esignin;
	pwdSignPage psignin;
	CreateAccountPage createaccntpg;
	
	public EmailSignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		esignin = new SignInPage();
		homePage.helloSigninhover();
	}
	
	@Test(priority=1)
	public void emailTest() {
		psignin = esignin.email(prop.getProperty("email"));
	}
	
	@Test(priority=2)
	public void createAccountPageTest() {
		createaccntpg = esignin.ClickCreateAccount();
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	

}
