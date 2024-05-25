package org.testtask;

import java.util.Random;

public class Service {
    public static void fillArray(Integer[] arr, int min, int range) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(range) + min;
        }
    }

    public static void printArray(Integer[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
