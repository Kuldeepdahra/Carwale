//author Kuldeep Dahra

package carwale.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import carwale.util.TestUtil;

public class TestBase {


public static WebDriver driver;
public static Properties prop;

public TestBase(){
	
	prop=new Properties();//initializing prop variable
	try {
		FileInputStream ip=new FileInputStream("C:\\Users\\dawnbit\\workspace\\Carwale\\src\\main\\java\\carwale\\config\\config.properties");
	prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
}
public static void initialisation(){
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dawnbit\\Downloads\\selenium\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dawnbit\\Downloads\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIME, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}

}
