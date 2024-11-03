package org.example.LLDSystemDesigns.DesignATM;

public class User {
    UserATMCard userATMCard;
    UserBankAccount userBankAccount;

    public UserATMCard getUserATMCard() {
        return userATMCard;
    }

    public void setUserATMCard(UserATMCard userATMCard) {
        this.userATMCard = userATMCard;
    }
}
