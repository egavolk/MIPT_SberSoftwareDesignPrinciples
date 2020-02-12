package edu.phystech.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShapeTest {

    private final double EPS = 1e-9;

    @Test
    public void testRectangle() {
        Rectangle rectangle = new Rectangle(6, 7);
        Assert.assertEquals(42, rectangle.countArea(), EPS);
    }

    @Test
    public void testSquare() {
        Square square = new Square(5);
        Assert.assertEquals(25, square.countArea(), EPS);
    }

    @Test
    public void testCircle() {
        Circle circle = new Circle(5);
        Assert.assertEquals(25 * Math.PI, circle.countArea(), EPS);
    }

    @Test
    public void testAllShapesSum() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(6, 7));
        shapes.add(new Square(5));
        shapes.add(new Circle(5));

        double sumArea = 0;
        for (Shape shape : shapes) {
            sumArea += shape.countArea();
        }
        Assert.assertEquals(67 + 25 * Math.PI, sumArea, EPS);
    }
}