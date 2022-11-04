package se.iths.javatt.javafx;

import javafx.scene.canvas.GraphicsContext;


public class Rectangle extends Shape {
    public Rectangle(ShapeParameter parameter) {
        super(parameter);
    }
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getX(), getY(), getSize() * 1.75, getSize());
    }
    @Override
    boolean checkInsideShape(double mouseX, double mouseY) {
        return mouseX >= getX() &&
                mouseX <= getX() + getSize() * 1.75 &&
                mouseY >= getY() &&
                mouseY <= getY() + getSize();
    }
}



