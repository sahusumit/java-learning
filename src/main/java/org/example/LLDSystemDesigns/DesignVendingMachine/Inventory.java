package org.example.LLDSystemDesigns.DesignVendingMachine;

import java.util.List;

public class Inventory {
  ItemShelf[] inventory =null;

  Inventory(int itemCount){
      inventory = new ItemShelf[itemCount];
      initialEmptyInventory();

  }

  public ItemShelf[] getInventory(){
      return  inventory;
  }

  public void setInventory(ItemShelf[] shelves){
      this.inventory  = shelves;
  }

  public  void initialEmptyInventory(){
      int startCode = 101;
      for(int i=0; i<inventory.length; i++){
          ItemShelf shelf = new ItemShelf();
          shelf.setCode(startCode);
          shelf.setSoldOut(true);
          inventory[i] = shelf;
          startCode++;
      }
  }


  public void addItem(Item item, int productCode) throws Exception {
      for(ItemShelf shelf: inventory){
          if(shelf.getCode()==productCode){
              if(shelf.isSoldOut()){
                  shelf.item = item;
                  shelf.setSoldOut(false);
              }else {
                  throw new Exception("Already item is present in inventory, wait for the sold out the item");
              }
          }
      }
  }

  public Item getItem(int productCode) throws Exception {
      for(ItemShelf itemShelf: inventory){
          if(itemShelf.getCode() == productCode){
              if(itemShelf.isSoldOut()){
                  throw new Exception("Item already sold");
              }else{
                  return itemShelf.getItem();
              }
          }
      }
      throw new Exception("Invalid code! Please enter the valid product code!");
  }


  public void updateSoldOutItem(int productCode){
      for(ItemShelf itemShelf: inventory){
          if(itemShelf.getCode() == productCode){
              itemShelf.setSoldOut(true);
          }
      }
  }
}
