package org.testtask;

import java.util.Arrays;

public class ThirdTask {

    public static void solving(int[] p1, int[] p2, int n, int trials) {
        if (p1.length != 3 || p2.length != 3) {
            System.out.println("p1 and p2 must be of length 3");
            return;
        }
        double[] probabilities = monteCarlo(p1, p2, n, trials);
        System.out.println("Player 1 win probability: " + probabilities[0]);
        System.out.println("Player 2 win probability: " + probabilities[1]);
        System.out.println("Draw probability: " + probabilities[2]);

    }

    private static int[] match(int[] p1, int[] p2, int[] sequence) {

        int count1 = 0;
        int count2 = 0;

        int i1 = sequence.length;
        int i2 = sequence.length;

        for (int i = 0; i <= sequence.length - 3; i++) {
            if (sequence[i] == p1[0] && sequence[i + 1] == p1[1] && sequence[i + 2] == p1[2] && i != i1 + 1 && i != i1 + 2) {
                count1++;
                i1 = i; //Если игрок выиграл на i-том элементе, элементы i + 1 и i + 2 не рассматриваем
            }
            if (sequence[i] == p2[0] && sequence[i + 1] == p2[1] && sequence[i + 2] == p2[2] && i != i2 + 1 && i != i2 + 2) {
                count2++;
                i2 = i; //Если игрок выиграл на i-том элементе, элементы i + 1 и i + 2 не рассматриваем
            }
        }

        return new int[]{count1, count2};
    }

    private static double[] monteCarlo(int[] p1, int[] p2, int n, int trials) {
        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;

        int score1 = 0;
        int score2 = 0;

        for (int i = 0; i < trials; i++) {
            Integer[] sequence = new Integer[n];
            Service.fillArray(sequence, 1, 6);

            int[] result = match(p1, p2, Arrays.stream(sequence).mapToInt(Integer::intValue).toArray());

            score1 += result[0];
            score2 += result[1];

            if (result[0] > result[1]) player1Wins++;
            if (result[0] == result[1]) draws++;
            if (result[0] < result[1]) player2Wins++;
        }
        double player1WinProbability = player1Wins / (double) trials;
        double player2WinProbability = player2Wins / (double) trials;
        double drawProbability = draws / (double) trials;

        System.out.println("Average score p1:");
        System.out.println(score1 / (double) trials);
        System.out.println("Average score p2:");
        System.out.println(score2 / (double) trials);

        return new double[]{player1WinProbability, player2WinProbability, drawProbability};
    }

}
