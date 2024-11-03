package org.example.LLDSystemDesigns.DesignATM;

public class ATMRoom {
    ATM atm;
    User user;
    public static void main(String[] args){

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.userATMCard);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.userATMCard, 3415);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.userATMCard, TransactionType.CASH_WITHDRAWN);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.userATMCard, 2700);
        atmRoom.atm.printCurrentATMStatus();


    }

    private  void initialize(){
        atm = ATM.getATMObject();
        atm.setAtmBalance(15000,20, 15, 20);
        this.user = createUser();
    }

    private User createUser(){
        User user = new User();
        user.setUserATMCard(createCard());
        return user;
    }
    private UserATMCard createCard(){
        UserATMCard card = new UserATMCard();
        card.setUserBankAccount(createBankAccount());
        return card;
    }
    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 3000;
        return bankAccount;

    }


}
