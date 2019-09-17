package com.test.basic;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Annotaitions {
	@Parameters({"browser","url"})
	@BeforeClass()
	public static void setUp(String browser,String url) {
		
		System.out.println("Setup "+browser+" , launching "+ url);
		
		
	}
	
	
	@Test(groups="smoke",priority=1)
	public static void run1() {
		System.out.println("Test run1");
	}
	
	
	@Test(groups="smoke",priority=2)
	public static void run2() {
		System.out.println("Test run2");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Closing browser");
	}

}
