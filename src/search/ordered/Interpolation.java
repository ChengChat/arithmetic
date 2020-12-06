package search.ordered;

/**
 * 插值查找：
 * 根据要查找的关键字key与查找表中最大最小记录的关键字比较后的查找方法，
 * 其核心就在于插值的计算公式:  (key-a[low])/(a[high]-a[low])
 * <p>
 * 对于表长比较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好得多
 */
public class Interpolation {

    public static int sort(int[] arr, int key) {
        int low = 1;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low]);
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
}
