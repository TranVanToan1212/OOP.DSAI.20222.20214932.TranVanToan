package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.ToggleGroup;

public class PainterController {

    @FXML
    private ToggleGroup identical;
    
    @FXML
    private Pane drawingAreaPane;
    
    private Color color = Color.BLACK;
    private double circleSize = 4;
    
    @FXML
    void penRadioButtonChosen(ActionEvent event) {
    	color = Color.BLACK;
    	circleSize = 4;
    }
    @FXML
    void eraserRadioButtonChosen(ActionEvent event) {
    	color = Color.WHITE;
    	circleSize = 10;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), 
    			event.getY(), circleSize, color);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}


