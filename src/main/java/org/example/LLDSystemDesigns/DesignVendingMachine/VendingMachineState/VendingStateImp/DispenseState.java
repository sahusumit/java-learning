package org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingStateImp;

import org.example.LLDSystemDesigns.DesignVendingMachine.Coin;
import org.example.LLDSystemDesigns.DesignVendingMachine.Item;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachine;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingState;

import java.util.List;

public class DispenseState implements VendingState {

    DispenseState(VendingMachine machine, int productCode) throws Exception {
        System.out.println("Please wait your selected product is dispensing");
        dispenseProduct(machine, productCode);
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("disabled the insert coin!");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("disabled the product selection!");
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
        Item item = machine.getInventory().getItem(productCode);
        machine.getInventory().updateSoldOutItem(productCode);
        machine.setVendingState(new IdleState(machine));
        System.out.println("product has been dispensed. please pick from dispenser bucket");
        return item;
    }

    @Override
    public List<Coin> returnMoney(VendingMachine machine) throws Exception {
        throw new Exception("disabled the  returnMoney");
    }

    @Override
    public void updateProductInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        throw new Exception("disabled the updateProductInventory");
    }
}
