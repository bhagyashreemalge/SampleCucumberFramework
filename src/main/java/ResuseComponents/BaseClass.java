package ResuseComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	WebDriver driver;
	Properties prop=new Properties();
	String URL;
	
	public  WebDriver initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public WebDriver initializeDriverWithURL() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties");
		prop.load(fis);
		URL=prop.getProperty("url");
		driver.get(URL);
		return driver;
	}


}
