package offer.base.quesion03;

/**
 * 题目二：
 * 不修改数组找出重复的数字：
 * <p>
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * <p>
 * 例如，如果输入长度为8的数组{2, 3, 0, 4, 3, 2, 6, 7}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class Question2 {

    public static int getDuplication(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0 || arr[i] > arr.length - 1) {
                return -1;
            }
        }

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            int count = countRange(arr, start, mid);
            if (start == end) {
                if (count > 1) {
                    return arr[start];
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int countRange(int[] arr, int start, int mid) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= mid) {
                count++;
            }
        }
        return count;
    }
}
