package classice.question03;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 0-1背包问题
 * 有n个物品，它们有各自的体积和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 * https://blog.csdn.net/qq_38410730/article/details/81667885?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 */
public class Main1 {
    public static void main(String[] args) {
        int n = 4;
        int[] value = {0, 2, 3, 4, 5};
        int[] weight = {0, 3, 4, 5, 6};
        int capacity = 8;
        int[][] dp = new int[5][9];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i -  1][j],dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
