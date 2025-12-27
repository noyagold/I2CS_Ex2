package assignments.Ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Index2DTest {

    @Test
    public void testGetX() {
        Index2D p = new Index2D(3, 4);
        assertEquals(3, p.getX());
    }
}