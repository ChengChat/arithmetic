package classice.question16;

import java.util.Scanner;

/**
 * 第一行两个数N，K。
 * <p>
 * 第二行N个数，第 i 个数为a[i]。
 * 1<=N<=5000 ；1<=K<998244353；0<=a[i]<998244353
 * 输出
 * 一个数表示sum[K][N]。
 * 样例输入
 * 4 3
 * 1 0 0 0
 */

public class Main {
    public static final double MOD = 1e9 + 7;

    public static void main(String[] args) {
        System.out.println(3 % (1e9 + 7));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        double[][] array = new double[2][n + 1];
        for (int i = 1; i <= n; i++) {
            array[0][i] = scanner.nextInt();
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                array[i & 1][j] = (array[i & 1][j - 1] + array[(i + 1) & 1][j]) % MOD;
            }
        }

        System.out.println(array[k & 1][n]);
    }
}
