package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	@FindBy(xpath="(//a[normalize-space(text())='SPIRITS'])[2]")
	private WebElement spirit;
	@FindBy(xpath="//a[text()='Single Malt']")
	private WebElement singleMalt;
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void clickOnSpirits()
	{
		spirit.click();
		
	}
	public void navigateToProductPage()
	{
		singleMalt.click();
	}
}
