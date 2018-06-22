package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class UserAccountPage extends TestBase {

	//Page Factory - PO
	@FindBy(xpath="//span[text()='Hello, rocky']")
	WebElement UserAccnt;
	
	//initializing Page Objects
	public UserAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean VerifyUsrAccnt() {
		  return UserAccnt.isDisplayed(); 
		 
	}
	
	
}
