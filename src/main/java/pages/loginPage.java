package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.basePage;

public class loginPage extends basePage {
	
	private WebDriver driver;
	
	
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginBtn = By.xpath("//input[@type='submit']");
	By text = By.xpath("//h2[text()='New Customer']");
	// constructor 
	
	public loginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean verifyloginbutton()
	{
		return driver.findElement(loginBtn).isDisplayed();
		
	}

	public void dologin(String Username , String Password)
	{
		driver.findElement(username).sendKeys(Username);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(loginBtn).click();
		
	}
	public String textOnLoginPage() {
		return driver.findElement(text).getText();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
