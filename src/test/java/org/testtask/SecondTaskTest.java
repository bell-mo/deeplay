package org.testtask;

import org.junit.jupiter.api.Test;
import org.testtask.dto.SecondTaskResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SecondTaskTest {

    @Test
    void findMostFrequentNumbers() {
        Integer[] arr = {1, 8, -7, 0, -4, -10, 6, 5, 0, -7};
        SecondTaskResult expectedResult = new SecondTaskResult(Arrays.asList(0, -7), 2);
        SecondTaskResult actualResult = SecondTask.findMostFrequentNumbers(arr);
        assertEquals(expectedResult.mostFrequentNumbers(), actualResult.mostFrequentNumbers());
        assertEquals(expectedResult.maxFrequency(), actualResult.maxFrequency());
    }
}