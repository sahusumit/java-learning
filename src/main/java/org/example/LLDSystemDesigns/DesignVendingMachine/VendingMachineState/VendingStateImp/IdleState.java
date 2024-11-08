package org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingStateImp;

import org.example.LLDSystemDesigns.DesignVendingMachine.Coin;
import org.example.LLDSystemDesigns.DesignVendingMachine.Item;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachine;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingState;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements VendingState {

    public IdleState(){
        System.out.println("Please click the insert coin button!");
    }

    public IdleState(VendingMachine machine){
        System.out.println("please insert the coin");
        machine.setCoins(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) {
        machine.setVendingState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) {
        System.out.println("Please wait insert the coin!");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("disabled the insert coin!");
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
        throw new Exception("disabled the  dispenseProduct");
    }

    @Override
    public List<Coin> returnMoney(VendingMachine machine) throws Exception {
        throw new Exception("disabled the  returnMoney");
    }

    @Override
    public void updateProductInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        machine.getInventory().addItem(item,productCode);
    }
}
