package hust.soict.dsai.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    // Store inventory as a list of Media objects
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    
    // Add one or more Media items to the store
    public void addMedia(Media... mediaItems) {
        for (Media media : mediaItems) {
            if (!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                System.out.println("Media '" + media.getTitle() + "' has been added to the store.");
            } else {
                System.out.println("Media '" + media.getTitle() + "' is already in the store.");
            }
        }
    }

    // Remove a Media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("Media '" + media.getTitle() + "' is not in the store.");
        }
    }
    
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Print the store inventory
    public void printStoreInventory() {
        System.out.println("********** Store Inventory **********");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store has no items available.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*************************************");
    }
}
