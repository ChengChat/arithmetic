package classice.question25;


import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO 有一对兔子，从出生到第5个月 每月生一对兔子，n月后，有几对兔子。
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {20,5};
        int[] ints = selectWindow(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }



    public static int[] selectWindow(int[] array) {
     /*   int length = array.length;
        if (length <= 0) {
            return null;
        }
        if (length == 1) {
            return new int[]{1};
        }
        if (length == 2) {
            return new int[]{1, 2};
        }*/
        int n = 0;
        int[] window = new int[3];
        int[] select = new int[array.length];
      /*  for (int i = 0; i < window.length; i++) {
            select[n] = i + 1;
            window[i] = array[n++];
        }*/
        while (n < array.length ) {
            for (int i = 0; i < window.length; i++) {
                window[i]--;
                if (window[i] <= 0) {
                    select[n] = i + 1;
                    window[i] = array[n++];
                }
            }
        }
        return select;
    }
}
