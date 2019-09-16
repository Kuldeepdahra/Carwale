package carwale.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import carwale.base.TestBase;

public class SignUpPage extends TestBase {
@FindBy(id="txtnamelogin")
WebElement name;

@FindBy(id="txtemailsignup")
WebElement emailid;

@FindBy(id="txtmobilelogin")
WebElement mobile;

@FindBy(id="txtRegPasswd")
WebElement password;

@FindBy(id="txtConfPasswdlogin")
WebElement confirmpwd;

@FindBy(id="btnSignUp")
WebElement signupbtn;

public SignUpPage(){
	PageFactory.initElements(driver, this);
}

public void createNewSignUp(String sname, String semailid, String smobile, String spassword, String sconfirmpassword)
{
	name.sendKeys(sname);
	emailid.sendKeys(semailid);
	mobile.sendKeys(smobile);
	password.sendKeys(spassword);
	confirmpwd.sendKeys(sconfirmpassword);
	signupbtn.click();
}

}
