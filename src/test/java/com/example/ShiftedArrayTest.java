package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftedArrayTest {

    private final ShiftedArray shiftedArray = new ShiftedArray();

    @Test
    public void testRotateBasic() {
        String s = "abcdef";
        int k = 2;
        // 向右移动2位: efabcd
        String expected = "efabcd";
        assertEquals(expected, shiftedArray.rotate(s, k), "Basic rotation failed");
    }

    @Test
    public void testRotateWithKGreaterThanLength() {
        String s = "abcdef"; // length 6
        int k = 8; // equivalent to k = 2
        String expected = "efabcd";
        assertEquals(expected, shiftedArray.rotate(s, k), "Rotation with k > length failed");
    }

    @Test
    public void testRotateWithKEqualsLength() {
        String s = "hello";
        int k = 5;
        assertEquals(s, shiftedArray.rotate(s, k), "Rotation with k = length should return original string");
    }

    @Test
    public void testRotateWithZeroK() {
        String s = "hello";
        int k = 0;
        assertEquals(s, shiftedArray.rotate(s, k), "Rotation with k = 0 should return original string");
    }

    @Test
    public void testRotateWithEmptyString() {
        String s = "";
        int k = 3;
        assertEquals("", shiftedArray.rotate(s, k), "Rotation of empty string should return empty string");
    }

    @Test
    public void testRotateWithSingleChar() {
        String s = "a";
        int k = 10;
        assertEquals("a", shiftedArray.rotate(s, k), "Rotation of single char string failed");
    }
}
