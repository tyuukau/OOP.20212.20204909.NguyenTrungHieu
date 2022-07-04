package hust.soict.dsai.javafx;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    private boolean isPen = true;

    @FXML
    private ToggleGroup toggleGroup1;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void penButtonPressed(ActionEvent event) {
        isPen = true;
    }

    @FXML
    void eraserButtonPressed(ActionEvent event) {
        isPen = false;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isPen) {
            drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.BLACK));
        } else {
            drawingAreaPane.getChildren().add(new Circle(event.getX(), event.getY(), 4, Color.WHITE));
        }
    }

}
