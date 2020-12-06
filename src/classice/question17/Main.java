package classice.question17;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[] weights = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            weights[i] = Integer.parseInt(strs[i]);
        }
        int maxLoad = scanner.nextInt();
        int count = countLeastBoat(weights, maxLoad);
        System.out.println(count);
    }

    private static int countLeastBoat(int[] weights, int maxLoad) {
        Arrays.sort(weights);
        int left = 0;
        int right = weights.length - 1;
        int count = 0;
        while (left < right) {
            if (weights[left] + weights[right] <= maxLoad) {
                count++;
                left++;
            }
            right--;
        }
        return (weights.length - count * 2) + count;
    }
}
