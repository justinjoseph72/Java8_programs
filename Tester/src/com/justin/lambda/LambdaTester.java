/*
 *************************************************
File name:		LambdaTester.java
Author:			Justin
Date Created:	24-Mar-2016
Purpose:		



 *************************************************
 */

package com.justin.lambda;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class LambdaTester
{
	 String	name;

	public LambdaTester(String aName)
	{
		name = aName;
	}

	public static void main(String[] args)
	{
		LambdaTester myObj = new LambdaTester("Justin");
		final String aName = " Robiin ";
		//aName = aName + " Joseph";
		MathOperation addition = (a, b) -> {
			System.out.println(aName);
			return a + b;
		};
		MathOperation substraction = (a, b) -> a - b;
		MathOperation division = (a, b) -> {
			if (b != 0)
			{
				return a / b;
			}
			else
			{
				return 0;
			}
		};

		MathOperation multiplication = (a, b) -> a * b;

		GreetingMessage englishGreeting = (name) -> System.out.println("hello " + name);
		GreetingMessage spanishGreeting = name -> System.out.println("holla " + name);
		
		System.out.println("Addition	" + myObj.operate(2, 4, addition));
		System.out.println("Substraction	" + myObj.operate(2, 4, substraction));
		System.out.println("Division	"   + myObj.operate(2, 7, division));
		
		
	}

	
	
	
	interface MathOperation
	{
		int operation(int a, int b);
	}

	interface GreetingMessage
	{
		void message(String aName);
	}
	
	private int operate(int a, int b, MathOperation aOperation)
	{
		return aOperation.operation(a, b);
	}
	
	private static String displayMessage()
	{
		return "Hello boss";
	}
	
	 public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
   DEST transferElements(
       SOURCE sourceCollection,
       Supplier<DEST> collectionFactory) {
   
       DEST result = collectionFactory.get();
       for (T t : sourceCollection) {
           result.add(t);
       }
       return result;
}
	 
	 
}
