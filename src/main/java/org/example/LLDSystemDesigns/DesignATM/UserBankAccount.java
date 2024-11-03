package org.example.LLDSystemDesigns.DesignATM;

public class UserBankAccount {
    int balance;

    public int getBalance() {
        return balance;
    }
    public void updateBalance(int amount){
        balance = balance - amount;

    }
}
