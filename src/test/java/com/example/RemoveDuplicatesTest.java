package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesTest {

    private final RemoveDuplicates solution = new RemoveDuplicates();

    @Test
    public void testRemoveDuplicatesBasic() {
        int[] nums = {1, 1, 2};
        int len = solution.removeDuplicates(nums);
        
        assertEquals(2, len, "Length should be 2");
        assertEquals(1, nums[0], "First element should be 1");
        assertEquals(2, nums[1], "Second element should be 2");
    }

    @Test
    public void testRemoveDuplicatesMultiple() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = solution.removeDuplicates(nums);
        
        assertEquals(5, len, "Length should be 5");
        int[] expected = {0, 1, 2, 3, 4};
        for (int i = 0; i < len; i++) {
            assertEquals(expected[i], nums[i], "Element at index " + i + " mismatch");
        }
    }

    @Test
    public void testRemoveDuplicatesNoDuplicates() {
        int[] nums = {1, 2, 3, 4, 5};
        int len = solution.removeDuplicates(nums);
        
        assertEquals(5, len);
        for (int i = 0; i < len; i++) {
            assertEquals(i + 1, nums[i]);
        }
    }

    @Test
    public void testRemoveDuplicatesAllSame() {
        int[] nums = {1, 1, 1, 1};
        int len = solution.removeDuplicates(nums);
        
        assertEquals(1, len);
        assertEquals(1, nums[0]);
    }

    @Test
    public void testRemoveDuplicatesEmpty() {
        int[] nums = {};
        int len = solution.removeDuplicates(nums);
        
        assertEquals(0, len);
    }
    
    @Test
    public void testRemoveDuplicatesNull() {
        int len = solution.removeDuplicates(null);
        assertEquals(0, len);
    }
}
