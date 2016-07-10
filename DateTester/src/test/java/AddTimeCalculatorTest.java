package test.java;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.justin.date.AddTimeCalculator;

/*
 *************************************************
File name:		AddTimeCalculatorTest.java
Author:			Justin
Date Created:	29 Jun 2016
Purpose:		



 *************************************************
 */

public class AddTimeCalculatorTest
{
	private String timea;
	private String timeb;
	
	@Before
	public void init()
	{
			timea = "12:50:03";
			timeb = "2:00:50";
	}

	@Test
	public void test1()
	{
		AddTimeCalculator addTimeCalculator = new AddTimeCalculator();
		String myReturn = addTimeCalculator.sum(timea, timeb);
		Assert.assertNotNull(myReturn);
	}
	
	@Test
	public void test2()
	{
		AddTimeCalculator addTimeCalculator = new AddTimeCalculator();
		String myReturn = addTimeCalculator.sum(timea, timeb);
		Assert.assertNotNull(myReturn);
	}
	
}
