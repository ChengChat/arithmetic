package classice.question07;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String[] arr = s.split(",");
        int[] weight = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            weight[i] = getWeight(arr[i].toCharArray());
        }

        int k = 0;

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] != 0) {
                if (i != weight.length - 1) {
                    System.out.print(arr[i] + ",");
                } else {
                    System.out.println(arr[i]);
                }
            }
        }
    }

    private static int getWeight(char[] array) {
        int sum = 1, sumMax = 1;
        int asc = 1, ascMax = 1;
        int desc = 1, descMax = 1;
        for (int i = 3; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                sum++;
            } else {
                sumMax = Math.max(sum, sumMax);
                sum = 1;
            }


            if (array[i] < array[i + 1]) {
                asc++;
            } else {
                ascMax = Math.max(asc, ascMax);
                asc = 1;
            }

            if (array[i] > array[i + 1]) {
                desc++;
            } else {
                descMax = Math.max(desc, descMax);
                desc = 1;
            }
        }
        LinkedList<Object> objects = new LinkedList<>();
        if (sum >= 3 && sum >= asc && sum >= desc) {
            return sum * 10 + 1;
        } else if (asc >= 3 && asc > sum && asc >= desc) {
            return asc * 10;
        } else if (desc >= 3 && desc > sum && desc > asc) {
            return desc * 10;
        }
        return 0;
    }
}
