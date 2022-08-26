package com.kata.bank.classes;

import static com.kata.bank.classes.Amount.amountOf;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
	private static final String EmptyValue = "          ";
	private static final String DateFormat = "dd/MM/yyyy";
	private SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
	private Date date;
	private Amount value;

	public Operation(Amount value, Date date) {
		this.value = value;
		this.date = date;
	}

	public Amount balanceAfterOperation(Amount currentBalance) {
		return currentBalance.plus(value);
	}
	
	private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
		builder.append("| ").append(currentBalance.moneyRepresentation());
	}
	
	public void printToStream(PrintStream printer, Amount currentBalance) {
		StringBuilder builder = new StringBuilder();
		addDateTo(builder);
		addValueTo(builder);
		addCurrentBalanceTo(builder, currentBalance);
		printer.println(builder.toString());
	}
	
	private String valueToString() {
		String stringValue = " " + value.absoluteValue().moneyRepresentation();
		return String.format("%-" + 10 + "s", stringValue);
	}	

	private void addValueTo(StringBuilder builder) {
		if (value.isGreaterThan(amountOf(0))) {
			addCreditTo(builder);
		} else {
			addDebitTo(builder);
		}
	}

	private void addDebitTo(StringBuilder builder) {
		builder.append(EmptyValue).append("|").append(valueToString());
	}

	private void addCreditTo(StringBuilder builder) {
		builder.append(valueToString()).append("|").append(EmptyValue);
	}

	private void addDateTo(StringBuilder builder) {
		builder.append(sdf.format(date));
		builder.append(" |");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Operation other = (Operation) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}		
}
