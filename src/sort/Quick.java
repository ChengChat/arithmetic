package sort;

/**
 * 快速排序：
 */
public class Quick {

    public static void main(String[] args) {
        int[] array = SortUtlis.createArray();

        quickSort(array, 0, array.length - 1);
        SortUtlis.print(array);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }

    }

    private static int partition(int[] array, int low, int high) {
        int pivotKey = low;
        int pivotVal = array[low];
        while (low < high){
            while (low < high && array[high] >= pivotVal){
                high--;
            }
            while (low < high && array[low] <= pivotVal) {
                low++;
            }
            if (low < high) {

                SortUtlis.swap(array, low, high);
            }
        }
        SortUtlis.swap(array, low, pivotKey);
        return low;
    }
}
