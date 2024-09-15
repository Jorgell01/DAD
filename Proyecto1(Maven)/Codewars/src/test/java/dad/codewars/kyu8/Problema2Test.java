package dad.codewars.kyu8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class Problema2Test {

    private Problema2 problema2;

    @Before
    public void setup() {

        problema2 = new Problema2();
    }

    @Test
    public void testArrayOf2Integers() {
        // Pruebas con arrays de 2 enteros
        assertTrue(Problema2.isAscOrder(new int[] {1, 2})); // Debería ser true
        assertFalse(Problema2.isAscOrder(new int[] {2, 1})); // Debería ser false
    }

    @Test
    public void testArrayOf3Integers() {
        // Pruebas con arrays de 3 enteros
        assertTrue(Problema2.isAscOrder(new int[] {1, 2, 3})); // Debería ser true
        assertFalse(Problema2.isAscOrder(new int[] {1, 3, 2})); // Debería ser false
        assertTrue(Problema2.isAscOrder(new int[] {1, 4, 13, 97, 508, 1047, 20058})); // Debería ser true
        assertFalse(Problema2.isAscOrder(new int[] {56, 98, 123, 67, 742, 1024, 32, 90969})); // Debería ser false
    }

    @Test
    public void testMoreAdvancedCases() {
        // Pruebas con casos más avanzados
        assertTrue(Problema2.isAscOrder(new int[] {1, 4, 13, 97, 508, 1047, 20058})); // Debería ser true
        assertFalse(Problema2.isAscOrder(new int[] {56, 98, 123, 67, 742, 1024, 32, 90969})); // Debería ser false
    }
}
