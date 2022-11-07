package se.iths.javatt.javafx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Shape {
    private double size;
    private Color color;
    private final double x;
    private final double y;

    public Shape(ShapeParameter parameter) {
        size = parameter.size();
        color = parameter.color();
        x = parameter.x();
        y = parameter.y();
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(GraphicsContext context);

    public double getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;

        if (size != shape.size) return false;
        if (Double.compare(shape.x, x) != 0) return false;
        if (Double.compare(shape.y, y) != 0) return false;
        return Objects.equals(color, shape.color);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) size;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    abstract boolean checkInsideShape(double mouseX, double mouseY);

    abstract String drawToSVGAsString();

    public void updateColorAndSize(Color color, double size) {
        setColor(color);
        setSize(size);

    }
}



