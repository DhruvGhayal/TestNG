package interview.testng.practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Class5Assertion {
	
	@Test(priority = 4)
	public void logoTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hindimoviestv.com/");
		WebElement logo = driver.findElement(By.id("logo"));
		Assert.assertTrue(logo.isDisplayed(), "Logo is Displayed");
	}
	
	@Test (priority = 3)
	public void falseLogoTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hindimoviestv.com/");
		WebElement logo = driver.findElement(By.id("logo"));
		Assert.assertFalse(logo.isDisplayed(), "Logo is Displayed");
	}

	@Test(priority = 2)
	public void equalTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hindimoviestv.com/");
		String expectedTitle = "Watch Hindi Movies Online Free in HD Quality - HindiMoviesTV.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 1)
	public void equalSoftTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hindimoviestv.com/");
		String expectedTitle = "HindiMoviesTV.com";
		String actualTitle = driver.getTitle();
		SoftAssert sA = new SoftAssert(); 
		sA.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 5)
	public void equalSoftAllTest() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.hindimoviestv.com/");
		String expectedTitle = "HindiMoviesTV.com";
		String actualTitle = driver.getTitle();
		SoftAssert sA = new SoftAssert(); 
		sA.assertEquals(actualTitle, expectedTitle);
		sA.assertAll();
	}
	
}
