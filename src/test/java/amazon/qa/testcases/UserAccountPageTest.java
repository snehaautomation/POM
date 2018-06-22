package amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.SignInPage;
import amazon.qa.pages.UserAccountPage;
import amazon.qa.pages.pwdSignPage;

public class UserAccountPageTest extends TestBase {
	
	HomePage homePage;
	pwdSignPage pwdsngpg;
	SignInPage esignin;
	pwdSignPage psignin;
	UserAccountPage usraccpg;

	public UserAccountPageTest() {
		super();	
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		pwdsngpg = new pwdSignPage();
		esignin = new SignInPage();
		psignin = new pwdSignPage();
		homePage.helloSigninhover();
		esignin.email(prop.getProperty("email"));
		pwdsngpg.signin(prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void UserAccntTest() {
		usraccpg = new UserAccountPage();
		Assert.assertTrue(usraccpg.VerifyUsrAccnt(),"User account verification failed");
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
