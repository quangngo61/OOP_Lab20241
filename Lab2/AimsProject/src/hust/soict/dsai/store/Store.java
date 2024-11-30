package hust.soict.dsai.store;

import java.util.ArrayList;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Store {
    // no limit on the number of DVDs
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();
    
    //Add
    public void addDVD(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            itemsInStore.add(dvd);
            System.out.println("DVD '" + dvd.getTitle() + "' has been added to the store.");
        }
    }

    // remove 
    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("DVD '" + dvd.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("DVD '" + dvd.getTitle() + "' is not in the store.");
        }
    }

    //Check
    public void printStoreInventory() {
        System.out.println("********** Store Inventory **********");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store has no DVDs available.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*************************************");
    }
}
