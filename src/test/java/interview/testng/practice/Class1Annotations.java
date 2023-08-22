package interview.testng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1Annotations {
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("--------Before Class-------");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("//////////Before Method////////");
	}
	@BeforeTest
	public void beforetest() {
		System.out.println("***********Before Test**********");
	}
	@Test
	public void test1() {
		System.out.println("This is test1");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test2");
	}
	
	@Test
	public void test3() {
		System.out.println("This is test3");
	}
	
	@Test
	public void test4() {
		System.out.println("This is test4");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("--------After Class-------");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("//////////After Method////////");
	}
	@AfterTest
	public void aftertest() {
		System.out.println("**********After Test*********");
	}
}
