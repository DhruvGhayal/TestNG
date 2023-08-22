package interview.testng.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Class2Parameter {
	
	@Test
	@Parameters({"i","j"})
	public void test5(int a, int b) {
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
	}
	
	@Test
	@Parameters({"AutoMobile"})
	public void test6(String vehicle) {
		System.out.println(vehicle);
		System.out.println(vehicle.toUpperCase());
	}
}
