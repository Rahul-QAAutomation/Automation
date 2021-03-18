package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage {
	
	public WebDriver driver;
	Properties prop ;
	
	public WebDriver initbrowser (String Browser) throws InterruptedException
	{
		
		System.out.println(Browser);
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else 
		{
			System.out.println("Not a Valid Browser ");
		}
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		Thread.sleep(10000);
		
		return driver; 
		
		
	}
	/**
	 * @author Rahul
	 * @returnProperties 
	 */
public Properties initProps()
{
	prop = new Properties();
	try {
		FileInputStream ip = new FileInputStream("src\\main\\java\\qa\\ConfigProperties\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
	
}
}
