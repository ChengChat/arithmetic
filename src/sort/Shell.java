package sort;

/**
 * 希尔排序：
 * 相当于分组的插入排序，按照增量分组，如：
 * 若增量为4，则1,5,9,13...为一组，2,6,10,14为另一组，然后对组内的数据进行插入排序
 * <p>
 * 这样能保证排序后的结果基本有序，所谓基本有序：
 * 就是小的关键字基本在前面，大的基本在后面，不大不小的基本在中间，像
 * {2,1,3,6,4,7,5,8,9}这样就可以称为基本有序了。
 */
public class Shell {
    public static void main(String[] args) {
        int[] array = SortUtlis.createArrayWithSentry();
        shellSort(array);
        SortUtlis.print(array, true);
        int[] array1 = SortUtlis.createArray();
        shellSort_2(array1);
        SortUtlis.print(array1);
    }

    private static void shellSort(int[] array) {
        // 增量序列
        int increment = array.length;
        int j;

        do {
            increment = increment / 3 + 1;
            for (int i = increment + 1; i < array.length; i++) {
                if (array[i] < array[i - increment]) {
                    array[0] = array[i];
                    for (j = i - increment; j > 0 && array[j] > array[0]; j -= increment) {
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = array[0];
                }
            }
        } while (increment > 1);
    }

    private static void shellSort_2(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                if (array[i] < array[i - gap]) {
                    int inserted = array[i];
                    int j = 0;
                    for (j = i - gap; j >= 0 && inserted < array[j]; j -= gap) {
                        array[j + gap] = array[j];
                    }
                    array[j + gap] = inserted;
                }
            }
        }
    }
}
