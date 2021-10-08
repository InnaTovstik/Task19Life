package com.company;

public class Main {

    private static int state = 0;

    public static void main(String[] args) {
        GameLife gameLife = new GameLife();
        int m = 15;
        int n = 10;
        int[][] tab = new int[m][n];
        //Планёр
        tab[7][0] = 1;
        tab[7][1] = 1;
        tab[8][1] = 1;
        tab[8][2] = 1;
        tab[9][0] = 1;
        do {
            printTab(tab);
            state++;
            tab = gameLife.stateGeneration(tab);
        }
        while (state < 20);
    }

    public static void printTab(int[][] tab) {
        System.out.println(" Состояние " + state);
        for (int[] cell : tab) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf("%1d ", cell[j]);
            }
            System.out.println();
        }
    }
}