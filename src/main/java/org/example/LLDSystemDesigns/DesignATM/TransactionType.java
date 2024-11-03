package org.example.LLDSystemDesigns.DesignATM;

public enum TransactionType {
    CASH_WITHDRAWN,
    BALANCE_CHECK;
    public static void showAllTransactionTypes(){
        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
