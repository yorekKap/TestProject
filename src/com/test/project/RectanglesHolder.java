package com.test.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuri on 29.07.17.
 */
public class RectanglesHolder {
    private static final int DEFAULT_RECTANGLES_PER_AREA = 1000;

    Map<Rectangle, List<Rectangle>> rectangleAreas;


    public RectanglesHolder(int numOfRectangles){
        init(numOfRectangles);
    }

    private void init(int numOfRectangles) {
        RandomRectanglesGenerator randomRectanglesGenerator = new RandomRectanglesGenerator();
        rectangleAreas = randomRectanglesGenerator.generate(numOfRectangles, DEFAULT_RECTANGLES_PER_AREA);
    }

    private Rectangle findRectanglWithDotWithin(Dot dot){
        for(Map.Entry<Rectangle, List<Rectangle>> entry : rectangleAreas.entrySet()){
            if(entry.getKey().isDotWithinRectangle(dot)){
                return entry.getValue().stream()
                        .filter(x -> x.isDotWithinRectangle(dot))
                        .findAny()
                        .orElseThrow(() -> new RectangleNotFoundException());
            }
        }

        throw new RectangleNotFoundException();
    }
}
