package classice.question31;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        double[][] arr = new double[3][3];
        double[][] line = new double[3][3];
        String[] str = s.split("\\) \\(");
        str[0] = str[0].substring(1);
        String last = str[str.length - 1];
        str[str.length - 1] = last.substring(0, last.length() - 1);

        for (int i = 0; i < str.length; i++) {
            String[] subStr = str[i].split(",");
            for (int j = 0; j < subStr.length; j++) {
                arr[i][j] = Double.parseDouble(subStr[j]);
            }
        }
        for (int i = 0; i < 3; i++) {
            line[0][i] = Math.abs(arr[0][i] - arr[1][i]);
        }
        for (int i = 0; i < 3; i++) {
            line[1][i] = Math.abs(arr[1][i] - arr[2][i]);
        }
        for (int i = 0; i < 3; i++) {
            line[2][i] = Math.abs(arr[0][i] - arr[2][i]);
        }

        double[] lin = new double[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double temp = line[i][j];
                lin[i] += (temp * temp);
            }
        }

        double max = 0.0;
        max = Math.max(lin[0], Math.max(lin[1], lin[2]));
        System.out.println(max < (lin[0] + lin[1] + lin[2] - max));
    }
}
