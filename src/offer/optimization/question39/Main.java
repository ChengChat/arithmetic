package offer.optimization.question39;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr1 = {1, 2, 3, 3, 3, 3, 9, 9, 9};
        int num = moreThanHalfNum(arr);
        int num1 = moreThanHalfNum(arr1);
        System.out.println(num);
        System.out.println(num1);
    }

    private static int moreThanHalfNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int count = 1;
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                count++;
                num = arr[i];
            } else if (arr[i] == num) {
                count++;
            } else {
                count--;
            }
        }
        if(checkMoreThanHalf(arr,num)){
            return num;
        }else{
            return -1;
        }
    }

    private static boolean checkMoreThanHalf(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(num == arr[i]){
                count++;
            }
        }
        return count * 2 > arr.length;
    }
}
