package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.store.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class AddBookToStoreScreenController extends AddItemToStoreScreenController {
    private Book book;
    private ArrayList<String> authors = new ArrayList<>();
    private int numPages;

    @FXML
    private TextField tfAuthors;

    @FXML
    private TextField tfNumPages;

    public AddBookToStoreScreenController(Store store, Cart cart, JFrame stage) {
        super(store, cart, stage);
    }

    @FXML
    @Override
    public void initialize() {
        super.initialize();

        tfNumPages.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                numPages = Integer.parseInt(newValue);
            } catch (NumberFormatException e) {
                numPages = 0;
            }
        });
    }

    @FXML
    private void addAuthorBtnPressed() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Author");
        dialog.setHeaderText("Add a new author");
        dialog.setContentText("Please enter the author's name:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(author -> {
            authors.add(author);
            String authorsList = String.join(", ", authors);
            tfAuthors.setText(authorsList);
        });
    }

    @FXML
    @Override
    protected void addBtnPressed() {
        book = new Book(this.numPages, this.category, this.title, this.cost);
        for (String author : authors) {
            book.addAuthor(author);
        }
        store.addMedia(book);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Book Added");
        alert.setContentText("The book '" + book.getTitle() + "' has been added to the store.");
        alert.showAndWait();
    }
}
