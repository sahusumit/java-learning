package org.example.LLDSystemDesigns.DesignATM.ATMState;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.TransactionType;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

public abstract  class ATMState {

    public  void insertCard(ATM atm, UserATMCard userATMCard){
        System.out.println("user insert the card");
    }

    public  void authenticatePin(ATM atm, UserATMCard userATMCard, int pin){
        System.out.println("user insert the card");
    }

    public  void selectOperation(ATM atm, UserATMCard userATMCard, TransactionType txnType){
        System.out.println("user insert the card");
    }
    public  void cashWithdrawal(ATM atm, UserATMCard userATMCard, int amount){
        System.out.println("user insert the card");
    }
    public  void displayBalance(ATM atm, UserATMCard userATMCard){
        System.out.println("user insert the card");
    }
    public  void returnCard(){
        System.out.println("please collect your card");
    }
    public  void exit(ATM atm){
        System.out.println("user insert the card");
    }
}
