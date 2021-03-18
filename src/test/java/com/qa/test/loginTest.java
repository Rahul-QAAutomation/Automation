package com.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basePage;
import pages.loginPage;
import qa.com.Utils.Contants;

public class loginTest {
	WebDriver driver;
	loginPage login;
	basePage  base;
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
        base = new basePage();
		driver = base.initbrowser("Chrome");
		login = new loginPage(driver);
		
		
		
	}
	
	@Test
	public void verifyTitle() {
		String Title = login.getTitle();
		System.out.println("Title is  "+Title);
		Assert.assertEquals(Title, Contants.Login_Page_Title,"Login page titile not matched");
	}
		@Test
		public void verifyLoginButtonIsPresent()
		{
			Assert.assertTrue(login.verifyloginbutton(),"Not present kindly check again");	
	}
	
	@Test
	public void verifyWhetherTextIsAvailaible() {
		System.out.println("Text Present is ---"+login.textOnLoginPage());
		Assert.assertEquals(login.textOnLoginPage(), Contants.Login_Page_text,"Not matched");
	}

	@AfterTest 
	public void quitTest() {
		
		driver.quit();
	}

}
