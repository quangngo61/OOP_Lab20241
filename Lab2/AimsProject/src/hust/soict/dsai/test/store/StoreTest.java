package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create Media items
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 136, 15.49f);
        Book book1 = new Book(15, "The Pragmatic Programmer", "Programming", 30.00f);
        CompactDisc cd1 = new CompactDisc(1, "Thriller", "Pop", 42.99f, "Music", 4, "Michael Jackson");

        // Initialize the store
        Store store = new Store();

        // Add multiple Media items to the store
        store.addMedia(dvd1, dvd2, book1, cd1);
        store.printStoreInventory();

        // Remove an item from the store
        store.removeMedia(dvd2);
        store.printStoreInventory();

        // Try to remove an item not in the store
        store.removeMedia(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 16.99f));
    }
}
