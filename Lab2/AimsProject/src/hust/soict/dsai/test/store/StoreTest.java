package hust.soict.dsai.test.store;

import hust.soict.dsai.disc.DigitalVideoDisc;
import hust.soict.dsai.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 136, 15.49f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 12.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 14.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 18.99f);

        Store store = new Store();

        store.addDVD(dvd1, dvd2, dvd3, dvd4, dvd5);
        store.printStoreInventory();

        store.removeDVD(dvd2);
        store.printStoreInventory();

        // Try to remove a DVD that is not in the store
        store.removeDVD(new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 16.99f));
    }
}
