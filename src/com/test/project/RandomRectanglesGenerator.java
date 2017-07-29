package com.test.project;

import java.util.*;

/**
 * Created by yuri on 29.07.17.
 */
public class RandomRectanglesGenerator {

    private Random rand = new Random();
    private Dot leftLowerDot = new Dot(0, 0);
    private Dot rightUpperDot = new Dot(0, 0);


    public Map<Rectangle, List<Rectangle>> generate(int numOfRectangles, int rectanglesPerArea){
        Map<Rectangle, List<Rectangle>> rectangleAreas = new HashMap<>();

        List<Rectangle> rectangles;
        for(int i = 0; i < numOfRectangles; i++){
            for(int j = 0; j < rectanglesPerArea; i++){
                rectangles = new ArrayList<>();
                rectangles.add(generateRectangle());

                rectangleAreas.put(new Rectangle(leftLowerDot, rightUpperDot.getX() - leftLowerDot.getX(),
                        rightUpperDot.getY() - leftLowerDot.getY()), rectangles);
            }
        }

        return rectangleAreas;
    }

    private Rectangle generateRectangle(){
        double width = doubleInRange(1, 10);
        double height = doubleInRange(1, 10);

        int side = rand.nextInt(4);

        Dot rectangleLocation = null;
        double x = 0;
        double y = 0;
        switch (side){
            case 0 : rectangleLocation = new Dot(leftLowerDot.getX() - 12, rightUpperDot.getY());
            leftLowerDot.setX(leftLowerDot.getX() - 12);
            break;
            case 1 : rectangleLocation = new Dot(leftLowerDot.getX(), rightUpperDot.getY() + 2);
            rightUpperDot.setY(rightUpperDot.getY() + 12);
            break;
            case 2 : rectangleLocation = new Dot(rightUpperDot.getX() + 2, leftLowerDot.getY());
            rightUpperDot.setX(rightUpperDot.getX() + 12);
            break;
            case 3 : rectangleLocation = new Dot(leftLowerDot.getX(), leftLowerDot.getY() - 12);
            leftLowerDot.setY(leftLowerDot.getY() - 12);
            break;
            default: throw new IllegalStateException("Default shouldn't be reached");
        }

        return new Rectangle(rectangleLocation, width, height);
    }

    private double doubleInRange(double rangeMin, double rangeMax){
        double randomValue = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();

        return randomValue;
    }
}
