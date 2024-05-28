package org.testtask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThirdTaskTest {

    @Test
    void match() {
        int[] expectedResult = {1, 2};
        int[] p1 = {4, 2, 4};
        int[] p2 = {4, 4, 4};
        int[] sequence = {1, 4, 2, 4, 4, 4, 4, 4, 4, 4};
        int[] actualResult = ThirdTask.match(p1, p2, sequence);
        assertArrayEquals(expectedResult, actualResult);
    }
}