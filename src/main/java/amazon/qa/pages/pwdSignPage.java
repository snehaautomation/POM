package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class pwdSignPage extends TestBase {
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signInbuttn;
	
	//initializing PageObjects
	public pwdSignPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public UserAccountPage signin(String pwd) {
		password.sendKeys(pwd);
		signInbuttn.click();
		return new UserAccountPage();
	}
	
}
