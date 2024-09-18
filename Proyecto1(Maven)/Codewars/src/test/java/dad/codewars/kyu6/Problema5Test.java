package dad.codewars.kyu6;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Problema5Test {

    public Problema5 problema5;

    @Before
    public void setUp() {

        problema5 = new Problema5();
    }

    @Test
    public  void testProblema5() {
        assertEquals(23, Problema5.problema5(10));

        assertEquals(0, Problema5.problema5(0));

        assertEquals(0, Problema5.problema5(2));

        assertEquals(78, Problema5.problema5(20));
    }
}
