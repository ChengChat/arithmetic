package classice.question12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        double area = 0;
        boolean flag = true;
        for (int i = array.length - 1; i >= 0; i--) {
            if (flag) {
                area += Math.PI * array[i] * array[i];
                flag = false;
            } else {
                area -= Math.PI * array[i] * array[i];
                flag = true;
            }
        }

        System.out.println(Math.round(area * 100000)/100000.0);
    }
}
