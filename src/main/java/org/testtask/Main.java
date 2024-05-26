package org.testtask;

public class Main {
    public static void main(String[] args) {
        System.out.println("First task:");
        FirstTask.solving(20);

        System.out.println("Second task:");
        SecondTask.solving(20);

        System.out.println("Third task:");
        ThirdTask.solving(new int[]{1, 2, 2}, new int[]{3, 6, 5}, 50, 1000000);

        System.out.println("Fourth task:");
        FourthTask.solving(20, 4);
    }
}