package classice.question11;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int[] replace = new int[10];
        for (int i = 1; i < 10; i++) {
            replace[i] = scanner.nextInt();
        }
        String negative = "";
        if (next.startsWith("-")) {
            next = next.substring(1);
            negative = "-";
        }
        char[] array = next.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(replace[Integer.parseInt(c + "")]);
        }
        System.out.println(negative + sb);
    }
}
