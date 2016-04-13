/*
 *************************************************
File name:		BiFunctionTest.java
Author:			Justin
Date Created:	24-Mar-2016
Purpose:		



 *************************************************
 */

package com.justin.functional;

import java.util.function.BiFunction;

public class BiFunctionTest
{

	public static void main(String[] args)
	{
		BiFunction<Integer, Integer, String> myBiFunction = (num1, num2) -> {
			String myReturn = null;
			if (num1 > num2)
			{
				myReturn = num1 + "greater than " + num2;
			}
			else if (num2 > num1)
			{
				myReturn = num2 + "greater than " + num1;
			}
			else
			{
				myReturn = "both are equal";
			}
			return myReturn;
		};

		System.out.println(myBiFunction.apply(1, 2));
		System.out.println(myBiFunction.apply(5, 3));
		System.out.println(myBiFunction.apply(2, 2));
	}
}
