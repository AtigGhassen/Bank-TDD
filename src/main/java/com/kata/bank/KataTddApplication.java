package com.kata.bank;
import org.springframework.boot.SpringApplication;
import java.util.Date.date;
import com.kata.bank.classes.Account;
import com.kata.bank.classes.Statement;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.kata.bank.classes.Amount.amountOf;

@SpringBootApplication
public class KataTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(KataTddApplication.class, args);
	Account account = new Account(new Statement());
		account.deposit(amountOf(5000), date("25/08/2022"));
		account.deposit(amountOf(10000), date("25/08/2022"));
		account.printStatement(System.out);
	}

}
