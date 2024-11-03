package org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal;

import org.example.LLDSystemDesigns.DesignATM.ATM;

public class TwoHundredWithdrawProcessor extends CashWithdrawProcessor{
   public TwoHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }
    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/200;
        int balance = remainingAmount%200;

        if(required <= atm.getNoOfTwoHundredNotes()) {
            atm.deductTwoHundredNotes(required);
        }
        else if(required > atm.getNoOfTwoHundredNotes()) {
            atm.deductTwoHundredNotes(atm.getNoOfTwoHundredNotes());
            balance = balance + (required - atm.getNoOfTwoHundredNotes()) * 200;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
