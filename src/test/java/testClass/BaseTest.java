package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;
import pages.ProductPage;
import utility.ConfigReader;

public class BaseTest {
	HomePage home;
	ProductPage product;
public static	WebDriver driver;
	@BeforeSuite
	public void initBrowser() throws IOException
	{
		 
		 ConfigReader con=new ConfigReader();
		String browsername= con.readConfig("browser");
		if(browsername.equals("chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.get( con.readConfig("testsiteurl"));
	}
	@BeforeClass
	public void createObject()
	{
	 home=new HomePage(driver);
	 product=new ProductPage(driver);
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException
	{/*
		 * Thread.sleep(10000); driver.close();
		 */
	}

}
