package classice.question09;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strs = s.split(" ");
        if (((strs.length - 1) & 1) == 1) {
            System.out.println("error");
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if ((i & 1) == 1) {
                if (!"or".equals(strs[i]) && !"and".equals(strs[i])) {
                    System.out.println("error");
                    return;
                }
            } else {
                if (!"true".equals(strs[i]) && !"false".equals(strs[i])) {
                    System.out.println("error");
                    return;
                }
            }
        }
        int[] arr = new int[strs.length];
        Arrays.fill(arr, 1);
        int n = 0;
        for (int i = 1; i < strs.length; i += 2) {
            if ("or".equals(strs[i])) {
                if ("true".equals(strs[i - 1]) || "true".equals(strs[i + 1])) {
                    arr[n++] = 1;
                } else {
                    arr[n++] = 0;
                }
            }
        }
        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            k &= arr[i];
        }
        System.out.println(k == 1);
    }
}
