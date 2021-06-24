package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface{
	private LinkedHashMap<Long, Account> accounts;

	public static Long accountNumber=100000L;
	public Bank() {
		accounts=new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		return accounts.containsKey(accountNumber)?accounts.get(accountNumber) :null;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {

		Account commercialAccount= new CommercialAccount(company,accountNumber++,pin,startingDeposit);
		accounts.put(commercialAccount.getAccountNumber(), commercialAccount);
        return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		
		Account consumerAccount= new ConsumerAccount(person,accountNumber++,pin,startingDeposit); 
		accounts.put(consumerAccount.getAccountNumber(), consumerAccount);
        return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		if(accounts.containsKey(accountNumber))
		{
			Account acccount = accounts.get(accountNumber);
			return acccount.getPin()==pin;
		}
        return false;
	}

	public double getBalance(Long accountNumber) {
		if(accounts.containsKey(accountNumber))
		{
			Account acccount = accounts.get(accountNumber);
			return acccount.getBalance();
		}
        return -1;
	}

	public void credit(Long accountNumber, double amount) {
		if(accounts.containsKey(accountNumber))
		{
			Account acccount = accounts.get(accountNumber);
			acccount.creditAccount(amount);
		}
        
	}

	public boolean debit(Long accountNumber, double amount) {
		if(accounts.containsKey(accountNumber))
		{
			Account acccount = accounts.get(accountNumber);
			return acccount.debitAccount(amount);
		}
        return false;
	}
}
