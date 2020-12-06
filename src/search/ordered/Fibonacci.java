package search.ordered;

/**
 * 斐波那契查找：
 * 又叫黄金分割查找，每次从0.618的位置分割成两段，
 * 而斐波那契数列的 第 i 个和 第 i+1 个元素的值比例随着i的值增大会越来越接近0.618
 */
public class Fibonacci {
    public static int sort(int[] arr,int n, int key) {
        //需要初始化一个斐波那契数列
        int[] fibonacci = {0,1,1,2,3,5,8,13,21,34};
        int low = 1;
        int high = n;
        int mid = 0;
        int k = 0;
        //计算n位于斐波那契数列的位置
        while (n > fibonacci[k] -1){
            k++;
        }
        //将不满的数值填充满
        for (int i = n; i < fibonacci[k] - 1; i++) {
            arr[i] = arr[n];
        }
        while (low <= high) {
            mid = low + fibonacci[k-1] - 1;
            if (key > arr[mid]) {
                low = mid + 1;
                k = k - 2;
            } else if (key < arr[mid]) {
                high = mid - 1;
                k = k - 1;
            } else {
                if(mid <= n){
                    return mid;
                }else {
                    return n;
                }
            }
        }
        return 0;
    }
}
