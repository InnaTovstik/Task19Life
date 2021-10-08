package com.company;

public class GameLife {

    public int[][] stateGeneration(int[][] tab) {
        int m = tab.length;
        int n = tab[0].length;
        int[][] nextTab = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighboursAlive = countNeigboursAlive(tab, i, j);
                //1 и 3 правило. Любая живая ячейка с менее чем двумя и с более чем тремя живыми соседями умирает
                if (tab[i][j] == 1 &&
                        (neighboursAlive < 2 ||
                                neighboursAlive > 3)) {
                    nextTab[i][j] = 0;
                    //2.Любая живая клетка с двумя или тремя живыми соседями доживает до следующего поколения.
                } else if (tab[i][j] == 1 &&
                        (neighboursAlive == 2 ||
                                neighboursAlive == 3)) {
                    nextTab[i][j] = 1;
                }
                //4. Любая мертвая клетка с ровно тремя живыми соседями становится живой клеткой.
                else if (tab[i][j] == 0 &&
                        neighboursAlive == 3)
                    nextTab[i][j] = 1;
            }
        }
        return nextTab;
    }

    public int countNeigboursAlive(int[][] board, int i, int j) {
        int count = 0;
        //Расположение соседей: слева, справа, над, под; по диагонали - вверху слева, внизу слева, вверху справа, внизу справа
        int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}, {-1, 0}};
        for (int[] dir : direction) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 &&
                    y >= 0 &&
                    x < board.length &&
                    y < board[0].length) {
                count += board[x][y];
            }
        }
        return count;
    }
}