package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	@FindBy(xpath="//input[@id='term-5']")
	private WebElement size;
	@FindBy(xpath="//input[@id='term-362']")
	private WebElement types;
	@FindBy(xpath="//button[text()='APPLY']")
	private WebElement apply_Button;
	@FindBy(xpath="//button[text()='RESET']")
	private WebElement reset_Button;
	@FindBy(xpath="//h4[text()='AMRUT INDIAN SINGLE MALT WHISKY EXCLUSIVE EDITION']/parent::a")
	private WebElement product;
	@FindBy(xpath="//select[@id='ddlProductSortyBy']")
	private WebElement sortBy_dropdown;
	@FindBy(xpath="//div[@class='card wbr-product-card h-100 rounded-20']")
	private List<WebElement> product_count;
	 WebDriver driver;
	WebDriverWait wait;
	{
		// TODO Auto-generated constructor stub
	}
	public  ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(50));;
	}
	public int applyFilter()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",size);
		js.executeScript("arguments[0].click();",types);
		js.executeScript("arguments[0].click();",apply_Button);
	int count=	product_count.size();
		return count;
	}
	public void clickOnProduct()
	{
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
	}
	public int clickOnResetButton()
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",reset_Button);
	int count=	product_count.size();
	return count;
	}
	public void sortingOrder(String value)
	{
		Select s=new Select(sortBy_dropdown);
		s.selectByVisibleText(value);
	}
	


}
