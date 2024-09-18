package dad.codewars.kyu7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Problema4Test {

    public Problema4 problema4;

    @Before
    public void setUp() {

        problema4 = new Problema4();
    }

    @Test
    public void testMultiples() {
        // Probar si el método multiples devuelve el resultado correcto
        assertArrayEquals(new int[] {5, 10, 15}, Problema4.multiplos(3, 5));
    }
}
