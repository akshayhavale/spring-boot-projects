package com.example.numberformat;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class TestNumberFormatCurrency {

	public static void main(String args[]) {

		BigDecimal amount = new BigDecimal(12345.99);

		Locale locale = new Locale("en", "IN");
				
		NumberFormat numFormat = NumberFormat.getCurrencyInstance(locale);
		
		Currency currency = Currency.getInstance("INR");

		
		numFormat.setCurrency(currency);
		
		String currencyString = numFormat.format(amount);

		System.out.println(currencyString);

	}

}
