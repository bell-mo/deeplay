package org.testtask;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SecondTask {

    public static void solving(int n) {
        Integer[] arr = new Integer[n];
        Service.fillArray(arr, -10, 21);

        System.out.println("Source array:");
        Service.printArray(arr);

        findMostFrequentNumbers(arr);
    }

    private static void findMostFrequentNumbers(Integer[] array) {
        // Используем HashMap для хранения числа и его частоты
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Подсчет частоты каждого числа
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Определяем максимальную частоту
        int maxFrequency = Collections.max(frequencyMap.values());

        // Находим все числа, которые имеют максимальную частоту
        List<Integer> mostFrequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentNumbers.add(entry.getKey());
            }
        }

        // Вывод результатов
        System.out.println("The most common number(s): " + mostFrequentNumbers);
        System.out.println("Frequency: " + maxFrequency);
    }
}
