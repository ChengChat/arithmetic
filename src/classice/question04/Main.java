package classice.question04;

/**
 * 最长递增子序列（LIS）：
 * 问题是指，在一个给定的数值序列中，找到一个子序列，使得这个子序列元素的数值依次递增，并且这个子序列的长度尽可能地大。
 * 最长递增子序列中的元素在原序列中不一定是连续的。解决最长递增子序列问题的算法最低要求O(nlogn)的时间复杂度。
 * https://blog.csdn.net/codernim/article/details/71055522
 */
public class Main {
    public static void main(String[] args) {
        int[] seq = {2,1,4,2,3,7,4,7,19};
        int len = LIS(seq);
        System.out.println(len);
    }

    private static int LIS(int[] seq) {
        int[] db = new int[seq.length];
        db[0] = seq[0];
        int len = 1;
        for (int i = 1; i < seq.length; i++) {
            if(seq[i] > db[len - 1]){
                db[len++] = seq[i];
            } else{
                int index = binarySearch(db,len,seq[i]);
                db[index] = seq[i];
            }
        }
        return len;
    }

    private static int binarySearch(int[] db, int len, int k) {
        int left = 0;
        int right = len - 1;
        while (left < right){
            int mid = (left + right) >> 1;
            if(k < db[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
