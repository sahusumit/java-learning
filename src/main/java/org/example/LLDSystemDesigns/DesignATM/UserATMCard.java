package org.example.LLDSystemDesigns.DesignATM;

import java.util.Date;

public class UserATMCard {
   private int cardNumber;
   private int cardPin;
   private  int cvv;
   static int PIN_NUMBER = 3415;
   private String holderName;
   private Date expiryDate;
  UserBankAccount userBankAccount;


  public boolean isPinCorrect(int pin){
      return pin == PIN_NUMBER;
  }
  public int getBalance(){
    return  this.userBankAccount.balance;
  }
  public void setUserBankAccount(UserBankAccount userBankAccount){
       this.userBankAccount = userBankAccount;
    }

    public void deductBankBalance(int amount){
        userBankAccount.updateBalance(amount);
    }


}
