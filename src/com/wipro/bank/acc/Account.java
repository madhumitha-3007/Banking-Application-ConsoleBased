package com.wipro.bank.acc;

public abstract class Account {
	public int tenure;
	public float principal;
	public float rateOfInterest;
	
	public void setInterest(int age, String gender) {
		if (gender.equals("Male") && age<60) {
			this.rateOfInterest=9.8f;
		}
		else if (gender.equals("Male")  && age>=60) {
			this.rateOfInterest=10.5f;
		}
		else if (gender.equals("Female") && age<58) {
			this.rateOfInterest=10.2f;
		}
		else if (gender.equals("Female")  && age>=58) {
			this.rateOfInterest=10.8f;
		}
	}
	
	public float calculateMaturityAmount(float totalPrincipleDeposited, float maturityInterest) {
		
		return totalPrincipleDeposited + maturityInterest;		
	}
	
	public abstract float calculateInterest();
	public abstract float calculateAmountDeposited();
	
}
