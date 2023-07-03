package testClass;

import org.testng.annotations.Test;

import pages.HomePage;

public class HomeTest extends BaseTest {
	@Test
public void homeTest()
{
		home.clickOnSpirits();
		home.navigateToProductPage();
}

}
