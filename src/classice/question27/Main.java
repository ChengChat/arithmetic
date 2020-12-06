package classice.question27;

import java.util.Scanner;

/**
 * TODO 获取N（n为很大的数）位数的所有数。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        getCount(n, s, x);

    }

    private static void getCount(int n, int s, int x) {
        int[] num = new int[n];
        int count = 0;
        while (!isFull(num)) {
            getNum(num);
            if (isConform(num, s, x)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isConform(int[] num, int s, int x) {

        for (int i = 0; i < num.length - 2; i++) {
            int a = num[i] + num[i + 1] + num[i + 2];
            if (a % x != 0) {
                return false;
            }
        }
        int sum = 0;
        for (int value : num) {
            sum += value;
        }
        return sum == s;
    }

    private static boolean isFull(int[] num) {
        for (int value : num) {
            if (value != 9) {
                return false;
            }
        }
        return true;
    }


    private static void getNum(int[] num) {
        int i = 0;
        if (num[i] == 9) {
            if (i != num.length - 1) {
                while (true) {
                    num[i] = 0;
                    i++;
                    if (num[i] != 9) {
                        num[i]++;
                        return;
                    }
                }
            }
        } else {
            num[i]++;
        }
    }
}
