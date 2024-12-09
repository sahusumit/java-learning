package org.example.LLDSystemDesigns.DesignATM.ATMState;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.TransactionType;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

public class SelectOperationState extends ATMState{


    public SelectOperationState(){
        showOperation();
    }

    @Override
    public void selectOperation(ATM atm, UserATMCard userATMCard, TransactionType txnType) {
        switch (txnType) {

            case CASH_WITHDRAWN:
                atm.setCurrentATMState(new CashWithdrawnState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentATMState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }

        }

    }

    private void showOperation(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();

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
