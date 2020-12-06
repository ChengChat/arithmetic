package sort;

/**
 * 直接插入排序算法：
 * 基本操作是将一个记录插入到已经排好序的有序表中，从而得到一个新的，记录数增1的有序表。
 * 当排序表本身就是有序的时候，性能很高，时间复杂度为O（n）
 */
public class Insert {
    public static void main(String[] args) {
        int[] array = SortUtlis.createArrayWithSentry();
        insertSort(array);
        SortUtlis.print(array);
    }

    private static void insertSort(int[] array) {
        int j = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                array[0] = array[i];
                for (j = i - 1; array[j] > array[0]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = array[0];
            }
        }
    }
}
