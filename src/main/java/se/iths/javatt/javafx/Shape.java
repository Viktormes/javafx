package se.iths.javatt.javafx;

import javafx.scene.paint.Color;

import java.util.Objects;

abstract class Shape {
    int size;
    Color color;
    double x;
    double y;

    public Shape(int size, Color color, double x, double y) {
        this.size = size;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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
        result = size;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
