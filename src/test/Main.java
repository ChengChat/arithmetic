package test;

import static offer.SortUtlis.swap;

/**
 * 写一个函数，输入为一个int数组，长度不低于10个且互不相同，找出第5大的数字并返回？
 * 时间复杂度是多少？空间复杂度多少？
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, 43, 5, 723, 7, 32, 4, 6, 8, 11, 12, 13};
        int five = getThFive(arr, 0, arr.length - 1);
        System.out.println(five);
    }

    private static int getThFive(int[] arr, int left, int right) {
        for (int j = 1; j < arr.length; j++) {
            for (int i = arr.length - 1; i >= j; i--) {
                if (arr[i] > arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        return arr[4];
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotKey = left;
        int pivotVal = arr[left];
        while (left < right) {
            while (left < right && right <= pivotVal) {
                right--;
            }
            while (left < right && left >= pivotVal) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, pivotKey, left);
        return left;
    }
}
