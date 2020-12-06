package classice.question21;


public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        cycle(arr, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void cycle(int[] arr, int k) {
        if (k > arr.length) {
            return;
        }
        for (int i = 0; i < k; i++) {
            swap(arr, i, arr.length + i - k);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
