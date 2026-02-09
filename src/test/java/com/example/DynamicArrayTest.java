package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    @Test
    public void testInsertBasic() {
        DynamicArray array = new DynamicArray();
        assertTrue(array.insert(0, 10)); // [10]
        assertTrue(array.insert(1, 20)); // [10, 20]
        assertTrue(array.insert(1, 15)); // [10, 15, 20]
        
        assertEquals(3, array.size());
        assertEquals(10, array.get(0));
        assertEquals(15, array.get(1));
        assertEquals(20, array.get(2));
    }

    @Test
    public void testInsertInvalidIndex() {
        DynamicArray array = new DynamicArray();
        assertTrue(array.insert(0, 10));
        assertFalse(array.insert(2, 20)); // Index > size
        assertFalse(array.insert(-1, 30)); // Index < 0
        assertEquals(1, array.size());
    }

    @Test
    public void testResize() {
        DynamicArray array = new DynamicArray();
        // Initial capacity is 4
        assertEquals(4, array.capacity());
        
        assertTrue(array.insert(0, 1));
        assertTrue(array.insert(1, 2));
        assertTrue(array.insert(2, 3));
        assertTrue(array.insert(3, 4));
        assertEquals(4, array.capacity()); // Should still be 4
        
        // Trigger resize
        assertTrue(array.insert(4, 5));
        assertEquals(5, array.size());
        assertEquals(8, array.capacity()); // Should be doubled to 8
        
        assertEquals(1, array.get(0));
        assertEquals(5, array.get(4));
    }

    @Test
    public void testRemoveBasic() {
        DynamicArray array = new DynamicArray();
        array.insert(0, 10);
        array.insert(1, 20);
        array.insert(2, 30); // [10, 20, 30]
        
        int removed = array.remove(1); // Remove 20
        assertEquals(20, removed);
        assertEquals(2, array.size());
        assertEquals(10, array.get(0));
        assertEquals(30, array.get(1));
    }

    @Test
    public void testRemoveInvalidIndex() {
        DynamicArray array = new DynamicArray();
        array.insert(0, 10);
        
        assertEquals(-1, array.remove(1)); // Out of bounds
        assertEquals(-1, array.remove(-1)); // Negative index
        assertEquals(-1, array.remove(5));
        assertEquals(1, array.size()); // Size shouldn't change
    }

    @Test
    public void testGetBasic() {
        DynamicArray array = new DynamicArray();
        array.insert(0, 100);
        assertEquals(100, array.get(0));
    }

    @Test
    public void testGetInvalidIndex() {
        DynamicArray array = new DynamicArray();
        array.insert(0, 100);
        assertEquals(-1, array.get(1));
        assertEquals(-1, array.get(-1));
    }
}
