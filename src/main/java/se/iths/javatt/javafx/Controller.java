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
    public CheckBox selectModeBox;
    public Slider sizeSlider;
    public Canvas canvas;
    public ColorPicker colorPicker;
    public GraphicsContext context;
    public ChoiceBox<ShapeType> choiceBox;
    public Button saveButton;
    public Button undoButton;
    public Button resetCanvasButton;
    public Stage stage;
    //public CheckBox paintBrush;
    ShapeParameter shapeParameter;


    public void initialize() {
        context = canvas.getGraphicsContext2D();

        sizeSlider.valueProperty().bindBidirectional(shapeModel.sizeProperty());
        colorPicker.valueProperty().bindBidirectional(shapeModel.colorProperty());
        choiceBox.valueProperty().bindBidirectional(shapeModel.shapeTypeProperty());
        choiceBox.setItems(shapeModel.getShapeTypeList());


        prepareCanvas();
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        if (selectModeBox.isSelected()) {
            shapeModel.getShapeList().stream()
                    .filter(shape -> shape.checkInsideShape(mouseX, mouseY))
                    .reduce((first, second) -> second)
                    .ifPresent(shape -> shape.updateColorAndSize(shapeModel.getColor(), shapeModel.getSize()));
        } else {
            shapeParameter = new ShapeParameter(mouseX, mouseY, shapeModel.getSize(), shapeModel.getColor());
            shapeModel.getShapeList().add(shapeFactory.getShape(shapeModel.getShapeType(), shapeParameter));
        }
        drawShapes();
        shapeModel.addToUndoStack(shapeModel.getShapeList().get(shapeModel.getLastIndexOfShapeList()));

    }

    public void save() {
        new SVGWriter().saveToFile(shapeModel, stage);
    }

    public void useUndoButton() {
        shapeModel.undo();
        drawShapes();
    }

    private void drawShapes() {
        prepareCanvas();
        shapeModel.getShapeList().forEach(shape -> shape.draw(context));
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }
//                double x = mouseEvent.getX() - (double) shapeModel.getSize() / 2;
//                double y = mouseEvent.getY() - (double) shapeModel.getSize() / 2;
//                context.setFill(colorPicker.getValue());
//                context.fillOval(x, y, (double) shapeModel.getSize(), (double) shapeModel.getSize());
}


