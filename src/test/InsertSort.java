package test;

import sort.SortUtlis;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = SortUtlis.createArray();
        insertSort(array);
        SortUtlis.print(array);
    }

    private static void insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                for (j = i - 1; array[j] > temp; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }

    }
}
