package com.kata.bank.classes;

import java.io.PrintStream;

public class StatementItem {
	private Amount currentBalance;
	private Operation operation;

	public StatementItem(Operation operation, Amount currentBalance) {
		this.operation = operation;
		this.currentBalance = currentBalance;
	}

	public void printToStream(PrintStream printer) {
		this.operation.printToStream(printer, currentBalance);
	}

}
