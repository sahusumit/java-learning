package org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState;

import org.example.LLDSystemDesigns.DesignVendingMachine.Coin;
import org.example.LLDSystemDesigns.DesignVendingMachine.Item;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachine;

import java.util.List;

public interface VendingState {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception;
    public int getChange(int changeMoney) throws Exception;
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception;
    public List<Coin> returnMoney(VendingMachine machine) throws Exception;
    public void updateProductInventory(VendingMachine machine,Item item, int productCode) throws Exception;
}
