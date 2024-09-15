package dad.codewars.kyu8;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class Problema1Test {

    private Problema1 problema1;

    @Before
    public void setup() {

        problema1 = new Problema1();
    }

    @Test
    public void testDivisibleBy() {
        // divisible por 2
        assertArrayEquals(new int[] {2, 4, 6}, Problema1.divisibleBy(new int[] {1, 2, 3, 4, 5, 6}, 2));

        // divisible por 3
        assertArrayEquals(new int[] {3, 6}, Problema1.divisibleBy(new int[] {1, 2, 3, 4, 5, 6}, 3));

        // divisible por 4
        assertArrayEquals(new int[] {0, 4}, Problema1.divisibleBy(new int[] {0, 1, 2, 3, 4, 5, 6}, 4));
    }
}
