package amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.qa.base.TestBase;

public class GiftCardsPage extends TestBase{

	@FindBy(xpath="//span[text()='Birthdays']")
	WebElement BirthdaysLink;
}
