package org.example.LLDSystemDesigns.DesignATM.ATMState;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

public class HasCardState extends ATMState {
    public HasCardState(){
        System.out.println("Enter the pin");
    }

    @Override
    public void authenticatePin(ATM atm, UserATMCard userATMCard, int pin) {
        boolean isCorrectPin = userATMCard.isPinCorrect(pin);
        if( isCorrectPin){
            atm.setCurrentATMState(new SelectOperationState());
        }else{
            System.out.println("Invalid PIN Number");
            exit(atm);
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
