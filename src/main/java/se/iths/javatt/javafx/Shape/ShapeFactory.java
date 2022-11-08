package se.iths.javatt.javafx.Shape;

import se.iths.javatt.javafx.Shape.*;

public class ShapeFactory {
    public Shape getShape(ShapeType shapeType, ShapeParameter parameter) {
        return switch (shapeType) {
            case CIRCLE -> new Circle(parameter);
            case RECTANGLE -> new Rectangle(parameter);

        };
    }
}

