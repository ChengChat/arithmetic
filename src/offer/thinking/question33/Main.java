package offer.thinking.question33;

import sun.net.www.protocol.http.HttpURLConnection;

/**
 * 面试题33：二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class Main {
    public static void main(String[] args) {
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        boolean flag = verifySequenceOfBst(sequence);
        System.out.println(flag);
    }

    private static boolean verifySequenceOfBst(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySequenceOfBst(sequence, 0, sequence.length - 1);
    }


    private static boolean verifySequenceOfBst(int[] sequence, int low, int high) {
        if (low >= high) {
            return true;
        }
        int root = sequence[high];
        int i = low;
        for (; i < high; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < high; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

     /*   boolean left = true;
        if (i > low) {
            left = verifySequenceOfBst(sequence, low, i - 1);
        }

        boolean right = true;
        if (i < high) {
            right = verifySequenceOfBst(sequence, i, high - 1);
        }*/
        return (verifySequenceOfBst(sequence, low, i - 1) && verifySequenceOfBst(sequence, i, high - 1));
    }
}
