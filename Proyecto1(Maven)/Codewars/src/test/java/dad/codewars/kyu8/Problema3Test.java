package dad.codewars.kyu8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assertions.assertEquals;

class Problema3Test {

    private Problema3 problema;

    @Before
    void setUp() {
        problema = new Problema3();
    }

    @Test
    void testReverseWords() {
        assertEquals("world! hello", Problema3.reverseWords("hello world!"));
        assertEquals("this like speak doesn't yoda", Problema3.reverseWords("yoda doesn't speak like this"));
        assertEquals("foobar", Problema3.reverseWords("foobar"));
        assertEquals("editor kata", Problema3.reverseWords("kata editor"));
        assertEquals("boat your row row row", Problema3.reverseWords("row row row your boat"));
        assertEquals("", Problema3.reverseWords(""));
    }
}
