package amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.qa.base.TestBase;
import amazon.qa.pages.CreateAccountPage;
import amazon.qa.pages.HomePage;
import amazon.qa.pages.SignInPage;
import amazon.qa.util.TestUtil;

public class CreateAccountPageTest extends TestBase {
	
	HomePage homePage;
	SignInPage esignin;
	CreateAccountPage crtaccpg;
	String sheetName = "AccountData";
	
	
	public CreateAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		esignin = new SignInPage();
		homePage.helloSigninhover();
		esignin.ClickCreateAccount();
    }

	@Test(dataProvider="getAmazonTestData")
	public void CreateAccTest(String name, String email, String password) {
		crtaccpg = new CreateAccountPage();
		crtaccpg.NewAccount(name, email, password);
	}
	
	
	@DataProvider
    public Object[][] getAmazonTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
    @AfterMethod
    public void teardown() throws InterruptedException {
	Thread.sleep(2000);
	driver.quit();
}


}