package org.testtask;

import java.util.Arrays;
import java.util.Comparator;

public class FirstTask {

    public static void solving(int n) {
        Integer[] arr = new Integer[n];
        Service.fillArray(arr, -10, 21);

        System.out.println("Source array:");
        Service.printArray(arr);

        rearrangeArray(arr);
        System.out.println("Rearranged array");
        Service.printArray(arr);
    }

    private static void rearrangeArray(Integer[] arr) {
        // Создаем компаратор для сортировки массива
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 != 0 && o2 % 2 != 0) {
                    return o1 - o2; // Сортируем нечетные числа по неубыванию
                } else if ((o1 == 0 && o2 % 2 != 0) || (o1 % 2 == 0 && o2 == 0) || (o1 % 2 == 0 && o2 % 2 != 0)) {
                    return 1; // Меняем местами если: первое четное и второе нечетное, или первое 0 и второе нечетное, или первое четное, второе 0
                } else if ((o1 == 0 && o2 % 2 == 0) || (o1 % 2 != 0 && o2 == 0) || (o1 % 2 != 0 && o2 % 2 == 0)) {
                    return -1; // Не меняем местами если: первое нечетное и второе четное, или первое 0 и второе четное, или первое нечетное, второе 0
                } else {
                    return o2 - o1; // Сортируем четные числа по невозрастанию
                }
            }
        });
    }

}
