package se.iths.javatt.javafx;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import se.iths.javatt.javafx.Shape.Circle;
import se.iths.javatt.javafx.Shape.Rectangle;
import se.iths.javatt.javafx.Shape.Shape;
import se.iths.javatt.javafx.Shape.ShapeParameter;

import static org.junit.jupiter.api.Assertions.*;

class ShapeModelTest {


    ShapeModel shapeModel = new ShapeModel();
    ShapeParameter circle = new ShapeParameter(100,150,50, Color.BLUE);
    ShapeParameter rectangle = new ShapeParameter(100,150,30,Color.AQUA);

    Shape fakeCircle = new Circle(circle);
    Shape fakeRectangle = new Rectangle(rectangle);

    private void prepareTheShapeList(){

        shapeModel.addToUndoStack();
        shapeModel.getShapeList().add(fakeCircle);
        shapeModel.addToUndoStack();
        shapeModel.getShapeList().add(fakeRectangle);
    }

    @Test
    void addingToUndoStackAndCallingUndoOnRecentShapeInStack() {
        prepareTheShapeList();
        shapeModel.undo();

        int expected = 1;
        int actual = shapeModel.getShapeList().size();

        assertEquals(expected,actual);
    }
    @Test
    void callingClearShapeListOnTheList(){
        prepareTheShapeList();
        shapeModel.clearShapeList();

        int expected = 0;
        int actual = shapeModel.getShapeList().size();

        assertEquals(expected,actual);

    }
}