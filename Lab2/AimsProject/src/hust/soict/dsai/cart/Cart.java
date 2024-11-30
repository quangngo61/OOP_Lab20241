package hust.soict.dsai.cart;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full.");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added to your cart");
		}
	}
	
	//a list of DVDs
	/*public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered++] = dvd;
                System.out.println("Added DVD: " + dvd.getTitle());
            } else {
                System.out.println("The cart is full! Cannot add more items.");
                break;
            }
        }
    }*/

	//an arbitrary number of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered++] = dvd;
                System.out.println("Added DVD: " + dvd.getTitle());
            } else {
                System.out.println("The cart is full! Cannot add more items.");
                break;
            }
        }
    }
	
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED - 1) { // Ensure space for two DVDs
            itemsOrdered[qtyOrdered++] = dvd1;
            System.out.println("Added DVD: " + dvd1.getTitle());

            itemsOrdered[qtyOrdered++] = dvd2;
            System.out.println("Added DVD: " + dvd2.getTitle());
        } else if (qtyOrdered < MAX_NUMBERS_ORDERED) { // Only one space left
            itemsOrdered[qtyOrdered++] = dvd1;
            System.out.println("Added DVD: " + dvd1.getTitle());
            System.out.println("The cart is full! Cannot add the second DVD.");
        } else {
            System.out.println("The cart is full! Cannot add any DVDs.");
        }
    }
    
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		boolean removed = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, qtyOrdered - i - 1);
                qtyOrdered--;
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc is not in the cart.");
        }
    }

    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    //Print the cart with details of the DVDs
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Search for a DVD by its ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("DVD Found: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    // Search for DVDs by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("DVD Found: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
 
}
