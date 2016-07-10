/*
 *************************************************
File name:		TestDate.java
Author:			Justin
Date Created:	07-Apr-2016
Purpose:		



 *************************************************
 */

package com.justin.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class TestDate
{

	public static void main(String[] args)
	{

		TestDate myObj = new TestDate();
		// using local date
		// myObj.testLocalDateTime();

		// using DayOfWeek
		// myObj.testDayOfWeek();

		// myObj.testMoreLocalDate();

		// myObj.testYearMonth();

	
		myObj.testLocalTime1();

	}

	private void testLocalDateTime()
	{
		LocalDate today = LocalDate.now();
		System.out.println(today);
		// usingn local datetime
		LocalDateTime todayTime = LocalDateTime.now();
		System.out.println(todayTime);
		LocalDate today1 = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(today1);
		// immutable
		System.out.println(today);
		LocalDate dateOfBirth = LocalDate.of(1986, 6, 22);
		System.out.println(dateOfBirth.getDayOfWeek().name());
		LocalDate fourthBday = dateOfBirth.plusYears(4);
		System.out.println(fourthBday.getDayOfWeek().name());

	}

	private void testDayOfWeek()
	{
		// adding up the day to a week day
		System.out.println(DayOfWeek.MONDAY.plus(8));

		// using Text Style
		DayOfWeek myMonday = DayOfWeek.MONDAY;
		Locale locale = Locale.getDefault();
		System.out.println(locale.getCountry() + " " + locale.getDisplayName());
		System.out.println(myMonday.getDisplayName(TextStyle.FULL, locale));
		System.out.println(myMonday.getDisplayName(TextStyle.FULL_STANDALONE, locale));
		System.out.println(myMonday.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(myMonday.getDisplayName(TextStyle.SHORT, locale));
	}

	private void testMoreLocalDate()
	{
		LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
		DayOfWeek dayOfDate = date.getDayOfWeek();
		System.out.println(dayOfDate);
		LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.println(nextWed);
		System.out.printf("For the date of  %s, the next Wedneday is %s.%n", date, nextWed);
		System.out.print("test");
	}

	private void testYearMonth()
	{
		YearMonth date = YearMonth.now();
		System.out.printf(" Today's date is %s. The month %s has %d days. The year %s has %d days.", date, date.getMonth(),
			date.lengthOfMonth(), date.getYear(), date.lengthOfYear());
	}

	private void testLocalTime()
	{
		LocalTime thisSec;
		// infinte loop
		for (;;)
		{
			thisSec = LocalTime.now();

			// implementation of display code is left to the reader
			System.out.printf("The hour is %d : min is %d : seconds is %d.%n", thisSec.getHour(), thisSec.getMinute(),
				thisSec.getSecond());
		}
	}
	
	private void testLocalTime1()
	{
		LocalTime thisSec = LocalTime.of(12, 50, 3);
		LocalTime newSec = LocalTime.of(2, 0, 50);
		Duration myDuration =Duration.between(thisSec, newSec);
		Temporal adjustedTime = thisSec.adjustInto(newSec);
		System.out.println(adjustedTime);
	}
}
