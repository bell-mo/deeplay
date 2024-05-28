package org.testtask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstTaskTest {
    @Test
    void rearrangeArray() {
        Integer[] arr = {1, 8, -7, 0, -4, -10, 6, 5, 0};
        Integer[] expectedArr = {-7, 1, 5, 0, 0, 8, 6, -4, -10};
        FirstTask.rearrangeArray(arr);
        assertArrayEquals(expectedArr, arr);
    }
}