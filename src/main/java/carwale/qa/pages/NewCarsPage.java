package carwale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import carwale.base.TestBase;

public class NewCarsPage extends TestBase{
	

	@FindBy(xpath="//h1[contains(text(), 'New cars')]")
	WebElement heading;
	
	public NewCarsPage() {
		PageFactory.initElements(driver, this);
	}
public boolean verifyNewCarsHeading(){
	
	return heading.isDisplayed();
	
	
}
}