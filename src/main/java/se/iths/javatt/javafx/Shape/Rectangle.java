package se.iths.javatt.javafx.Shape;

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
    public boolean checkInsideShape(double mouseX, double mouseY) {
        return mouseX >= getX() &&
                mouseX <= getX() + getSize() * 1.75 &&
                mouseY >= getY() &&
                mouseY <= getY() + getSize();
    }
    @Override
    public String drawToSVGAsString() {
        String convertColor = getColor().toString().substring(2, 10);
        return "<rect x=\"" + (getX()) + "\" " +
                "y=\"" + (getY() + getSize()) + "\" " +
                "width=\"" + getSize() * 1.75 + "\" " +
                "height=\"" + getSize() + "\" " +
                "fill=\"#" + convertColor + "\" />";
    }

    @Override
    public Shape copyOf() {
        return new Rectangle(getCopyOfParameter());
    }
}



