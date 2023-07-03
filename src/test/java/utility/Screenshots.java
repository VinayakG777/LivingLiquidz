package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	public static String captureScreenShot(WebDriver driver,String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		        File src=  ts.getScreenshotAs(OutputType.FILE);
	       String path=System.getProperty("user.dir")+"\\screenshots\\"+FileName+".png";
	               File des=new File(path);
	               FileHandler.copy(src, des);
	               return path;
	
	}

}
