package test;

import java.util.Scanner;

/**
 * 题目一. 有两个有序数组，合并为一个有序数组。（15分）
 * <p>
 * 示例：
 * <p>
 * 输入：
 * arrayA : [1， 3， 5， 7， 9]
 * arrayB : [2, 4, 6, 8, 10]
 * <p>
 * 输出：
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */
public class Question1 {

    public static void main(String[] args) {
        int[] arrayA = {1,3,5,7,9};
        int[] arrayB = {2,4,6,8,10};

        merge(arrayA,arrayB);
    }

    public static void merge(int[] arrayA, int[] arrayB) {
        int[] temp = new int[arrayA.length + arrayB.length];
        int i = 0;
        int pA = 0;
        int pB = 0;
        while (pA < arrayA.length && pB < arrayB.length) {
            temp[i++] = arrayA[pA] < arrayB[pB] ? arrayA[pA++] : arrayB[pB++];
        }
        while (pA < arrayA.length) {
            temp[i++] = arrayA[pA++];
        }
        while (pB < arrayB.length) {
            temp[i++] = arrayB[pB++];
        }
        System.out.print("[");
        for (i = 0; i < temp.length-1; i++) {
            System.out.print(temp[i] + ", ");
        }
        System.out.println(temp[temp.length-1] + "]");
    }
}
