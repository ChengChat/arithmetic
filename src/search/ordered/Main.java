package search.ordered;

/**
 * 有序表查找：
 * 查找表中的记录对于关键码有序，
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {0,3,4,5,6,8,9,14,57};
        //二分查找
        int index = Binary.sort(arr, 14);
        //递归形式的二分查找
        int index2 = Binary.sortByRecursive(arr, 1, arr.length - 1, 0);
        //插值查找
        int index3 = Interpolation.sort(arr, 5);
        //斐波那契查找
        int[] arr2 = {0,3,4,5,6,8,9,14,22,25,28,0,0,0,0,0};
        int index4 = Fibonacci.sort(arr2,10,25);
        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
    }
}
