import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	public static int accountsneeded;

	static ArrayList<Double> acctblc = new ArrayList<>();
	static ArrayList<Integer> acctNums = new ArrayList<>();
	static ArrayList<String> acctNam = new ArrayList<>();

	public static void main(String[] args) {
		final int EXIT_ACTION = 0;
		final int REGISTER_ACTION = 1;
		final int DEPOSTI_ACTION = 2;
		final int WITHDRAW_ACTION = 3;
		final int TRANSFER_ACTION = 4;
		final int DISPLAY_AN_ACCOUNT_ACTION = 5;
		final int DISPLAY_ALL_ACCOUNTS_ACTION = 6;
		final int CALCULATE_A_LOAN_ACTION = 7;

		boolean running = true;

		Scanner scan = new Scanner(System.in);

		Account acct = new Account();

		System.out.println("\t\tWelcome to Bank\n");
		System.out.println("\tMenu\n");
		System.out.println("1. Register.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Transfer.");
		System.out.println("5. Display An Account.");
		System.out.println("6. Display All Accounts.");
		System.out.println("7. Calculate a Loan.\n");

		System.out.println("What would you like to do(Enter a number from the menu): ");
		int input = scan.nextInt();

		while (running) {

			if (input == REGISTER_ACTION) {

				System.out.println("How many accounts would you like to enter: ");
				accountsneeded = scan.nextInt();

				for (int i = 0; i < accountsneeded; i++) {
					System.out
							.println("Creat an accout Number Enter full name and balance:(Ex: 12345 Abdallah 500.0) ");
					int accountNumber = scan.nextInt();
					String name = scan.next();
					double balance = scan.nextDouble();
					register(accountNumber, name, balance);
					System.out.println("Account is registered.");
					}	

			}

			if (input == DEPOSTI_ACTION) {

				System.out.println("Enter account Number to make a Deposit: ");
				int accountnumber = scan.nextInt();
				acct.getaccountNumber(accountnumber);

				System.out.println("Enter amount to Deposit: ");
				double amt = scan.nextDouble();

				System.out.println("New Balance is: " + acct.deposit(accountnumber, amt));

			}

			if (input == WITHDRAW_ACTION) {

				System.out.println("Enter account Number to make a Withdraw: ");
				int accountnumber = scan.nextInt();
				acct.getaccountNumber(accountnumber);

				System.out.println("Enter amount to Withdraw: ");
				double amt = scan.nextDouble();

				System.out.println("New Balance is: " + acct.withdraw(accountnumber, amt));

			}
			
			if(input == TRANSFER_ACTION) {
				
				System.out.println("Enter the Account Numbers.");
				System.out.print("Account number to transfer from: ");
				int acctNumFrom = scan.nextInt();
				System.out.print("\nAccount number to transfer to: ");
				int acctNumTo = scan.nextInt();
				System.out.print("\nAmmount to transfer: ");
				int amt = scan.nextInt();
				
				transfer(acctNumFrom, acctNumTo, amt);
				
				
			}

			if (input == DISPLAY_AN_ACCOUNT_ACTION) {
				System.out.println("Enter Account number to be displayed: ");
				int accountNumber = scan.nextInt();

				acct.displayOneAcct(accountNumber);

			}

			if (input == DISPLAY_ALL_ACCOUNTS_ACTION) {

				displayAllAccts();

			}

			if (input == CALCULATE_A_LOAN_ACTION) {

			}

			System.out.println("\n\n\t\tWelcome to Bank");
			System.out.println("\tMenu\n");
			System.out.println("1. Register.");
			System.out.println("2. Deposit.");
			System.out.println("3. Withdraw.");
			System.out.println("4. Transfer.");
			System.out.println("5. Display Account.");
			System.out.println("6. Display All Accounts.");
			System.out.println("7. Calculate a Loan.\n");

			System.out.println("What would you like to do(Enter a number from the menu): \n" + "Enter 0 to exit");
			input = scan.nextInt();

			if (input == EXIT_ACTION) {
				break;
			}

		}

	}

	public static void displayAllAccts() { // must be bank acct

		for (int i = 0; i < accountsneeded; i++) {
			System.out.println(i);
			System.out.println("--------------------------------------");
			System.out.println("Account Number: " + acctNums.get(i));
			System.out.println("Name: " + acctNam.get(i));
			System.out.println("Balance: " + acctblc.get(i));

		}
		System.out.println("--------------------------------------");
	}

	public static void register(int accountNumber, String name, double balance) { // must be in bank class

		for (int i = 0; i < accountsneeded; i++) {
			acctNums.add(accountNumber);
			acctNam.add(name);
			acctblc.add(balance);
		}
	}

	public static void transfer(int accountNumberFrom, int accountNumberTo, int amt) {

		int indexfrom = acctNums.indexOf(accountNumberFrom);
		double balanceFrom = acctblc.get(indexfrom);
		double newBalanceFrom = balanceFrom - amt;
		acctblc.add(indexfrom, newBalanceFrom);

		int indexTo = acctNums.indexOf(accountNumberTo);
		double balanceTo = acctblc.get(indexTo);
		double newbalanceTo = balanceTo + amt;
		acctblc.add(indexTo, newbalanceTo);

		System.out.println("Balance of " + accountNumberFrom + ": " + balanceFrom);
		System.out.println("New balance: " + newBalanceFrom + "\n");
		System.out.println("Balance of " + accountNumberTo + ": " + balanceTo);
		System.out.println("New Balance: " + newbalanceTo + "\n");

	}

}
