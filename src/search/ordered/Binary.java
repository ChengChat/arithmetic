package search.ordered;

/**
 * 二分法查找
 */
public class Binary {

    public static int sort(int[] arr, int key) {
        int low = 1;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (key > arr[mid]) {
                low = mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    /**
     *
     * @param arr 查找表
     * @param low 查找范围的 低边界
     * @param high 查找范围的 高边界
     * @param key 查找的关键字
     * @return 查找表与关键字相等的元素的角标
     */
    public static int sortByRecursive(int[] arr,int low,int high, int key) {
        if (low <= high) {
            int mid = (low + high) >> 1;
            if (key > arr[mid]) {
                return sortByRecursive(arr, mid + 1, high, key);
            } else if (key < arr[mid]) {
                return sortByRecursive(arr, low, mid - 1, key);
            } else {
                return mid;
            }
        }
        return 0;
    }
}
