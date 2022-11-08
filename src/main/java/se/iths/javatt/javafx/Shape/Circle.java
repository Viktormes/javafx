package se.iths.javatt.javafx.Shape;

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
    public boolean checkInsideShape(double mouseX, double mouseY) {
        double distX = mouseX - getX();
        double distY = mouseY - getY();
        double distance = Math.sqrt((distX * distX) + (distY * distY));
        return distance <= radius;
    }

    @Override
    public String drawToSVGAsString() {
        String convertColor = "#" + getColor().toString().substring(2, 10);
        return "<circle cx=\"" + getX() + "\" " +
                "cy=\"" + getY() + "\" " +
                "r=\"" + radius + "\" " +
                "fill=\"" + convertColor + "\" />";
    }

    @Override
    public Shape copyOf() {
        return new Circle(getCopyOfParameter());
    }
}
