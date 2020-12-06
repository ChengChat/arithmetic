package offer.quality.question21;

import sort.SortUtlis;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 扩展：解决一系列问题的通用解法，
 * 比如把所有的负数放在前半部分，所有的正数放在后半部分
 * 比如把所有能被3整除的数放在前半部分，所有不能的放在后半部分
 * 可使用策略模式
 *
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, -5, 6, 7};
/*        reOrder(arr);
        SortUtlis.print(arr);
*/

        ReOrder reOrder = new ReOrder(new PositiveAndNegativeStrategy());
        reOrder.reOrder(arr);
        SortUtlis.print(arr);
    }

    private static void reOrder(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin < end && (arr[begin] & 1) == 1) {
                begin++;
            }
            while (begin < end && (arr[end] & 1) == 0) {
                end--;
            }
            if (begin < end) {
                SortUtlis.swap(arr, begin, end);
            }
        }

    }
}
