package carwale.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import carwale.base.TestBase;
import carwale.qa.pages.Homepage;
import carwale.qa.pages.NewCarsPage;

public class NewCarsPageTest extends TestBase{
	Homepage homepage;
	NewCarsPage newCarsPage;
	
	
	public NewCarsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
	initialisation();
	homepage=new Homepage();
	newCarsPage=homepage.clickOnNewCarsLink();
	}
	
	@Test
	public void verifyNewCarsHeadingTest(){
	
	Assert.assertTrue(newCarsPage.verifyNewCarsHeading());
	
	}

	@AfterMethod
	public void tearDown()
	{
	
		driver.quit();
	}

	}
