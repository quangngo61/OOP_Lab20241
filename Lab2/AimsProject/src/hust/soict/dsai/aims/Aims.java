package hust.soict.dsai.aims;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.exception.PlayerException; 

import javax.swing.JOptionPane;  // For dialog box

import java.util.ArrayList;
import java.util.Scanner;

public class Aims{
    private static Cart cart = new Cart();
    private static ArrayList<Media> store = new ArrayList<>();

    public static void main(String[] args) {
        initializeStore();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    viewCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void initializeStore() {
        store.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.add(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.add(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
        store.add(new DigitalVideoDisc("Frozen", "Animation", 22.99f));
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("----------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore(Scanner scanner) {
        System.out.println("********************STORE********************");
        for (int i = 0; i < store.size(); i++) {
            System.out.println((i + 1) + ". " + store.get(i).toString());
        }
        System.out.println("********************************************");

        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    seeMediaDetails(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    System.out.println("Play media functionality coming soon!");
                    break;
                case 4:
                    viewCart(scanner);
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("----------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("----------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void seeMediaDetails(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : store) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Details of the media: ");
                System.out.println(media.toString());
                mediaDetailsMenu(scanner, media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        System.out.println("Options: ");
        System.out.println("----------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("----------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                cart.addMedia(media);
                break;
            case 2:
                // Wrap play call in try-catch to handle PlayerException
                try {
                    media.play(); // This may throw PlayerException
                } catch (PlayerException e) {
                    // Print exception details
                    System.err.println("Error occurred while playing media: " + e.getMessage());
                    e.printStackTrace(); // Print stack trace
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 0:
                System.out.println("Returning to previous menu.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : store) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                cart.addMedia(media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Media with title \"" + title + "\" not found in the store.");
        }
    }

    public static void updateStore(Scanner scanner) {
        System.out.println("Update store functionality coming soon!");
    }

    public static void viewCart(Scanner scanner) {
        cart.printCart();

        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.println("Filter functionality coming soon!");
                    break;
                case 2:
                    sortCart(scanner);
                    break;
                case 3:
                    removeFromCart(scanner);
                    break;
                case 4:
                    System.out.println("Play media functionality coming soon!");
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("----------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("----------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void sortCart(Scanner scanner) {
        System.out.println("Sort by: ");
        System.out.println("1. Title, then Cost");
        System.out.println("2. Cost, then Title");
        System.out.print("Choose sorting option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                cart.sortByTitleThenCost();
                break;
            case 2:
                cart.sortByCostThenTitle();
                break;
            default:
                System.out.println("Invalid choice. Returning to cart menu.");
        }
    }

    public static void removeFromCart(Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                cart.removeMedia(media);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Media with title \"" + title + "\" not found in the cart.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully. Thank you!");
        cart.clearCart();
    }
}
