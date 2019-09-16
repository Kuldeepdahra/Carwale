package carwale.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import carwale.base.TestBase;

public class Homepage extends TestBase {

	//PageFactory-OR(Object Repository)
	@FindBy(xpath="//span[contains(text(), 'New Cars') and @class='margin-right5 top-nav-label-text']")
	WebElement newCars;
	
	@FindBy(linkText="Find New Cars")
	WebElement findNewCarsLink;
	
	@FindBy(xpath="*//ul[@id='newUsedSearchOption']/li[1]")
	WebElement newUsedSearch;
	
	@FindBy(id="newCarsList")
	WebElement searchBox;
	
	@FindBy(id="btnFindCarNew")
	WebElement searchButton;
	
	@FindBy(xpath="//span[@class='cwsprite user-login-icon']")
	WebElement userIcon;
	
	@FindBy(xpath="//button[@class='loginBtnSignUp btn btn-white btn-md text-uppercase margin-bottom15']")
	WebElement signUpBtn;

//Initialize the Page Objects
public Homepage(){
	PageFactory.initElements(driver, this);
	
}

//Actions
public String validateHomePageTitle(){
	return driver.getTitle();
}
public NewCarsPage clickOnNewCarsLink(){
	Actions act=new Actions(driver);
	act.moveToElement(newCars).perform();
	
	
	findNewCarsLink.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return new NewCarsPage();
	
}
public String validateSearchBox(){
	newUsedSearch.click();
	searchBox.sendKeys("Porsche Macan");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	searchButton.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return driver.getTitle();
}
public void clickOnSignUpPage(){
	userIcon.click();
	
	signUpBtn.click();
	
	
}
}