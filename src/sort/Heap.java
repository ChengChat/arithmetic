package sort;

/**
 * 堆排序：
 * 将待排序的序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根结点。
 * 将它移到末尾，然后将剩余的n-1个序列重新构成一个堆，如此反复执行。
 * <p>
 * 堆是具有以下性质的完全二叉树：
 * 每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆。
 * 每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 */
public class Heap {
    public static void main(String[] args) {
        // int[] array = SortUtlis.createArray();
        int[] array = {50,10,90,60,40,40,80,30,20};
        heapSort(array);
        SortUtlis.print(array);
    }

    private static void heapSort(int[] array) {
        //构造大顶堆
        for (int i = array.length >> 1; i >= 0; i--) {
            heapAdjust(array, i, array.length - 1);
        }
        SortUtlis.print(array);
        for (int i = array.length - 1; i > 0; i--) {
            // 将堆顶元素和当前未经排序子序列的最后一个记录交换
            SortUtlis.swap(array,0,i);
            // 重新调整为大顶堆
            heapAdjust(array,0,i-1);
        }
    }

    private static void heapAdjust(int[] array, int s, int m) {
        int temp = array[s];
        for (int i = s * 2; i <= m; i*=2) {
            if(i < m && array[i] < array[i+1]){
                i++;
            }
            if(temp >= array[i]) {
                break;
            }
            array[s] = array[i];
            s = i;
        }
        array[s] = temp;
    }
}
