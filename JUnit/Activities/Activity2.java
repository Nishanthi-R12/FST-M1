package session1;

import org.junit.jupiter.api.Test;
import session1.BankAccount;
import session1.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

class Activity2 {

	@Test
	void notEnoughFunds () {
		//Create an object for bank account class
		BankAccount account = new BankAccount (10);
		//Assertion for exception
		assertThrows (NotEnoughFundsException.class, () -> account.withdraw(11), "Balance must be greater than amount of withdrawal");
	}
	@Test
	void enoughFunds () {
		//Create an object for bank account class
		BankAccount account = new BankAccount (100);
		//Assertion for no exception
		assertDoesNotThrow (() -> account.withdraw(100));
	}
}

/* Create a JUnit test named Activity2.
Write two @Test annotations, notEnoughFunds() and enoughFunds().
In notEnoughFunds(),
Create an object for the BankAccount and set balance to 10.
Add an assertion, assertThrows(), that expects the NotEnoughFundsException custom exception to be thrown.
In enoughFunds(),
Create an object for the BankAccount and set balance to 100.
Add an assertion, assertDoesNotThrow(), that expects the NotEnoughFundsException custom exception to NOT be thrown.
*/