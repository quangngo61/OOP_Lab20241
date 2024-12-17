package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class AddItemToStoreScreenController {
    protected Store store;
    protected Cart cart;
    private JFrame stage;
    
    protected String title;
    protected String category;
    protected float cost;
    
    @FXML
    protected TextField tfTitle;
    
    @FXML
    protected TextField tfCategory;
    
    @FXML
    protected TextField tfCost;

    // Constructor to initialize the store, cart, and stage (window)
    public AddItemToStoreScreenController(Store store, Cart cart, JFrame stage) {
        super();
        this.store = store;
        this.cart = cart;
        this.stage = stage;
    }

    // Initializes the fields and sets listeners to capture changes from the UI
    @FXML
    public void initialize() {
        
        tfTitle.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                title = newValue;
            }
        });
        
        tfCategory.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                category = newValue;
            }
        });
        
        tfCost.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    Float number = Float.parseFloat(newValue);
                    cost = number;
                } catch (NumberFormatException e) {
                    cost = 0f;  // If invalid input, set cost to 0
                }
            }
        });
    }

    // Redirects to Store Screen when "View Store" button is pressed
    @FXML
    protected void viewStore() {
        new StoreScreen(store);  // Calls the StoreScreen constructor
        stage.hide();  // Hides the current screen (AddItemToStoreScreen)
    }

    // Redirects to Cart Screen when "View Cart" button is pressed
    @FXML
    protected void viewCart() {
        new CartScreen(cart);  // Calls the CartScreen constructor, passing the cart
        stage.hide();  // Hides the current screen (AddItemToStoreScreen)
    }

    // When the button for adding a book is pressed, it opens the "Add Book to Store" screen
    @FXML
    protected void addBookToStore() {
        new AddBookToStoreScreen(store, cart);  // Calls the AddBookToStoreScreen constructor
        stage.hide();  // Hides the current screen
    }

    // When the button for adding a CD is pressed, it opens the "Add CD to Store" screen
    @FXML
    protected void addCDToStore() {
        new AddCDToStoreScreen(store, cart);  // Calls the AddCDToStoreScreen constructor
        stage.hide();  // Hides the current screen
    }

    // When the button for adding a DVD is pressed, it opens the "Add DVD to Store" screen
    @FXML
    protected void addDVDToStore() {
        new AddDVDToStoreScreen(store, cart);  // Calls the AddDVDToStoreScreen constructor
        stage.hide();  // Hides the current screen
    }

    // Abstract method to be implemented by subclasses (such as AddBookToStoreScreenController)
    @FXML
    protected abstract void addBtnPressed();
}
