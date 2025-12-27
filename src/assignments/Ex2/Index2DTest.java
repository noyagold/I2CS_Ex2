package assignments.Ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Index2DTest {

    @Test
    public void testGetX() {
        Index2D p = new Index2D(3, 4);
        assertEquals(3, p.getX());
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
}