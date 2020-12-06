package offer.thinking.question38;

import sort.SortUtlis;

/**
 * 面试题38：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class Main {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c','d'};
        permutation(arr);
    }

    private static void permutation(char[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        permutation(arr, 0);
    }

    private static void permutation(char[] arr, int index) {
        if (index >= arr.length) {
            SortUtlis.print(arr);
        } else {
            for (int i = index; i < arr.length; i++) {
                SortUtlis.swap(arr, i, index);
                permutation(arr, index + 1);
                SortUtlis.swap(arr, i, index);
            }
        }
    }
}
