package org.example.LLDSystemDesigns.DesignATM.ATMState;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

public class CheckBalanceState extends ATMState {
   public CheckBalanceState(){

   }

   @Override
    public  void displayBalance(ATM atm, UserATMCard userATMCard){
       System.out.println("Your Balance is: " + userATMCard.getBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit done");
    }

    @Override
    public void returnCard() {
        super.returnCard();
    }
}
