package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class CreateAccountPage extends TestBase{
	
	//Page Factory -PO
	@FindBy(id="ap_customer_name")
	WebElement Name;
	
	@FindBy(id="ap_email")
	WebElement Email;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="ap_password_check")
	WebElement ReEnterpassword;
	
	@FindBy(id="continue")
	WebElement CreateAccountButton;
	
	//initializing Page Objects
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void NewAccount(String name,String emlid,String pwd) {
		Name.sendKeys(name);
		Email.sendKeys(emlid);
		password.sendKeys(pwd);
		ReEnterpassword.sendKeys(pwd);
		CreateAccountButton.click();
	}
	
	
	

}
