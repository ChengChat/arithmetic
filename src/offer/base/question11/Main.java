package offer.base.question11;

/**
 * 面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = {3, 4, 5, 1, 2};
        int[] ints = new int[2];
        int min = getMin(arr);
        int min1 = getMin(new int[]{1,0,1,1,1});
        int min2 = getMin(new int[]{1,1,1,0,1});
        /*int min3 = getMin(null);
        int min4 = getMin(ints);*/
        System.out.println(min);
        System.out.println(min1);
        System.out.println(min2);
/*        System.out.println(min3);
        System.out.println(min4);*/
    }

    private static int getMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = left;
        while (arr[left] >= arr[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            if(arr[mid] == arr[left] && arr[mid] == arr[right]){
                return minInOrder(arr,left,right);
            }
            if(arr[mid] >= arr[left]){
                left = mid;
            }else if(arr[mid] <= arr[right]){
                right = mid;
            }
        }
        return arr[mid];
    }

    private static int minInOrder(int[] arr, int left, int right) {

        int min = arr[left];
        for(int i = left+1;i<=right;i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
