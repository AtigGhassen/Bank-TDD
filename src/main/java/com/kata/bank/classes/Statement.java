package com.kata.bank.classes;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {
	private static final int List = 0;
	public static final String StatementLine = "date       | credit   | debit    | balance";
	private List<StatementItem> StatementItems = new LinkedList<StatementItem>();
	
	public void addLineContaining(Operation operation, Amount currentBalance) {
		StatementItems.add(List, new StatementItem(operation, currentBalance));
	}
	
	public void printTo(PrintStream printer) {
		printer.println(StatementLine);
		printStatementItems(printer);
	}

	private void printStatementItems(PrintStream printer) {
		for (StatementItem StatementItem : StatementItems) {
			StatementItem.printToStream(printer);
		}
	}

}
