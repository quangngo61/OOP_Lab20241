package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private VBox drawingAreaPane;

    @FXML
    private RadioButton penButton;

    @FXML
    private RadioButton eraserButton;

    @FXML
    private ToggleGroup toolsGroup;

    private Color currentColor = Color.BLACK; // Default to Pen color

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Choose color based on the selected tool
        if (eraserButton.isSelected()) {
            currentColor = Color.WHITE; // Eraser color (background color)
        } else {
            currentColor = Color.BLACK; // Pen color
        }

        // Create a small circle at the mouse position
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Clear the drawing area
        drawingAreaPane.getChildren().clear();
    }
}
