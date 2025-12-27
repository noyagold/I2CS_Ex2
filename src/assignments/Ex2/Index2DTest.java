package assignments.Ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Index2DTest {

    @Test
    //x negative
    public void testGetX() {
        Index2D p = new Index2D(-1, 4);
        assertEquals(-1, p.getX());
    }

    @Test
// getX = 0
    public void testGetX_Zero() {
        Index2D p = new Index2D(0, 5);
        assertEquals(0, p.getX());
    }

    @Test
// getY = 0
    public void testGetY_Zero() {
        Index2D p = new Index2D(7, 0);
        assertEquals(0, p.getY());
    }

    @Test
// normal distance
    public void testDistance2DNormal() {
        Index2D p1 = new Index2D(0, 0);
        Index2D p2 = new Index2D(3, 4);
        assertEquals(5.0, p1.distance2D(p2));
    }




}