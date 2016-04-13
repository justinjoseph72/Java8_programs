/*
 *************************************************
File name:		BiConsumerTest.java
Author:			Justin
Date Created:	24-Mar-2016
Purpose:		



 *************************************************
 */

package com.justin.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerTest
{

	public static void main(String[] args)
	{
		BiConsumer<String, String> myBiConsumer = (x, y) -> {
			System.out.println(" The parameter are " + x + " and " + y);
		};
		myBiConsumer.accept("Justin", "Saumya");

		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(new Integer(0), "Justin");
		myMap.put(new Integer(1), "Saumya");
		myMap.put(new Integer(2), "Robin");

		BiConsumer<Integer, String> myMapBiCon = (key, value) -> {
			System.out.println("The key is " + key + "and the value is " + value);
		};
		myMap.forEach(myMapBiCon);
	}

}
