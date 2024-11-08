package org.example.LLDSystemDesigns.DesignVendingMachine;

import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingState;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingStateImp.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingState vendingState;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine(){
        this.vendingState = new IdleState();
        this.inventory = new Inventory(20);
        this.coins = new ArrayList<>();

    }


    public VendingState getVendingState() {
        return vendingState;
    }

    public void setVendingState(VendingState vendingState) {
        this.vendingState = vendingState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
}
