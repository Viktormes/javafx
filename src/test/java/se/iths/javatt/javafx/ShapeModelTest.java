package se.iths.javatt.javafx;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeModelTest {


    ShapeModel shapeModel = new ShapeModel();
    ShapeFactory shapeFactory = new ShapeFactory();
    ShapeParameter circle = new ShapeParameter(100,150,50, Color.BLUE);
    ShapeParameter rectangle = new ShapeParameter(100,150,30,Color.AQUA);

    Shape fakeCircle = new Circle(circle);
    Shape fakeRectangle = new Rectangle(rectangle);

    private void prepareTheShapeList(){

        shapeModel.getShapeList().add(fakeCircle);
        shapeModel.getShapeList().add(fakeRectangle);
    }

    @Test
    void seeIfGetShapeListWorksAsIntended() {
        prepareTheShapeList();

        int expected = 2;
        int actual = shapeModel.getShapeList().size();
        assertEquals(expected,actual);
    }
    @Test
    void seeIfClearShapeListWorksAsIntended(){
        prepareTheShapeList();
        shapeModel.clearShapeList();

        int expected = 0;
        int actual = shapeModel.getShapeList().size();

        assertEquals(expected,actual);

    }
}