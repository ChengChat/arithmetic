package offer.ability;


/**
 * 面试题65：不用加减乘除做加法
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 */
public class question65 {
    public static void main(String[] args) {
        int sum = addition(34, 56);
        System.out.println(sum);
    }

    private static int addition(int i, int j) {
        int sum, carry;
        do {
            sum = i ^ j;
            carry = (i & j) << 1;
            i = sum;
            j = carry;
        } while (j != 0);
        return sum;
    }
}
