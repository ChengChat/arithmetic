package classice.question01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个未排序数组,找出其中最长的等差数列(无需保证数字顺序)。
 * 不对。。。。
 */
public class Progression {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int len = getLength(arr);
        System.out.println(len);


    }
    public static int getLength(int[] arr){

        Arrays.sort(arr);
        int len = 0;
        int count = 1;
        int differ = arr[1] - arr[0];
        for(int i = 1; i < arr.length ; i++){
            if(differ == arr[i] - arr[i-1]){
                count++;
                if(count > len){
                    len = count;
                }
            }else{
                differ = arr[i] - arr[i-1];
                    count = 1;

            }
        }
        return len;
    }
}
