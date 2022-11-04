package se.iths.javatt.javafx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayDeque;
import java.util.Deque;

import static javafx.collections.FXCollections.observableArrayList;


public class ShapeModel {
    private ObservableList<Shape> shapeList;
    private final ObjectProperty<Color> color;
    private final ObjectProperty<Number> size;

    private ObservableList<ShapeType> shapeTypeList;
    private final ObjectProperty<ShapeType> currentShapeType;
    private Deque<Command> shapeUndoStack;


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

    public void setShapeList(ObservableList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public double getSize() {
        return (double) size.get();
    }

    public ObjectProperty<Number> sizeProperty() {
        return size;
    }

    public void setSize(Number size) {
        this.size.set(size);
    }

    public ShapeType getShapeType() {
        return currentShapeType.get();
    }

    public ObjectProperty<ShapeType> shapeTypeProperty() {
        return currentShapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.currentShapeType.set(shapeType);
    }

    public ObservableList<ShapeType> getShapeTypeList() {
        return shapeTypeList;
    }

    public void setShapeTypeList(ObservableList<ShapeType> shapeTypeList) {
        this.shapeTypeList = shapeTypeList;
    }

    public void addToUndoStack(Shape shape) {
        Command undo = () -> getShapeList().remove(shape);
        shapeUndoStack.push(undo);

    }

    @FunctionalInterface
    interface Command {
        void execute();
    }

    public void undo() {
        Command undoToExecute = shapeUndoStack.pop();
        undoToExecute.execute();

    }

    public int getLastIndexOfShapeList() {
        return getShapeList().size() - 1;

    }

    public void clearShapeList() {
        getShapeList().clear();
    }

}
