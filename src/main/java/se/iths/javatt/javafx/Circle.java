package se.iths.javatt.javafx;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape {
    double radius = getSize() / 2;
    public Circle(ShapeParameter parameter) {
        super(parameter);
    }
    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getX() - radius, getY() - radius, getSize(), getSize());
    }
    @Override
    boolean checkInsideShape(double mouseX, double mouseY) {
        double distX = mouseX - getX();
        double distY = mouseY - getY();
        double distance = Math.sqrt((distX * distX) + (distY * distY));
        return distance <= radius;
    }

}
