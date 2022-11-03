package se.iths.javatt.javafx;

import javafx.scene.canvas.GraphicsContext;


public class Rectangle extends Shape{
    public Rectangle(ShapeParameter parameter) {
        super(parameter);
    }

    @Override
    public void draw(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getX(),getY(),getSize(),getSize());
    }


}
