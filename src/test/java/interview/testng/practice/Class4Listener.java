package interview.testng.practice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(interview.testng.practice.TestListener.class)
public class Class4Listener  {

	@Test(priority  = 1)
	public void loginAndVerify() throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority  = 2)
	public void failTest() {
		Assert.assertTrue(false, "Test Case Supposed to be Failed");
	}
	
	@Test(priority  = 3)
	public void failSkip() {
		throw new SkipException("skip exception thrown");
	}
}
