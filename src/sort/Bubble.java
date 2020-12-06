package sort;

/**
 * 冒泡排序：
 * 两两比较相邻记录的关键字，如果反序则交换，直到没有反序的记录为止。
 * 从小到大排序。。
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = SortUtlis.createArray();
//        bubbleSort(arr);
        SortUtlis.print(arr);

        // 有可能在冒泡完几轮之后，别的都已经是正常排序了，
        // 但是上面算法仍然会将后面每一轮冒泡都执行一遍，尽管没有交换数据，但是后面的大量比较还是大大多余了。
        // 下面是优化算法
        bubbleSort2(arr);
        SortUtlis.print(arr);


    }

    private static void bubbleSort2(int[] arr) {
        boolean flag = true;
        for (int i = 1; (i < arr.length) && flag; i++) {
            flag = false;
            for (int j = arr.length - 1; j >= i; j--) {
                // 如果这一轮没有交互过数据，说明所有数据都是有序了
                if(arr[j-1] > arr[j]){
                    SortUtlis.swap(arr,j-1,j);
                    // 如果有数据交换，则flag = true
                    flag = true;
                }
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if(arr[j-1] > arr[j]){
                    SortUtlis.swap(arr,j-1,j);
                }
            }
        }
    }
}
