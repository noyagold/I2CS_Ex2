package assignments.Ex2;
import assignments.Ex1.StdDraw;


import java.io.*;



/**
 * Intro2CS_2026A
 * This class represents a Graphical User Interface (GUI) for Map2D.
 * The class has save and load functions, and a GUI draw function.
 * You should implement this class, it is recommender to use the StdDraw class, as in:
 * https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 *
 *
 */

    public class Ex2_GUI {
    public static void drawMap(Map2D map) {
        int c = map.getWidth();
        int r = map.getHeight();
        StdDraw.clear();
        StdDraw.setScale(0.0, 1.0);

        double cellSize = 1.0 / Math.max(c, r);
        double half = cellSize / 2.0; //for fill square

        for (int i = 0; i <r; i++){ //x-rows
            for (int j= 0; j < c; j++) { //y-columns
                int v = map.getPixel(j, i);
                StdDraw.setPenColor(colorByValue(v));
                    double x = (j+ 0.5) * cellSize;
                double y = 1 - (i + 0.5) * cellSize; //upsidedown
                StdDraw.filledSquare(x, y, half);
            }
            }
        StdDraw.show();
    }

    /**
     * @param mapFileName
     * @return
     */
    public static Map2D loadMap(String mapFileName) {
        Map2D ans = null;

            return map;
        }

    /**
     *
     * @param map
     * @param mapFileName
     */
    public static void saveMap(Map2D map, String mapFileName) {

    }

    public static void main(String[] a) {
        String mapFile = "map.txt";
        Map2D map = loadMap("map.txt");
        drawMap(map);
    }


    /// ///////////// Private functions ///////////////

}



