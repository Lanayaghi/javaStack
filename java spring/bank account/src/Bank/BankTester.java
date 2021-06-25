package Bank;

public class BankTester {

	public static void main(String[] args) {
		Bank lana = new Bank(1000.0, 1000.0);
		System.out.println(lana.toString());
		lana.deposit(5000, "checking balance");
		System.out.println(lana.toString());
		lana.withdraw(500, "saving balance");
		System.out.println(lana.toString());
	}

}
