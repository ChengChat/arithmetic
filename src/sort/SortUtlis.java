package sort;

public class SortUtlis {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 若有哨兵，则打印时需要把哨兵排除，
     * @param flag 若为true，则排除哨兵元素
     */
    public static void print(int[] arr,boolean flag) {
        if (flag){
            for (int i = 1; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }else {
            print(arr);
        }
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(char[] arr) {
        for (char i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] createArray() {
        return new int[]{3, 5, 4, 7, 13, 6, 4, 7, 5, 74, 46, 234, 68, 23, 89, 23, 47, 87};
    }

    public static int[] createArrayWithSentry() {
        return new int[]{0, 3, 5, 4, 7, 13, 6, 4, 7, 5, 74, 46, 234, 68, 23, 89, 23, 47, 87};
    }
}
