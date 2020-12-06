package sort;

import java.util.Date;

/**
 * 简单选择排序：
 * 通过n-i次关键字间的比较，从记录中选出关键字最小的记录，并和第i个记录交换
 * 性能略优于冒泡排序，不过时间复杂度也是  O(n²)
 */
public class SimpleSelection {
    public static void main(String[] args) {
        int[] array = SortUtlis.createArray();
        simpleSelectionSort(array);
    }

    private static void simpleSelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(min != i){
                SortUtlis.swap(array,i,min);
            }
        }
    }
}
