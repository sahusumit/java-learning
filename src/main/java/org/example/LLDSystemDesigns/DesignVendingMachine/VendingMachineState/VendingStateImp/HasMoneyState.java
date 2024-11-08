package org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingStateImp;

import org.example.LLDSystemDesigns.DesignVendingMachine.Coin;
import org.example.LLDSystemDesigns.DesignVendingMachine.Item;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachine;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingState;

import java.util.List;

public class HasMoneyState implements VendingState {
    public HasMoneyState(){
        System.out.println("Processing the money!");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) {
        machine.setVendingState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) {
        System.out.println("Accepted the coin: "+ coin.value);
        machine.getCoins().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("disabled the selection product");
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        throw new Exception("disabled the change returned");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("disabled the change dispense product");
    }

    @Override
    public List<Coin> returnMoney(VendingMachine machine) {
        machine.setVendingState(new IdleState(machine));
        System.out.println("Returned the full amount back to the coin tray! please collect.");
        return machine.getCoins();
    }

    @Override
    public void updateProductInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("disabled the updateProductInventory");
    }
}
