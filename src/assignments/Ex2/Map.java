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
    private int[][] map;
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

    /**
     * Initializes the map with the given width and height,
     * and fills all cells with the same initial value.
     */

	@Override
	public void init(int w, int h, int v) {

        this.map = new int[h][w];   //creating  a new array
        for (int i = 0; i < h; i++){      // iterating on the entire 2D array
            for(int j = 0; j < w; j++){
                this.map[i][j]=v;           //inputting v in each index
            }
        }
	}
    /**
     * Initializes the map from a given 2D array.
     * Checks that the array is valid and not ragged,
     * and copies its values into the map.
     */

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

        this.map = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) { //copies map to array
            for (int j = 0; j < arr[i].length; j++) {
                this.map[i][j] = arr[i][j];
            }
        }


	}

    /**
     * I return a deep copy of the map so external code
     * cannot change my internal matrix directly.
     */
	@Override
	public int[][] getMap() {
		int[][] ans = new int [this.map.length][this.map[0].length];   //creating a new copy matrix of map with same size

        for (int i = 0; i<this.map.length; i++){ //copies the cells of the matrix
            for (int j = 0; j<this.map[0].length; j++){
                ans[i][j]=this.map[i][j];
            }
        }

		return ans;
	}


    /**
     * I return the number of columns by using the first row length,
     */
	@Override
	public int getWidth() {
        int ans = this.map [0].length;   // map's rows are identical --> the same width for all

        return ans;
    }

    /**
     * I return the number of rows in the map.
     */

    @Override
	public int getHeight() {
        int ans = this.map.length;

        return ans;
    }

    /**
     * I access the value directly from the internal array
     * using map[y][x].
     */

    @Override
	public int getPixel(int x, int y) {
        int ans = this.map[y][x];

        return ans;
    }

    /**
     * I extract the x and y values from the Pixel2D
     * and then read the value from the map.
     */

    @Override
	public int getPixel(Pixel2D p) {
       int x =  p.getX();      //getting x
       int y =  p.getY();      //getting y
        int ans = this.map[y][x];   //value of the cell (x,y)

        return ans;
	}

    /**
     * I update the value of the given cell directly in the matrix.
     */

    @Override
	public void setPixel(int x, int y, int v) {
        this.map[y][x] = v;
    }

    /**
     * I use the coordinates from the Pixel2D object
     * to update the value in the map.
     */

    @Override
	public void setPixel(Pixel2D p, int v) {
      this.map[p.getY()][p.getX()] = v;
	}

    /**
     * I check that both x and y are inside the valid ranges
     * of the map dimensions.
     */

    @Override
    public boolean isInside(Pixel2D p) {
        boolean ans = true;
        int x = p.getX();
        int y = p.getY();
        if (0<=x && x<this.map[0].length && 0<=y && y<this.map.length) { //looking if the x and y are in the ranges of the p's matrix
            return ans;
        }else {
            return false;
        }


    }

    /**
     * I compare the width and height of both maps
     * to make sure they have the same dimensions.
     */

    @Override
    public boolean sameDimensions(Map2D p) {
        boolean ans = false;
        if(this.map.length==p.getHeight() && this.map[0].length==p.getWidth()){  //checks if the map's size is equal to p's size
            return true;
        }
        return ans;
    }

    @Override
    public void addMap2D(Map2D p) {
        if(this.sameDimensions(p)) {
            for (int i = 0; i < p.getHeight(); i++) { //i=y
                for (int j = 0; j < p.getWidth(); j++) {//j=x
                    this.map[i][j] = p.getPixel(j, i) + this.map[i][j];
                }
            }
        }
    }

    @Override
    public void mul(double scalar) {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
               this.map[i][j] =(int) (this.map[i][j] * scalar); //changes the values
            }

        }

    }

    @Override
    public void rescale(double sx, double sy) {
        int newHeight =(int)(this.getHeight()*sy);
        int newWidth =(int)(this.getWidth()*sx);

        int[][] newMap = new int[newHeight][newWidth];

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                int oldY = (int)(i/sy);
                int oldX = (int)(j/sx);
                oldY= Math.min(oldY, this.getHeight()-1); //so if it goes from big to small size it would choose the existing index
                oldX= Math.min(oldX, this.getWidth()-1);
                newMap[i][j] = this.map[oldY][oldX];
            }
        }
        this.map = newMap;
    }

    @Override
    public void drawCircle(Pixel2D center, double rad, int color) {
        int h = this.getHeight();
        int w = this.getWidth();
        int Xc = center.getX();
        int Yc = center.getY();

        for (int i = 0; i<h; i++){//i=y
            for (int j = 0; j<w; j++){//j=x
                Pixel2D p= new Index2D(j,i);
                double distance =center.distance2D(p);
                if(distance<rad){this.setPixel(p,color);}
            }
        }

    }

    @Override
    public void drawLine(Pixel2D p1, Pixel2D p2, int color) {
        int dx= Math.abs(p1.getX() - p2.getX());//distance x.p1-->x.p2
        int dy= Math.abs(p1.getY() - p2.getY());//distance y.p1-->y.p2
        int x1 = p1.getX(), y1 = p1.getY();
        int x2 = p2.getX(), y2 = p2.getY();

        if (p1.equals(p2)) { //first condition
            this.setPixel(p1, color);
            return; //early leave
        }

        if (dx >= dy && p1.getX() < p2.getX()) {//second condition
            double m= (double)(y2 - y1)/(double)(x2 - x1);
            double b= y1 - m*x1;

            for (int x = x1; x <= x2; x++) {
                int y = (int)Math.round(m * x + b);
                this.setPixel(new Index2D(x, y), color);
            }
            return;
        }

        if(dx>=dy && p1.getX()>p2.getX()){//third condition
            drawLine(p2, p1, color);
            return;
        }

        if (dx < dy && y1 < y2) {//4th condition
            double m2= (double)(x2 - x1)/(double)(y2 - y1);
            double b2 = x1- m2 * y1;

            for (int y = y1; y<= y2; y++) {
                int x = (int)Math.round(m2*y+b2);
                this.setPixel(new Index2D(x, y), color);
            }
            return;
        }
        if(dx<dy && y1>y2) {//fifth condition
            drawLine(p2, p1, color);
            return;
        }



    }

    @Override
    public void drawRect(Pixel2D p1, Pixel2D p2, int color) {
        int minX = Math.min(p1.getX(), p2.getX());
        int maxX = Math.max(p1.getX(), p2.getX());
        int minY = Math.min(p1.getY(), p2.getY());
        int maxY = Math.max(p1.getY(), p2.getY());

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
             this.setPixel(x, y, color); //get color in the cells
            }
        }

    }

    @Override
    public boolean equals(Object ob) {
        boolean ans = true;
        if (!(ob instanceof Map2D)) { //ob is not a map (Map2D)
            return false;}

            Map2D other = (Map2D) ob;//declare ob(other) as from Map2D

            if (!this.sameDimensions(other)){ //check if ob(other) and map have same dimensions
                return false;
        }
            for (int y= 0; y<this.getHeight(); y++) {//every index's value checked if equal
                for (int x= 0; x<this.getWidth(); x++) {
                    if (this.getPixel(x, y) != other.getPixel(x, y)) {
                        return false;
                    }
                }
            }
        return ans;
    }
	@Override
	/** 
	 * Fills this map with the new color (new_v) starting from p.
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public int fill(Pixel2D xy, int new_v,  boolean cyclic) {
		int ans = -1;
        if(!isInside(xy)){ //is point inside map
            return 0;
        }

        int old_v = getPixel(xy);//save old color
         if (old_v == new_v) { //no switched color
             return 0;
         }

        java.util.ArrayDeque<Pixel2D> q = new java.util.ArrayDeque<Pixel2D>();// queue for BFS
        q.add(new Index2D(xy)); //add the stating pixel
        setPixel(xy, new_v);//mark start
        ans = 1;

        int[] dx = { 1, -1, 0, 0 };//setting the 4 possible directions
        int[] dy = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            Pixel2D cur = q.removeFirst();// take the next pixel from the queue

            for (int i = 0; i < 4; i++) {
                Pixel2D nei = neighbor(cur, dx[i], dy[i], cyclic);
                if (nei != null && getPixel(nei) == old_v) { // if neighbor exists and has the old color – add it to queue
                    setPixel(nei, new_v);//mark
                    q.addLast(nei);
                    ans++;
                }
            }
        }
        return ans;
	}



	@Override
	/**
	 * BFS like shortest the computation based on iterative raster implementation of BFS, see:
	 * https://en.wikipedia.org/wiki/Breadth-first_search
	 */
	public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor, boolean cyclic) {
		Pixel2D[] ans = null;  // the result.
        if (!isInside(p1) || !isInside(p2)) {//p1 & p2 in map
            return ans;
        }
        if (getPixel(p1)==obsColor || getPixel(p2)==obsColor)  {//if the value of p1 or p2 is on an obs
            return ans;
        }
        if (p1.equals(p2)) {
            return new Pixel2D[]{ new Index2D(p1) };
        }
        int w= this.getWidth();
        int h = this.getHeight();

        boolean[][] visited = new boolean[h][w];//helping to check if a p has been visited
        Pixel2D[][] start = new Pixel2D[h][w]; //to remember the path

        java.util.ArrayDeque<Pixel2D> queue = new java.util.ArrayDeque<Pixel2D>(); //Creates an empty queue of pixels for BFS
        queue.addLast(new Index2D(p1.getX(), p1.getY())); //putting the starting point (p1) in the que
        visited[p1.getY()][p1.getX()] = true; //visit check
        start[p1.getY()][p1.getX()] = null; //the path of p1 is null

        int[] dx = { 1, -1, 0, 0 };//setting the 4 possible directions
        int[] dy = { 0, 0, 1, -1 };

        boolean found = false;

        while (!queue.isEmpty()&& !found) {//as long as the que is not empty
            Pixel2D cur = queue.removeFirst(); //remove the first pixel

            for (int i = 0; i < 4; i++) {//check the 4 directions
            Pixel2D next = neighbor(cur, dx[i], dy[i], cyclic); //finding neighbor
            if (next == null) continue; //if theres no pixel neighbor -->nul

            int nx = next.getX();//getting x,y from neighbor
            int ny = next.getY();
            if (visited[ny][nx]) continue; //if we visited it continue
            if (getPixel(next) == obsColor) continue;// if the neib is an obs continue

            visited[ny][nx] = true;//marked as checked
            start[ny][nx] = cur;//save the path from where we got to neib
            queue.addLast(next); //add neib to que
            if (next.equals(p2)) { // found target
                found=true; // stop BFS.
                break;}
        }
        }

        if (!visited[p2.getY()][p2.getX()]) {//if not arrived to p2 -->null
            return null;
        }
        ans = buildPath(start, p2);//activating build Path

            return ans;
	}
    @Override
    public Map2D allDistance(Pixel2D start, int obsColor, boolean cyclic) {
        Map2D ans = null;  // the result.
        if (!isInside(start)) {//start in the map
            throw new RuntimeException(); }
        int w = this.getWidth();
        int h = this.getHeight();
        ans = new Map(w, h, -1); //implementing the new map with values -1

        if (getPixel(start) == obsColor) { //if the pixel start is on an obs
            return ans;
        }
        ans.setPixel(start, 0); //starting point is distance 0
        java.util.ArrayDeque<Pixel2D> q = new java.util.ArrayDeque<Pixel2D>(); //Creates an empty queue of pixels for BFS
        q.add(new Index2D(start));//a copy of the starting point in the que
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //array representing directions

        while(!q.isEmpty()) { //as long as there pixels in the que
            Pixel2D cur = q.removeFirst(); //getting out the next pixel current one working on
            int d = ans.getPixel(cur); //the dis of the current pixel from start

            for (int i = 0; i < directions.length; i++) {
                Pixel2D nei = neighbor(cur, directions[i][0], directions[i][1], cyclic); // get the neighbor of the current pixel using the directions array
                if (nei == null) { //no neighbor
                    continue;
                }
                if (getPixel(nei) == obsColor) { //obs
                    continue;
                }
                if (ans.getPixel(nei) != -1) {//visited
                    continue;
                }
                ans.setPixel(nei, d + 1); //add 1 to distance
                q.add(nei); //add neib so neib will be handled afterwards
            }
        }
        return ans;
    }


	////////////////////// Private Methods ///////////////////////

    /**
     * Returns the neighboring pixel of the current pixel in the given direction.
     * If the map is cyclic, the neighbor wraps around the map boundaries.
     * @param cur the current pixel.
     * @param dx movement direction on the x axis.
     * @param dy movement direction on the y axis.
     * @param cyclic indicates whether the map is cyclic.
     * @return the neighbor pixel, or null if out of bounds and not cyclic.
     */
   private Pixel2D neighbor(Pixel2D cur, int dx, int dy, boolean cyclic) {
       int w= this.getWidth();
       int h = this.getHeight();

       int nx = cur.getX() + dx;//finding right and left neighbors
       int ny = cur.getY() + dy;

      if(cyclic){ //if the map is cyclic
        if(nx<0) nx=w-1; //got to left side move to the right
        if(ny<0) ny=h-1;//got to bottom  move to the upper side
        if(nx>=w) nx=0; //got to the right side move to the left
        if(ny>=h) ny=0;//got to upper side move to the bottom
        return new Index2D(nx, ny);
    }
        if(nx<0 || ny<0 || ny>=h|| nx>=w) {//if not cyclic overflow means no neighbor
            return null;
        }

    return new Index2D(nx, ny);//returns the neib
    }


    /**
     * Builds the path from the start pixel to the end pixel using backtracking.
     * @param start a matrix that stores the previous pixel for each position.
     * @param end the destination pixel.
     * @return an array of pixels representing the path from start to end.
     */

   private Pixel2D[] buildPath(Pixel2D[][] start, Pixel2D end) {
       java.util.ArrayList<Pixel2D> rev = new java.util.ArrayList<Pixel2D>();
       Pixel2D cur = new Index2D(end.getX(), end.getY()); //starting from end
       while (cur != null) {//as long as cur is not null
           rev.add(cur); //add cur
           cur = start[cur.getY()][cur.getX()];
       }
           Pixel2D[] path = new Pixel2D[rev.size()];
           for (int i = 0; i < rev.size(); i++) {//filling the array from end to finish
               path[i] = rev.get(rev.size() - 1 - i);
     }
       return path;
    }
}





