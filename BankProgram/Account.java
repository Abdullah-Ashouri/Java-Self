import java.util.ArrayList;
import java.util.Arrays;

public class Account {

	private double balance;
	private int accountNumber;
	private String name;
	
	Bank account = new Bank();
	
	public void getAccountName(String name) {
		this.name = name;
	}
	
	public void getbalance(double balance) {
		this.balance = balance;
	}
	
	public void getaccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double deposit (int accountNumber, double amt) {
		
		int index = Bank.acctNums.indexOf(accountNumber);
		
		System.out.println("Account Number: "+ accountNumber);
		System.out.println("Name: " + Bank.acctNam.get(index));
		System.out.println("Account Balance: " + Bank.acctblc.get(index));
		
		 Bank.acctblc.set(index, Bank.acctblc.get(index)+ amt);
		 
		 return (double) Bank.acctblc.get(index);
	}
	
	public double withdraw (int accountNumber, double amt) {
		
		int index = Bank.acctNums.indexOf(accountNumber);
		
		System.out.println("Account Number: "+ accountNumber);
		System.out.println("Name: " + Bank.acctNam.get(index));
		System.out.println("Account Balance: " + Bank.acctblc.get(index));
		
		Bank.acctblc.set(index, Bank.acctblc.get(index)- amt);
		
		return (double) Bank.acctblc.get(index);
	}
	
	public void displayOneAcct(int accountNumber) {
		int index = 0;
		
		index = Bank.acctNums.indexOf(accountNumber);
		
		System.out.println("--------------------------------------");
		System.out.println("Account Number: " + accountNumber );
		System.out.println("Name: " + Bank.acctNam.get(index));
		System.out.println("Balance: " + Bank.acctblc.get(index));
		System.out.println("--------------------------------------");
		
		
		
		
	}
	
	
	
	
}
