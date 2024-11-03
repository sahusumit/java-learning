package org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal;

import org.example.LLDSystemDesigns.DesignATM.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{

    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }
    public void withdraw(ATM atm, int remainingAmount){

        int required =  remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        }
        else if(required > atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (required - atm.getNoOfOneHundredNotes()) * 100;
        }

        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
