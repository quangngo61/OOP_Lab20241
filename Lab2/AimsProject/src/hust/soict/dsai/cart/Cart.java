package hust.soict.dsai.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Add a Media item to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The item is already in the cart: " + media.getTitle());
        } else {
            itemsOrdered.add(media);
            System.out.println("Added to the cart: " + media.getTitle());
        }
    }

    // Remove a Media item from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed from the cart: " + media.getTitle());
        } else {
            System.out.println("The item is not in the cart: " + media.getTitle());
        }
    }

    // Remove a Media item by title
    public boolean removeMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                itemsOrdered.remove(media);
                System.out.println("Removed from the cart: " + media.getTitle());
                return true;
            }
        }
        System.out.println("The item with title \"" + title + "\" is not in the cart.");
        return false;
    }

    // Calculate the total cost of items in the cart
    public double totalCost() {
        double total = 0.0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Print the cart with details of the items
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Filter Media items by ID
    public List<Media> filterById(int id) {
        return itemsOrdered.stream()
                .filter(media -> media.getId() == id)
                .collect(Collectors.toList());
    }

    // Filter Media items by title
    public List<Media> filterByTitle(String title) {
        return itemsOrdered.stream()
                .filter(media -> media.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    // Search for a Media item by its ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Item Found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID: " + id);
        }
    }

    // Search for Media items by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Item Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found with title: " + title);
        }
    }

    // Sort by title, then cost
    public void sortByTitleThenCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title, then cost.");
    }

    // Sort by cost, then title
    public void sortByCostThenTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost, then title.");
    }

    // Get all items in the cart
    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Clear the cart after placing an order
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }
}
