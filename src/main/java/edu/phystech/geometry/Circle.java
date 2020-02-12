package edu.phystech.geometry;

public class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public double countArea() {
        return Math.PI * r * r;
    }
}
