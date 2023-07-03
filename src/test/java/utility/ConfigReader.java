package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public String  readConfig(String readValue) throws IOException  
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	FileInputStream fis=new FileInputStream(path);
	Properties prop=new Properties();
	prop.load(fis);
	String value=prop.getProperty(readValue);
	return value;
	}

}
