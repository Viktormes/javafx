package se.iths.javatt.javafx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import static javafx.scene.paint.Color.*;

public class Controller {

    public Slider slider1;
    ShapeModel model = new ShapeModel();
    public Button shapesButton1;
    public Circle circle1;
    public ColorPicker colorChoice;
    public MenuItem menuCircle1;
    public Rectangle rectangle1;
    public MenuItem menuRectangle1;
    public MenuItem menuPolygon1;
    public Polygon triangle1;

    Canvas context = new Canvas();
    public void initialize(){


    }

    @FXML
    protected void onCanvasClicked(MouseEvent mouseEvent){


    }
    @FXML
    protected void onButtonClick(){
        circle1.setVisible(true);circle1.setRadius(Math.random()*100);}
    @FXML
    protected void onRectangleClicked(){ rectangle1.setVisible(true);rectangle1.setFill(colorChoice.getValue());
        rectangle1.setHeight(Math.random()*100);}
    @FXML
    protected void onPolygonClicked(){triangle1.setVisible(true);
        triangle1.setFill(colorChoice.getValue());
        triangle1.setRotate(Math.random()*100);}
    @FXML
    protected void onColorPicked2() { circle1.setFill(colorChoice.getValue());
        circle1.setStroke(colorChoice.getValue());
        rectangle1.setFill(colorChoice.getValue());
        rectangle1.setStroke(colorChoice.getValue());
        triangle1.setFill(colorChoice.getValue());
        triangle1.setStroke(colorChoice.getValue());}
    @FXML
    protected void slideSlider() {circle1.setRadius(slider1.getValue());}
}


