package org.example.LLDSystemDesigns.DesignATM;

import org.example.LLDSystemDesigns.DesignATM.ATMState.ATMState;
import org.example.LLDSystemDesigns.DesignATM.ATMState.IdleState;

public class ATM {

    public static ATM atmObject = new ATM(); // singleton eager initialization
    ATMState currentATMState;
    private int atmBalance;
    int noOfFiveHundredNotes;
    int noOfTwoHundredNotes;
    int noOfOneHundredNotes;
    public ATM(){
    }

    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState = currentATMState;
    }

    public ATMState getCurrentATMState(){
       return currentATMState;
    }

    public static ATM getATMObject(){
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }

    public int getAtmBalance(){
        return  this.atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfFiveHundredNotes,int noOfTwoHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoHundredNotes = noOfTwoHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }


    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfTwoHundredNotes() {
        return noOfTwoHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductedBalanceFromATM(int amount){
        atmBalance = atmBalance-amount;
    }

    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes = noOfFiveHundredNotes -number;
    }
    public void deductTwoHundredNotes(int number){
        noOfTwoHundredNotes = noOfTwoHundredNotes -number;
    }
    public void deductOneHundredNotes(int number){
        noOfOneHundredNotes = noOfOneHundredNotes -number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("200Notes: " + noOfTwoHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);
    }

}
