package org.testtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourthTask {
    public static void solving(int n, int k) {
        Integer[] arr = new Integer[n];
        Service.fillArray(arr);

        System.out.println("Source array:");
        Service.printArray(arr);
        System.out.println("K: " + k);

        List<List<Integer>> result = partition(arr, k);
        if (result == null) {
            System.out.println("Separation is impossible.");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Part " + (i + 1) + ": " + result.get(i));
            }
        }
    }

    private static List<List<Integer>> partition(Integer[] array, int K) {
        int totalSum = Arrays.stream(array)
                .mapToInt(Integer::intValue)
                .sum();
        int n = array.length;

        // Проверка, можно ли разделить массив на K частей
        if (totalSum < (K * (K - 1)) / 2) {
            return null;
        }

        // Вычисляем сумму L для первой части
        int remainingSum = totalSum - (K * (K - 1)) / 2;
        if (remainingSum % K != 0) {
            return null;
        }
        int L = remainingSum / K;

        // Инициализируем массив результата и вызовем рекурсивную функцию
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(new ArrayList<>());
        }

        boolean[] used = new boolean[n];
        if (partitionHelper(Arrays.stream(array).mapToInt(Integer::intValue).toArray(), K, 0, used, result, L)) {
            return result;
        } else {
            return null;
        }
    }

    private static boolean partitionHelper(int[] array, int K, int currentPart,
                                          boolean[] used, List<List<Integer>> result, int currentTarget) {
        if (currentPart == K) {
            return true;
        }

        if (currentTarget == 0) {
            return partitionHelper(array, K, currentPart + 1, used, result, currentTarget + currentPart + 1);
        }

        for (int i = 0; i < array.length; i++) {
            if (!used[i] && currentTarget >= array[i]) {
                used[i] = true;
                result.get(currentPart).add(array[i]);
                if (partitionHelper(array, K, currentPart, used, result, currentTarget - array[i])) {
                    return true;
                }
                used[i] = false;
                result.get(currentPart).removeLast();
            }
        }

        return false;
    }
}
