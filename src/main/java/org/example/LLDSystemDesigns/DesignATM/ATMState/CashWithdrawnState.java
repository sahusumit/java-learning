package org.example.LLDSystemDesigns.DesignATM.ATMState;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal.CashWithdrawProcessor;
import org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal.OneHundredWithdrawProcessor;
import org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal.TwoHundredWithdrawProcessor;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

import static org.example.LLDSystemDesigns.DesignATM.ATM.atmObject;

public class CashWithdrawnState extends ATMState{
    public CashWithdrawnState(){
        System.out.println("Please enter the amount");
    }

    public void cashWithdrawal(ATM atm, UserATMCard userATMCard, int amount){

        if (atm.getAtmBalance() < amount) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atm);
        } else if (userATMCard.getBalance() < amount) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            userATMCard.deductBankBalance(amount);
            atmObject.deductedBalanceFromATM(amount);

            //using chain of responsibility for this logic, how many 500 Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new FiveHundredWithdrawProcessor(new TwoHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, amount);
            exit(atmObject);
        }

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
