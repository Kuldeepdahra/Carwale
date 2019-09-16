package carwale.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import carwale.base.TestBase;
import carwale.qa.pages.Homepage;
import carwale.qa.pages.NewCarsPage;

public class HomePageTest extends TestBase {
	Homepage homepage;
	NewCarsPage newCarsPage;

	public HomePageTest(){
		super();//to initialize prop variable for reading properties which are going to be used in initialisation method 
		
		
	}
	@BeforeMethod
	public void setup(){
initialisation();
homepage=new Homepage();
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
	String title=homepage.validateHomePageTitle();
	Assert.assertEquals(title, "New Cars, Used Cars, Buy a Car, Sell Your Car - CarWale","Incorrect Page Title");
		//message will be displayed if first two values don't match.
	}
	@Test(priority=2)
	public void clickOnNewCarsLinkTest(){
		newCarsPage=homepage.clickOnNewCarsLink();		
	}
	@Test(priority=3)
	public void validateSearchBoxTest(){
String carName=homepage.validateSearchBox();
Assert.assertEquals(carName, "Porsche Macan Price in India - Images, Mileage, Colours - CarWale");
	}
	@Test(priority=4)
	public void openSignUpPage(){
		homepage.clickOnSignUpPage();
		
	}
@AfterMethod
public void tearDown(){
	driver.quit();
}
}
