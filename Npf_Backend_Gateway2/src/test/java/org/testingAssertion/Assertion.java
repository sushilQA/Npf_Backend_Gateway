package org.testingAssertion;

public class Assertion {
	
	public static Boolean assertContains(String actual, String expected)
	{
		if(actual.contains(expected))
		{
			System.out.println("Assertion is passed !");
			return true;
		}
		else
		System.out.println("Assertion is failed !");
		return false;
	}
	
	public static Boolean assertEqualsIgnoreCase(String actual, String expected)
	{
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("Assertion is passed !");
			return true;
		}
		else
		System.out.println("Assertion is failed !");
		return false;
	}

}
