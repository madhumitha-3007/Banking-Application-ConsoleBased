package com.wipro.bank.service;
import com.wipro.bank.exception.BankValidationException;
import com.wipro.bank.acc.RDAccount;

public class BankService {
    public boolean validateData(float principal, int tenure, int age, String gender) {

        try {
            if (principal < 500 ||  (tenure != 5 && tenure != 10) ||
           age < 1 || age > 100 ||
           !(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {
      throw new BankValidationException();
            }
         return true;
        }
        catch (BankValidationException e) {
            return false;
        }
    }
    
    public void calculate(float principal, int tenure, int age, String gender) {

        if (validateData(principal, tenure, age, gender)) {
           RDAccount rd = new RDAccount(tenure, principal);
           rd.setInterest(age, gender);
          
          float interest = rd.calculateInterest();
          System.out.println("Interest: " + interest);
          
         float amountDeposited  = rd.calculateAmountDeposited();
         System.out.println("Deposited Amount: " + amountDeposited);
         
         float maturityAmount = rd.calculateMaturityAmount(amountDeposited, interest);
         System.out.println("Maturity Amount: " + maturityAmount);

     } else {
         System.out.println("Invalid Data");
     }
 }
    }
