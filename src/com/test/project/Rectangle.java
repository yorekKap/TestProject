package com.test.project;

/**
 * Created by yuri on 29.07.17.
 */
public class Rectangle {
    private Dot location;
    private double width;
    private double height;

    public Rectangle(Dot location, double width, double height) {
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public Dot getLocation() {
        return location;
    }

    public void setLocation(Dot location) {
        this.location = location;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isDotWithinRectangle(Dot dot){
        return location.getX() < dot.getX() && location.getY() < dot.getY() &&
                dot.getX() < location.getX() + width &&
                dot.getY() < location.getY() + height;
    }
}
