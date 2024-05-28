package org.testtask.dto;

import java.util.List;

public record SecondTaskResult(
        List<Integer> mostFrequentNumbers,
        Integer maxFrequency
) {
}
