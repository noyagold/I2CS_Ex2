package assignments.Ex2;
import assignments.Ex1.StdDraw;

import java.awt.*;
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(mapFileName));//br always wraps another reader

            String line = br.readLine(); //reading starts , first line
            String[] parts = line.trim().split("\\s+");//handles whitespaces and trims space ends

            int height = Integer.parseInt(parts[0]);//transfer height and width (strings) to int
            int width  = Integer.parseInt(parts[1]);

            ans = new Map(width, height, 0); //create object map with taken size(height,width)

            for (int row = 0; row < height; row++) {
                line = br.readLine(); //read next raw
                parts = line.trim().split("\\s+"); //clean it

                for (int col = 0; col < width; col++) {
                    int par = Integer.parseInt(parts[col]); //parse every cell in that raw
                    ans.setPixel(col, row, par);//put par in the map in designated place
                }
            }

            br.close();//close file
            return ans;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param map
     * @param mapFileName
     */
    public static void saveMap(Map2D map, String mapFileName) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(mapFileName)); //prepare converting int to string txt and writing in file

            out.println(map.getHeight() + " " + map.getWidth());//first line is height & width

            for (int row = 0; row < map.getHeight(); row++) { //x
                for (int col = 0; col < map.getWidth(); col++) { //y
                    out.print(map.getPixel(col, row) + " ");
                }
                out.println();//every finished row start lower row
            }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] a) {
        String mapFile = "map.txt";
        Map2D map = loadMap("map.txt");
        drawMap(map);
    }


    /// ///////////// Private functions ///////////////
    private static Color colorByValue(int v) {
        if (v == -1) {
            return Color.BLACK;   //obs
        }
        return Color.WHITE;       // free space
    }
}



