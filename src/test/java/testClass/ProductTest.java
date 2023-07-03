package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest  extends BaseTest{
	@Test
	public  void applyFilterValidation()
	{
		

	int count=	product.applyFilter();
		Assert.assertEquals(count,1);
	}
	@Test
	public  void resetFilterValidation()
	{
		int count=	product.clickOnResetButton();
	boolean isGreater= count>1;
		Assert.assertEquals(isGreater,true);
	}

}
