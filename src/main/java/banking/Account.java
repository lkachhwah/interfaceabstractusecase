package banking;

/**
 * Abstract bank account class.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #accountHolder}: AccountHolder<br>
 * {@link #accountNumber}: Long<br>
 * {@link #pin}: int<br>
 * {@link #balance}: double
 */
public abstract class Account implements AccountInterface{
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		this.accountHolder= accountHolder;
		this.accountNumber=accountNumber;
		this.pin= pin;
		this.balance= startingDeposit;
	}

	public AccountHolder getAccountHolder() {
		
        return this.accountHolder;
	}

	public boolean validatePin(int attemptedPin) {
        return attemptedPin>0;
	}

	public double getBalance() {
		// complete the function
        return this.balance;
	}

	public Long getAccountNumber() {
		
        return this.accountNumber;
	}

	public void creditAccount(double amount) {
		this.balance=this.balance+amount;
	}

	public boolean debitAccount(double amount) {
		if(balance>=amount)
		{
		this.balance=this.balance-amount;
		return true;
		}
		return false;
	}
}
