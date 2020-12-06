package classice.question20;

public class Main {
    public static void main(String[] args) {

        // 测试用例
        int[] arr = {3, 4, 6, 2, 4, 7, 4, 5, 3, 7};
//        int[] arr = {1,3,4,5,7,8};
//        int[] arr = {1,0,4,5,7,8};
//        int[] arr = {1,3,4,5,7,8};
//        int[] arr = {2,4,4,8};
        // 查找数组arr中第k小的基数，总体时间复杂度为O（nlogn）
        int num = findKth(arr, 3);
//        int num = findKth(arr, -1);
        System.out.println(num);
    }


    public static int findKth(int[] arr, int k) {
        // 校验传入参数是否符合要求
        if (k < 0) {
            throw new IllegalArgumentException("查找第k小的基数，k不能小于0");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                throw new IllegalArgumentException("数组中的元素必须大于0");
            }
        }

        // 将奇数放在数组前面部分，偶数放在数组后面部分，并且返回最后一个奇数的角标,时间复杂度为O(n)
        int right = reOrder(arr);

        return findKth(arr, 0, right, k);
    }

    /**
     * 利用快速排序的思想，查找数组arr中第k小的基数，时间复杂度为O（nlogn)
     */
    private static int findKth(int[] arr, int left, int right, int k) {

        if (left < right) {
            int pivot = partition(arr, left, right);
            if (pivot < k - 1) {
                return findKth(arr, pivot + 1, right, k);
            } else if (pivot > k - 1) {
                return findKth(arr, left, pivot - 1, k);
            } else {
                return arr[pivot];
            }
        }
        return 0;
    }

    private static int partition(int[] array, int left, int right) {
        int pivotKey = left;
        int pivotVal = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivotVal) {
                right--;
            }
            while (left < right && array[left] <= pivotVal) {
                left++;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, left, pivotKey);
        return left;
    }

    private static int reOrder(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && (arr[right] & 1) == 0) {
                right--;
            }
            while (left < right && (arr[left] & 1) == 1) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        return right;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
