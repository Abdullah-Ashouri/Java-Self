
public class Loan {
	
	
	double loanAmount; // amount of principal
	int monthsToPay; // number of payments
	double interestRate; // monthly interest rate
	
	 Loan( double loanAmount, int monthsToPay, double interestRate){
	
		this.loanAmount = loanAmount;
		this.monthsToPay = monthsToPay;
		this.interestRate = interestRate;
	}
	
	

	void setloanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	void setmonthsToPay(int monthsToPay) {
		this.monthsToPay = monthsToPay;
	}
	
	public double getloanAmount() {
		return loanAmount;
	}
	public int getMonthsToPay() {
		return monthsToPay;
	}
	
	
	public double interestRateCalculated() {
		
		double monthlyPayment = 0;
		
		double annualInterestRate = ((interestRate/100) / 12);
		
		double innerTop = Math.pow(((1 + annualInterestRate)), monthsToPay);
		
		double innerBottom = Math.pow(((1 + annualInterestRate)), monthsToPay);
		
		monthlyPayment = getloanAmount()*(annualInterestRate*innerTop)/(innerBottom - 1);
		
		return monthlyPayment;
		
	}


}
