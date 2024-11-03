package org.example.LLDSystemDesigns.DesignATM.AmountWithdrawal;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        this.nextCashWithdrawProcessor = cashWithdrawProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount){
        if(nextCashWithdrawProcessor!=null){
            nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }
}
