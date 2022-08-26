package com.kata.bank.Initializer;

import java.util.Date;

public class DateInitializer {
	
	public static Date date(String dateString) {
		DateConverter dateConverter = new DateConverter();
		Date date = (Date) dateConverter.convertValue(dateString, Date.class);
		return date;		
	}

    protected Class<?> getDefaultType() {
        return Date.class;
    }
}
