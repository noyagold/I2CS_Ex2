package assignments.Ex2;
import java.io.Serializable;
/**
 * This class represents a 2D map (int[w][h]) as a "screen" or a raster matrix or maze over integers.
 * This is the main class needed to be implemented.
 *
 * @author boaz.benmoshe
 *
 */
public class Map implements Map2D, Serializable{

    // edit this class below
	/**
	 * Constructs a w*h 2D raster map with an init value v.
	 * @param w the width of the underlying 2D array.
	 * @param h the height of the  underlying 2D array.
	 * @param v the init value of all the entries in the 2D array.
	 */
	public Map(int w, int h, int v) {init(w, h, v);}
	/**
	 * Constructs a square map (size*size).
	 * @param size
	 */
	public Map(int size) {this(size,size, 0);}
	
	/**
	 * Constructs a map from a given 2D array.
	 * @param data
	 */
	public Map(int[][] data) {
		init(data);
	}

    private int[][] map;
	@Override
	public void init(int w, int h, int v) {

        map = new int[h][w];   //creating  a new array
        for (int i = 0; i < h; i++){      // iterating on the entire 2D array
            for(int j = 0; j < w; j++){
                map[i][j]=v;           //inputting v in each index
            }
        }
	}
	@Override
	public void init(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {              //null and empty columns exceptions
            throw new RuntimeException();
        }

        for (int i = 1; i < arr.length; i++) {            //checks if each array has the same length (not ragged)
            if (arr[0].length != arr[i].length) {
                throw new RuntimeException();
            }
        }


	}
	@Override
	public int[][] getMap() {
		int[][] ans = new int [map.length][map[0].length];   //creating a new copy matrix of map with same size

        for (int i = 0; i<map.length; i++){ //copies the cells of the matrix
            for (int j = 0; j<map[0].length; j++){
                ans[i][j]=map[i][j];
            }
        }

		return ans;
	}
	@Override
	public int getWidth() {
        int ans = map [0].length;   // map's rows are identical --> the same width for all

        return ans;
    }
	@Override
	public int getHeight() {
        int ans = map.length;

        return ans;
    }
	@Override
	public int getPixel(int x, int y) {
        int ans = map[y][x];

        return ans;
    }
	@Override
	public int getPixel(Pixel2D p) {
       int x =  p.getX();      //getting x
       int y =  p.getY();      //getting y
        int ans = map[y][x];   //value of the cell (x,y)

        return ans;
	}
	@Override
	public void setPixel(int x, int y, int v) {

    }
	@Override
	public void setPixel(Pixel2D p, int v) {

	}

    @Override
    public boolean isInside(Pixel2D p) {
        boolean ans = true;

        return ans;
    }

    @Override
    public boolean sameDimensions(Map2D p) {
        boolean ans = false;

        return ans;
    }

    @Override
    public void addMap2D(Map2D p) {

    }

    @Override
    public void mul(double scalar) {

    }

    @Override
    public void rescale(double sx, double sy) {

    }

    @Override
    public void drawCircle(Pixel2D center, double rad, int color) {

    }

    @Override
    public void drawLine(Pixel2D p1, Pixel2D p2, int color) {

    }

    @Override
    public void drawRect(Pixel2D p1, Pixel2D p2, int color) {

    }

    @Override
    public boolean equals(Object ob) {
        boolean ans = false;

        return ans;
    }
	@Override
	/** 
	 * Fills this map with the new color (new_v) starting from p.
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public int fill(Pixel2D xy, int new_v,  boolean cyclic) {
		int ans = -1;

		return ans;
	}

	@Override
	/**
	 * BFS like shortest the computation based on iterative raster implementation of BFS, see:
	 * https://en.wikipedia.org/wiki/Breadth-first_search
	 */
	public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor, boolean cyclic) {
		Pixel2D[] ans = null;  // the result.

		return ans;
	}
    @Override
    public Map2D allDistance(Pixel2D start, int obsColor, boolean cyclic) {
        Map2D ans = null;  // the result.

        return ans;
    }
	////////////////////// Private Methods ///////////////////////

}
