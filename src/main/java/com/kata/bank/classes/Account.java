package com.kata.bank.classes;

import java.io.PrintStream;
import java.util.Date;
import static com.kata.bank.classes.Amount.amountOf;

public class Account {
	
	private Amount balance = amountOf(0);
	private Statement statement;

	public Account(Statement statement) {
		this.statement = statement;
	}

	public void deposit(Amount value, Date date) {
		recordOperation(value, date);
	} 

	public void withdrawal(Amount value, Date date) {
		recordOperation(value.negative(), date);
	}

	public void printStatement(PrintStream printer) {
		statement.printTo(printer);
	}

	private void recordOperation(Amount value, Date date) {
		Operation operation = new Operation(value, date);
		Amount balanceAfterOperation = operation.balanceAfterOperation(balance);
		balance = balanceAfterOperation;
		statement.addLineContaining(operation, balanceAfterOperation);
	}
	
}
