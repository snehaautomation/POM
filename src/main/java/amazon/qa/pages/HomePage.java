package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(xpath="//span[text()='Hello. Sign in']")
	WebElement HelloSigninHover;

	@FindBy(linkText="Gift Cards")
	WebElement GiftCards;

	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//a[@class='nav-action-button']//span[text()='Sign in']")
	WebElement Signinbuttn;
	
	@FindBy(xpath="//span[text()='Amazon']")
	WebElement AmazonLogo;

	
	
	//initializing Page Objects
   public HomePage(){
	PageFactory.initElements(driver, this);
}
   
   
   //Actions 
  public boolean validateAmazonLogo() {
	  return AmazonLogo.isDisplayed();
  }
  
  public SignInPage helloSigninhover() {
	  Actions action = new Actions(driver);
	  action.moveToElement(HelloSigninHover).build().perform();
	  Signinbuttn.click();
	  return new SignInPage();
  }
  
  public GiftCardsPage giftcardslink() {
	  GiftCards.click();
	  return new GiftCardsPage();
  }
  
  
  
  
  
  
}