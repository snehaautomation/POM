package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class SignInPage extends TestBase {

	//Page Factory - Object Repository
	
	@FindBy(id="ap_email")
	WebElement Email;
	
	@FindBy(xpath="//span[@id='continue']")
	WebElement Continuebuttn;
	
	@FindBy(id="createAccountSubmit")
	WebElement CreateAccnt;

	//initialize Page Objects
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

public pwdSignPage email(String emailid) {
	Email.sendKeys(emailid);
	Continuebuttn.click();
	return new pwdSignPage();
}

public CreateAccountPage ClickCreateAccount() {
	CreateAccnt.click();
	return new CreateAccountPage();
}

}



