import java.util.Scanner;

public class Bank {

	public static Account[] accountsArray;

	public static void main(String[] args) {

		final int REGISTER_ACTION = 1;
		final int DEPOSTI_ACTION = 2;
		final int WITHDRAW_ACTION = 3;
		final int TRANSFER_ACTION = 4;
		final int DISPLAY_AN_ACCOUNT_ACTION = 5;
		final int DISPLAY_ALL_ACCOUNTS_ACTION = 6;
		final int CALCULATE_A_LOAN_ACTION = 7;

		int accounts = 10;

		Scanner scan = new Scanner(System.in);

		menu();

		int input = scan.nextInt();

		while (input != 0) {

			switch (input) {

			case REGISTER_ACTION:

				System.out.println("Register an Account");
				System.out.println("How many Accounts would you like to register: ");
				accounts = scan.nextInt();

				accountsArray = new Account[accounts];

				for (int i = 0; i < accounts; i++) {

					System.out.println("Enter Account Number: ");
					int accountnumber = scan.nextInt();
					System.out.println("Enter Account Name: ");
					String name = scan.next();
					System.out.println("Enter Account Balance: ");
					double balance = scan.nextDouble();

					accountsArray[i] = new Account(accountnumber, balance, name);

					System.out.println("-------------------------------");
					System.out.println("Account have been registered.");
					System.out.println("-------------------------------");
				}
				break;

			case DEPOSTI_ACTION: {

				System.out.println("Enter account number to deposit: ");
				int acctnum = scan.nextInt();
				System.out.println("Enter amount to deposit: ");
				double amount = scan.nextDouble();

				search_with_deposit(accounts, acctnum, amount);

				break;

			}

			case WITHDRAW_ACTION: {

				System.out.println("Enter account number to withdraw: ");
				int acctnum = scan.nextInt();
				System.out.println("Enter amount to withdraw: ");
				double amount = scan.nextDouble();

				search_with_withdraw(accounts, acctnum, amount);

				break;

			}

			case TRANSFER_ACTION: {

				System.out.println("Enter amount to transfer: ");
				double amount = scan.nextDouble();
				System.out.println("Enter the sending account: ");
				int fromAccount = scan.nextInt();
				System.out.println("Enter the reciving account: ");
				int toAccount = scan.nextInt();

				search_with_withdraw(accounts, fromAccount, amount);

				search_with_deposit(accounts, toAccount, amount);

				break;
			}

			case DISPLAY_AN_ACCOUNT_ACTION: {
				System.out.println("Enter account number to display account: ");
				int accountnumber = scan.nextInt();

				display_account(accounts, accountnumber);

				break;

			}

			case DISPLAY_ALL_ACCOUNTS_ACTION: {

				display_all_accounts(accounts);

				break;

			}

			case CALCULATE_A_LOAN_ACTION: {

				break;

			}

			default: {
				System.out.println("Invalid input. Try again");
				break;

			}
			}

			menu_with_termination();
			input = scan.nextInt();
		}
		System.out.println("Bank is Exited");

	}

	public static void menu() {
		System.out.println("\t\tWelcome to Bank\n");
		System.out.println("\tMenu\n");
		System.out.println("1. Register.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Transfer.");
		System.out.println("5. Display An Account.");
		System.out.println("6. Display All Accounts.");
		System.out.println("7. Calculate a Loan.\n");
		System.out.println("Pick a a Service by the number: ");
	}

	public static void menu_with_termination() {
		System.out.println("\tMenu\n");
		System.out.println("1. Register.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Transfer.");
		System.out.println("5. Display An Account.");
		System.out.println("6. Display All Accounts.");
		System.out.println("7. Calculate a Loan.\n");
		System.out.println("Pick a a Service by the number. Enter 0 to exit: ");
	}

	public static void search_with_deposit(int accounts, int acctnum, double amount) {
		for (int i = 0; i < accounts; i++) {
			int acct = accountsArray[i].getaccountnumber();

			if (acct == acctnum) {
				accountsArray[i].deposit(amount);
			}
		}
	}

	public static void search_with_withdraw(int accounts, int acctnum, double amount) {
		for (int i = 0; i < accounts; i++) {
			int acct = accountsArray[i].getaccountnumber();

			if (acct == acctnum) {
				System.out.println();
				accountsArray[i].withdraw(amount);

			}
		}
	}

	public static void display_account(int accounts, int accountnumber) {
		for (int i = 0; i < accounts; i++) {
			if (accountnumber == accountsArray[i].getaccountnumber()) {
				System.out.println();
				accountsArray[i].displayAccount();

			}
		}

	}

	public static void display_all_accounts(int accounts) {
		for (int i = 0; i < accounts; i++) {

			accountsArray[i].displayAccount();
		}
	}

}
