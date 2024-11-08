package org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingStateImp;

import org.example.LLDSystemDesigns.DesignVendingMachine.Coin;
import org.example.LLDSystemDesigns.DesignVendingMachine.Item;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachine;
import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingState;

import java.util.List;

public class SelectionState implements VendingState {

   public SelectionState(){
       System.out.println("Please select the product you want to purchase");
   }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("disabled the insert coin!");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) {
      return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("disabled the insert coin!");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int productCode) throws Exception {
       Item item = machine.getInventory().getItem(productCode);
       int paidByUser =0;
       for(Coin coin: machine.getCoins()){
           paidByUser = paidByUser + coin.value;
       }

       if(paidByUser < item.getPrice()){
           System.out.println("Insufficient amount, product you selected is for price "+ item.getPrice());
           System.out.println("Please add "+ (item.getPrice()-paidByUser)+ " to get the product");
           returnMoney(machine);
           throw new Exception("Insufficient amount");
       }
       else if (paidByUser>=item.getPrice()){
           machine.setVendingState(new DispenseState(machine, productCode));
           if(paidByUser>item.getPrice()){
               getChange(paidByUser- item.getPrice());
           }
       }
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        System.out.println("Please collect the change from dispense tray :"+ changeMoney);
        return  changeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int productCode) throws Exception {
        throw new Exception("disabled the  dispenseProduct");
    }

    @Override
    public List<Coin> returnMoney(VendingMachine machine) throws Exception {
       machine.setVendingState(new IdleState(machine));
        System.out.println("Returned the full amount back to the coin tray! please collect.");
        return machine.getCoins();
    }

    @Override
    public void updateProductInventory(VendingMachine machine, Item item, int productCode) throws Exception {
        machine.getInventory().addItem(item,productCode);
    }
}
