package org.testtask;

import org.junit.jupiter.api.Test;
import org.testtask.dto.FourthTaskResultPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourthTaskTest {

    @Test
    void partition() {
        Integer[] arr = {10, 11, 7, 7, 12};
        int k = 2;
        List<FourthTaskResultPart> expectedResult = new ArrayList<>();
        expectedResult.add(new FourthTaskResultPart(Arrays.asList(11, 12), 23));
        expectedResult.add(new FourthTaskResultPart(Arrays.asList(10, 7, 7), 24));

        List<FourthTaskResultPart> actualResult = new ArrayList<>();
        List<List<Integer>> actualResultList = FourthTask.partition(arr, k);
        assert actualResultList != null;
        for (List<Integer> part : actualResultList) {
            actualResult.add(new FourthTaskResultPart(
                    part,
                    part.stream()
                    .mapToInt(Integer::intValue)
                    .sum())
            );
        }
        assertEquals(expectedResult, actualResult);
    }
}