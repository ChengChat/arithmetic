package classice.question06;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] arr = s.split(" ");
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        boolean flag = false;
        for (int i = 1; i < array.length; i++) {
            int sum = 0;
            for (int j = i - 1; j >= 0 ; j--) {
                if(array[j] > array[i]){
                    sum++;
                }
            }
            if(sum == 1){
                System.out.print(i + " ");
                flag = true;
            }
        }
        if(!flag){
            System.out.println(-1);
        }
    }
}
