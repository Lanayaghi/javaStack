package calculatorOne;

public class Calculator implements java.io.Serializable{
	private double results;
	private double num1;
	private double num2;
	private char operator;
	
	public double getResults() {
		return results;
	}





	public void setNum1(double num1) {
		this.num1 = num1;
	}



	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public void getOperator() {
		if(this.operator == '+') {
			results = (num1) +(num2);
			
		}
		if(this.operator == '-') {
			results = (num1) - (num2);
		}
	}

	public void setOperator(char operator) {
		this.operator = operator;
	}

	public Calculator() {
		
	}

}
