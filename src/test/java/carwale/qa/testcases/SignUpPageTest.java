package carwale.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import carwale.base.TestBase;
import carwale.qa.pages.Homepage;
import carwale.qa.pages.SignUpPage;
import carwale.util.TestUtil;

public class SignUpPageTest extends TestBase {
	Homepage homepage;
SignUpPage signUpPage;
TestUtil testUtil;
String sheetName="details";

	public SignUpPageTest(){
		super();
		
	}
	@BeforeMethod
public void setUp(){
	initialisation();
	homepage=new Homepage();
	signUpPage=new SignUpPage();
	testUtil=new TestUtil();
	}
	@DataProvider
	public Object[][] getSignUpTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
			return data;
	}

@Test(dataProvider="getSignUpTestData")
public void validateCreateNewSignUp(String name, String email, String mobile, String password, String confirmPassword){
	homepage.clickOnSignUpPage();
	signUpPage.createNewSignUp(name, email, mobile, password, confirmPassword);
	
}
@AfterMethod
public void tearDown(){
	driver.quit();
}

}
