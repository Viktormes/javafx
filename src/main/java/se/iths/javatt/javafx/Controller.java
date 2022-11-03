package se.iths.javatt.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import static javafx.collections.FXCollections.observableArrayList;


public class Controller {

    ShapeFactory shapeFactory = new ShapeFactory();
    ShapeModel shapeModel = new ShapeModel();

    public static final int MAX_WIDTH = 2200;
    public static final int MAX_HEIGHT = 1100;

    public Slider sizeSlider;
    public Canvas canvas;
    public ColorPicker colorPicker;
    public GraphicsContext context;
    public ChoiceBox<ShapeType> choiceBox;
    public Button saveButton;
    public Button undoButton;
    public Button resetCanvasButton;
    private Stage stage;
    public CheckBox paintBrush;
    ShapeParameter shapeParameter;



    public void initialize(){
        context = canvas.getGraphicsContext2D();

        sizeSlider.valueProperty().bindBidirectional(shapeModel.sizeProperty());
        colorPicker.valueProperty().bindBidirectional(shapeModel.colorProperty());
        choiceBox.valueProperty().bindBidirectional(shapeModel.shapeTypeProperty());
        choiceBox.setItems(shapeModel.getShapeTypeList());


        prepareCanvas();
    }
    public void canvasClicked(MouseEvent mouseEvent) {
        if (paintBrush.isSelected())
            paintBrush();

        shapeParameter = new ShapeParameter(mouseEvent.getX(), mouseEvent.getY(), (Double) shapeModel.getSize(),shapeModel.getColor());
        shapeModel.getShapeList().add(shapeFactory.getShape(shapeModel.getShapeType(),shapeParameter));
        shapeModel.getShapeList().forEach(shape -> shape.draw(context));


    }



    private void drawShapes(GraphicsContext context) {
        for (var Shape : shapeModel.getShapeList()) {
            Shape.draw(context);
        }
    }
    @FXML
    protected double sizeSlider() {
        return sizeSlider.getValue();
    }
    private void prepareCanvas() {
        context.setFill(Paint.valueOf("WHITE"));
        context.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
    }

    public void resetCanvasNow() {
        context.restore();
        shapeModel.clearShapeList();
        prepareCanvas();

    }

    private void paintBrush() {
        canvas.setOnMouseDragged(mouseEvent -> {
            double x = mouseEvent.getX() - (double)shapeModel.getSize() / 2;
            double y = mouseEvent.getY() - (double)shapeModel.getSize() / 2;
            context.setFill(colorPicker.getValue());
            context.fillOval(x, y, (double) shapeModel.getSize(),(double) shapeModel.getSize());
        });
    }
}


