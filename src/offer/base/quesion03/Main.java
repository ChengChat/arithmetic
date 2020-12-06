package offer.base.quesion03;

/**
 *
 * 找出数组中重复的数字:
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int[] arr1 = null;
        int[] arr2 = {};
        int duplication1 = Question1.getDuplication(arr);
        int duplication2 = Question2.getDuplication(arr);
        System.out.println(duplication1);
        System.out.println(duplication2);
    }
}
