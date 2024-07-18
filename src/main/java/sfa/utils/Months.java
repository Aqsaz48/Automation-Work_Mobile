package sfa.utils;

import java.time.Month;
import java.util.EnumMap;

public class Months {

	public static int getMonth(Month month) {
		 EnumMap<Month, Integer> months = new EnumMap<Month, Integer>(Month.class);
	        months.put(Month.JANUARY, 1);
	        months.put(Month.FEBRUARY, 2);
	        months.put(Month.MARCH, 3);
	        months.put(Month.APRIL, 4);
	        months.put(Month.MAY, 5);
	        months.put(Month.JUNE, 6);
	        months.put(Month.JULY, 7);
	        months.put(Month.AUGUST, 8);
	        months.put(Month.SEPTEMBER, 9);
	        months.put(Month.OCTOBER, 10);
	        months.put(Month.NOVEMBER, 11);
	        months.put(Month.DECEMBER, 12);
		    return months.get(month);
	}
	public static void main(String[] args) {
		
		System.out.println("17 June 1977".replaceAll("[0-9]", "").trim().toUpperCase());
		System.out.println(getMonth(Month.valueOf("APRIL")));
	}
}
