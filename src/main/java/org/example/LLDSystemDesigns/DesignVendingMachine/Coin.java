package org.example.LLDSystemDesigns.DesignVendingMachine;

public enum Coin {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    public int value;
    Coin(int value) {
        this.value = value;
    }
}
