/*This activity will show the usage of testng.xml to execute multiple classes.

[Optional] Create a package named suiteExample
Create a new TestNG class file named DemoOne.java in the package.
It will have two @Test methods
Create another TestNG class named DemoTwo.java in the suiteExample package.
This class will have only one @Test method
Create the testng.xml file and add both the classes to the list of classes to execute.

This will make both the tests execute one after the other.
*/

package activities;

import org.testng.annotations.Test;

public class Activity4_DemoOne {
	
	@Test
	public void testcaseOne() {
		System.out.println("This is first test case from demoOne class");
	}
	
	@Test
	public void testcaseTwo() {
		System.out.println("This is second test case from demoOne class");
	}

}
