package org.example.LLDSystemDesigns.DesignATM.ATMState;

import org.example.LLDSystemDesigns.DesignATM.ATM;
import org.example.LLDSystemDesigns.DesignATM.UserATMCard;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, UserATMCard userATMCard) {
        System.out.println(" Inserted the card");
        atm.setCurrentATMState(new HasCardState());
    }
}
