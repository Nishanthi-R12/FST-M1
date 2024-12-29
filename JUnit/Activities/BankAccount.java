package session1;

public class BankAccount {

	private Integer balance;
	
	//Create a constructor
	public BankAccount (Integer initBalance) {
		balance = initBalance;
	}
	//Add method to calculate
	//Balance amount after withdrawal
	public Integer withdraw(Integer amount) {
		if (balance < amount) {
			throw new NotEnoughFundsException (amount, balance);
		}
		balance -= amount;
		return balance;
	}
}
