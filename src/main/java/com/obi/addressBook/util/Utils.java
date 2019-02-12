package com.obi.addressBook.util;

import java.time.format.*;
import java.time.temporal.ChronoField;

/**
 * 
 * @author Dr obinna Onyimadu
 *
 */
public class Utils {
	
	/**
	 * 
	 * @return DateTimeFormatter
	 */
	public static DateTimeFormatter formatInputDates() {
		return new DateTimeFormatterBuilder()
				.appendPattern("dd/MM/")
				.optionalStart()
				.appendValueReduced(ChronoField.YEAR, 2, 2, 1900)
				.optionalEnd()
				.toFormatter();
	}
}
