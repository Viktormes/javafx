package se.iths.javatt.javafx;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import se.iths.javatt.javafx.Shape.Shape;
import se.iths.javatt.javafx.Shape.ShapeType;

import java.util.ArrayDeque;
import java.util.Deque;

import static javafx.collections.FXCollections.observableArrayList;


public class ShapeModel {
    private final ObservableList<Shape> shapeList;
    private final ObjectProperty<Color> color;
    private final ObjectProperty<Number> size;

    private final ObservableList<ShapeType> shapeTypeList;
    private final ObjectProperty<ShapeType> currentShapeType;
    private final Deque<Command> shapeUndoStack;


    public ShapeModel() {
        shapeUndoStack = new ArrayDeque<>();
        color = new SimpleObjectProperty<>(Color.BISQUE);
        size = new SimpleObjectProperty<>(50.0);
        shapeList = FXCollections.observableArrayList();
        currentShapeType = new SimpleObjectProperty<>(ShapeType.CIRCLE);
        shapeTypeList = FXCollections.observableList(observableArrayList(ShapeType.values()));
    }

    public ObservableList<Shape> getShapeList() {
        return shapeList;
    }


    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }


    public double getSize() {
        return (double) size.get();
    }

    public ObjectProperty<Number> sizeProperty() {
        return size;
    }


    public ShapeType getShapeType() {
        return currentShapeType.get();
    }

    public ObjectProperty<ShapeType> shapeTypeProperty() {
        return currentShapeType;
    }


    public ObservableList<ShapeType> getShapeTypeList() {
        return shapeTypeList;
    }


    public void addToUndoStack() {
        ObservableList<Shape> tempList = deepCopyOfList();
        Command undo = () -> {
            getShapeList().clear();
            getShapeList().addAll(tempList);
        };
        shapeUndoStack.push(undo);

    }

    public ObservableList<Shape> deepCopyOfList() {
        ObservableList<Shape> tempList = FXCollections.observableArrayList();

        for (Shape shape : shapeList) {
            tempList.add(shape.copyOf());
        }
        return tempList;
    }

    @FunctionalInterface
    interface Command {
        void execute();
    }

    public void undo() {
        Command undoToExecute = shapeUndoStack.pop();
        undoToExecute.execute();

    }


    public void clearShapeList() {
        getShapeList().clear();
    }


}
