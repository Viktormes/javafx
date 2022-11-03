package se.iths.javatt.javafx;

import javafx.scene.paint.Color;

import java.util.Objects;

public record ShapeParameter(double x, double y, double size, Color color) {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapeParameter that = (ShapeParameter) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.size, size) != 0) return false;
        return Objects.equals(color, that.color);
    }

    @Override
    public String toString() {
        return "ShapeParameter{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                ", color=" + color +
                '}';
    }
}
