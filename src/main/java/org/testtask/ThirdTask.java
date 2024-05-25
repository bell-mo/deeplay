package org.testtask;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ThirdTask {

    public static void solving(int[] p1, int[] p2, int n) {
        if (p1.length != 3 || p2.length != 3) {
            System.out.println("p1 and p2 must be of length 3");
            return;
        }
        double[] probabilities = monteCarlo(p1, p2, n, 1000000);
        System.out.println("Player 1 win probability: " + probabilities[0]);
        System.out.println("Player 2 win probability: " + probabilities[1]);
        System.out.println("Draw probability: " + probabilities[2]);

    }

    private static int match(int[] p1, int[] p2, int[] sequence) {

        int count1 = (int) IntStream.range(0, sequence.length - 2)
                .parallel()
                .filter(i -> Arrays.equals(Arrays.copyOfRange(sequence, i, i + 3), p1))
                .count();

        int count2 = (int) IntStream.range(0, sequence.length - 2)
                .parallel()
                .filter(i -> Arrays.equals(Arrays.copyOfRange(sequence, i, i + 3), p2))
                .count();

        if (count1 > count2) {
            return 1;
        } else if (count1 == count2) {
            return 2;
        } else {
            return 3;
        }
    }

    private static double[] monteCarlo(int[] p1, int[] p2, int n, int trials) {
        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;

        for (int i = 0; i < trials; i++) {
            Integer[] sequence = new Integer[n];
            Service.fillArray(sequence, 1, 5);

            int result = match(p1, p2, Arrays.stream(sequence).mapToInt(Integer::intValue).toArray());

            if (result == 1) player1Wins++;
            if (result == 2) draws++;
            if (result == 3) player2Wins++;
        }
        double player1WinProbability = player1Wins / (double) trials;
        double player2WinProbability = player2Wins / (double) trials;
        double drawProbability = draws / (double) trials;

        return new double[]{player1WinProbability, player2WinProbability, drawProbability};
    }

}
