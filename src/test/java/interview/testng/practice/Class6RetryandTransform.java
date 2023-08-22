package interview.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class6RetryandTransform {
	
	@Test
	public void testA() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void testB() {
		Assert.assertFalse(false);
	}
	
	@Test
	public void testC() {
		Assert.assertTrue(false);
	}
}
