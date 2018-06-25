package amazon.qa.testcases;

/*
 * 
 * author Sneha
 * 
 */

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.GiftCardsPage;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.SignInPage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	SignInPage signinpage;
	GiftCardsPage giftcardspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
	initialization();
	homePage = new HomePage();
	}
	
	
	@Test(priority=1)
	public void AmazonLogoTest() {
		boolean flag = homePage.validateAmazonLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void SigninTest() {
		signinpage = homePage.helloSigninhover();	
	}
	
	@Test(priority=3)
	public void GiftCardsTest() {
		giftcardspage = homePage.giftcardslink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
