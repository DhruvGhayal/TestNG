package interview.testng.practice;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import interview.testng.excelReader.xls;

public class Class3DataProvider {

	ChromeDriver driver;
	/* 1.India TajMahal
	 * 2.Egypt Pyramids
	 * 3.China Great Wall
	 * 4.Turkey Temple of Artemis 
	 */
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
	@DataProvider(name = "searchDataProvider")
	public  Object [][] searchData(){
		Object [][]data= new Object[4][2];
		data[0][0] = "India";
		data[0][1] = "TajMahal";
		data[1][0] = "Egypt";
		data[1][1] = "Pyramids";
		data[2][0] = "China";
		data[2][1] ="Great Wall";
		data[3][0]=  "Turkey";
		data[3][1] = "Temple of Artemis";
		return data;	
	}

	@Test(dataProvider = "searchDataProvider")
	public void fromHardCoreValues(String keyWord1, String keyWord2) {
	driver.findElement(By.name("q")).sendKeys(keyWord1+" "+keyWord2+Keys.ENTER);
	}
	
	@Test(dataProvider = "empdataprovider", dataProviderClass=xls.class)
	public void fromExcelFile(String keyWord1, String keyWord2) {
	driver.findElement(By.name("q")).sendKeys(keyWord1+" "+keyWord2+Keys.ENTER);
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
