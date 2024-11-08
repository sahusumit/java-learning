package org.example.LLDSystemDesigns.DesignVendingMachine;

import org.example.LLDSystemDesigns.DesignVendingMachine.VendingMachineState.VendingState;

public class VendingMachineMainEngine {
    public static void main(String [] args){
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("---------------------------------------------");
            System.out.println("filling up the inventory");
            System.out.println("----------------------------------------------");

            fillingUpInventory(vendingMachine);
            displayInventoryOfVendingMachine(vendingMachine);

            System.out.println("----------------------------------------------");
            System.out.println("Click on Insert coin");
            System.out.println("----------------------------------------------");

            VendingState state = vendingMachine.getVendingState();
            state.clickOnInsertCoinButton(vendingMachine);


            state = vendingMachine.getVendingState();
            state.insertCoin(vendingMachine, Coin.NICKLE);
            state.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("----------------------------------------------");
            System.out.println("Click on product selection button");
            System.out.println("----------------------------------------------");

            state = vendingMachine.getVendingState();
            state.clickOnStartProductSelectionButton(vendingMachine);

            state = vendingMachine.getVendingState();
            state.chooseProduct(vendingMachine, 102);

            displayInventoryOfVendingMachine(vendingMachine);


        }catch (Exception e){
            displayInventoryOfVendingMachine(vendingMachine);
        }

    }

    private static void fillingUpInventory(VendingMachine vendingMachine){
       ItemShelf[] shelves =  vendingMachine.getInventory().getInventory();
       for(int i =0; i<shelves.length; i++){
           Item item = new Item();
           if(i < 5){
               item.setItemType(ItemType.CHOCOLATE);
               item.setPrice(5);
           } else if (i>=5 && i<10) {
               item.setItemType(ItemType.COKE);
               item.setPrice(30);
           }
           else if (i>=10 && i<15) {
               item.setItemType(ItemType.MANGO);
               item.setPrice(20);
           } else if (i>=15 && i<20) {
               item.setItemType(ItemType.SODA);
               item.setPrice(10);
           } else if (i>=20 && i<25) {
               item.setItemType(ItemType.JUICE);
               item.setPrice(40);
           }
           shelves[i].setItem(item);
           shelves[i].setSoldOut(false);
       }
    }

    private static void displayInventoryOfVendingMachine(VendingMachine vendingMachine){
        ItemShelf[] shelves = vendingMachine.getInventory().getInventory();
        for(ItemShelf itemShelf: shelves){
            System.out.println("Item: "+ itemShelf.getItem().getItemType().name() +
                    ", code: "+ itemShelf.getCode() +
                    ", Price "+ itemShelf.getItem().getPrice() +
                    ", isAvailable "+ (!itemShelf.isSoldOut() ? "Available" : "Sold Out"));
        }
    }
}
