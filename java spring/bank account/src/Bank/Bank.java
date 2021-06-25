package Bank;
import java.util.Random;

public class Bank {
	private String account;
	private double checkingbalance;
	private double savingsbalance;
	private static int NumberOfAccounts = 0;
	private static double TotalAmountOfMoney = 0;
	

    public double getCheckingbalance() {
		return checkingbalance;
	}


	public double getSavingsbalance() {
		return savingsbalance;
	}


	public Bank(double checkingbalance, double savingsbalance) {
		account = random();
		this.checkingbalance = checkingbalance;
		this.savingsbalance = savingsbalance;
		NumberOfAccounts ++;
	}


	private String random() {
    	Random objGenerator = new Random();
    	String num = "";
    	for(int i = 0; i < 10; i++) {
    		 int int_random = objGenerator .nextInt(10); 
    		 num += int_random;
    	}
    	return num;
    }
	
	protected void  deposit(double amount, String x) {
		if(x == "checking balance" ) {
			checkingbalance += amount;
			}
		else {
			savingsbalance += amount;
		}
		
		TotalAmountOfMoney += amount;
		
	}
	
	protected void withdraw(double amount, String lana) {
		if (lana == "saving balance") {
			if (savingsbalance > amount)
			savingsbalance -= amount;
			else {
				System.out.println("insufficient funds");
			}
		}
		else  {
			if (checkingbalance > amount)
				checkingbalance -= amount;
				else {
					System.out.println("insufficient funds");
				}
		}
	}


	@Override
	public String toString() {
		return "Bank [checkingbalance=" + checkingbalance + ", savingsbalance=" + savingsbalance + "]";
	}
	

}
