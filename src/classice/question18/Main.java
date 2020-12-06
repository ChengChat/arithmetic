package classice.question18;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] weight = new int[5][];
        String[] pointsStr = {"V1", "V2", "V3", "V4", "V5"};
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = scanner.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        method(weight, pointsStr);

    }

    private static void method(int[][] weight, String[] pointsStr) {

        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (weight[i][j] == -1) {
                    weight[i][j] = 9999;
                }
            }
        }
        int[] shortPath = weight[0].clone();
        int[] flag = new int[9];
        flag[0] = 1;

        for (int i = 0; i < weight.length; i++) {
            int min = 9999;
            int k = 0;
            for (int j = 0; j < shortPath.length; j++) {
                if (flag[j] == 0 && shortPath[j] < min) {
                    min = shortPath[j];
                    k = j;
                }
            }
            flag[k] = 1;

            for (int j = 0; j < shortPath.length; j++) {
                if (flag[j] == 0 && (min + weight[k][j]) < shortPath[j]) {
                    shortPath[j] = min + weight[k][j];
                }
            }
        }
        for (int i = 1; i < shortPath.length; i++) {
            System.out.println(shortPath[i]);
        }
    }
}
