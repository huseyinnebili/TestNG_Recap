package demo;

import org.testng.annotations.*;

public class TestNGAnnotations {

	@BeforeClass                             //the first
	public void beforeClass() {

		System.out.println("beforeClass method runs before any methods inside class!..");

	}

	@BeforeMethod
	public void beforeMethod() {             //the second  ,the fifth

		System.out.println("beforeMethod method runs after 'BeforeClass' but before each test methods!..");

	}

	@Test

	public void testOne() {                   //the third

		System.out.println("testOne method runs after 'BeforeClass' but before 'AfterClass' methods!.. ");
	}

	@Test

	public void testTwo() {                  //the sixth

		System.out.println("testTwo method runs after 'BeforeClass' but before 'AfterClass' method!.. ");
	}

	@AfterMethod
	public void afterMethod() {                //the fourth,the seventh

		System.out.println("afterMethod method runs after each test methods but before 'AfterClass' method!..");

	}

	@AfterClass
	public void afterClass() {                    //the eight

		System.out.println("afterClass method runs after any methods inside class!..");

	}

}
