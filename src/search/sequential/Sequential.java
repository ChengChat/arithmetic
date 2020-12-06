package search.sequential;

/**
 * 顺序表查找法
 */
public class Sequential {
    public static void main(String[] args) {
        //第0个位置不放数据，为了对齐或者放置哨兵。
        int[] arr = {0, 4, 2, 6, 5, 7, 35, 7, 3};
        int index = sequential(arr, 5);
        //在这种查找尽头放置“哨兵”，免去了在查找过程中每一次比较后都要判断查找位置是否越界
        int index2 = sequentialWithSentry(arr, 5);
        System.out.println(index2);
    }

    private static int sequentialWithSentry(int[] arr, int key) {
        arr[0] = key;
        int i = arr.length - 1;
        while (arr[i] != key){
            i--;
        }
        return i;
    }

    private static int sequential(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return 0;
    }
}
