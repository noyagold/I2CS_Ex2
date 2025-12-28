package assignments.Ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Intro2CS, 2026A, this is a very.
 */
class MapTest {
    /**
     */
    private int[][] map_m0 = {{0,1,2}, {5,6,7}, {10,11,12}};
    private int[][] map_m1 = {{0,1,2}, {5,6,7}, {10,11,12}};
    private int[][] _map_3_3 = {{0,1,0}, {1,0,1}, {0,1,0}};
    private int[][] map_0 = {{0}};
    private int[][] map_vals = {{1, 2, 3}, {4, 5, 6}};
    private int[][] map_obs = {{0, -1, 0}, {0, -1, 0}, {0,  0, 0}};
    private int[][] map_null = null;
    private int[][] map_empty_row = {{}};

    private Map2D _m0, _m1, _m3_3;
    private Map2D _one, _vals, _obs;
    @BeforeEach
    public void setup() {
        _m0 = new Map(map_m0);
        _m1 = new Map(map_m1);
        _m3_3 = new Map(_map_3_3);
        _one = new Map(map_0);
        _vals = new Map(map_vals);
        _obs = new Map(map_obs);


    }
    @Test
    @Timeout(value = 1, unit = SECONDS)
    void init() {
        int[][] bigarr = new int [500][500];
        _m1.init(bigarr);
        assertEquals(bigarr.length, _m1.getWidth());
        assertEquals(bigarr[0].length, _m1.getHeight());
        Pixel2D p1 = new Index2D(3,2);
        _m1.fill(p1,1, true);
    }

    @Test
    void testInit() {
        _m0.init(_map_3_3);
        _m1.init(_map_3_3);
        assertEquals(_m0, _m1);
    }
    @Test
    void testEquals() {
        assertEquals(_m0,_m1);
        _m0.init(_map_3_3);
        _m1.init(_map_3_3);
        assertEquals(_m0,_m1);
    }

    //should throw RuntimeException on null input.
    @Test
    void testInit_NullArray() {
        assertThrows(RuntimeException.class, () -> {
            _m0.init(map_null);
        });
    }

    //should throw RuntimeException on empty row.
    @Test
    void testInit_EmptyRow() {
        assertThrows(RuntimeException.class, () -> {
            _m0.init(map_empty_row);
        });
    }



    //same Diminutions
    @Test
    void testGetMap() {
        int[][] a = _m3_3.getMap();
        assertEquals(3, a.length);
        assertEquals(3, a[0].length);
    }


    @Test
    void testGetMap_DeepCopy() {
        int[][] copy = _m0.getMap();
        _m0.setPixel(0, 0, 999);// change the original map
        assertEquals(0, copy[0][0]); // copy must stay with the old value
        assertEquals(999, _m0.getPixel(0, 0)); // and original changed
    }


        @Test
    void testGetWidth() {
        assertEquals(3, _m3_3.getWidth());
    }

    @Test
    void testGetHeight() {
        assertEquals(3, _m3_3.getHeight());
    }

    @Test
    void testGetPixelXY() {
        assertEquals(1, _m3_3.getPixel(1,0));
    }

    @Test
    void testGetPixelP() {
        Pixel2D p = new Index2D(1,0);
        assertEquals(1, _m3_3.getPixel(p));
    }



}