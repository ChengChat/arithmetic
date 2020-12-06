package classice.question30;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        char[] array1;
        char[] array2;
        if(s1.length() < s2.length()){
            array1 = s1.toCharArray();
            array2 = s2.toCharArray();
        }else {
            array2 = s1.toCharArray();
            array1 = s2.toCharArray();
        }

        int count = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    int u = i;
                    int v = j;
                    while (u < array1.length && v < array2.length &&
                            array1[u] == array2[v]) {
                        u++;
                        v++;
                    }
                    count = Math.max(count, u - i);
                }
            }
        }
        System.out.println(count);
    }
}
