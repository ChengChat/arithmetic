package offer.base.question15;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * <p>
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class Main {
    public static void main(String[] args) {
        // 可能引起死循环的解法 需使用逻辑右移
        int num1 = getNumber1(-7);
        System.out.println(num1);
        // 常规解法
        int num2 = getNumber2(5);
        System.out.println(num2);
        // 惊喜解法
        int num3 = getNumber3(-7);
        System.out.println(num3);

    }

    private static int getNumber3(int n) {
        int num = 0;
        while (n != 0) {
            n = (n - 1) & n;
            num++;
        }
        return num;
    }

    private static int getNumber2(int n) {
        int num = 0;
        int i = 1;
        while (i != 0) {
            if ((n & i) != 0) {
                num++;
            }
            i = i << 1;
        }
        return num;
    }


    private static int getNumber1(int n) {
        int num = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                num++;
            }
            // >> : 是带符号右移   即若该数为正，则高位补0，而若该数为负数，则右移后高位补1。
            //                    这里若使用这种，会发生死循环
            // >>> : 是无符号右移，即逻辑右移   即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
            n = n >>> 1;
        }
        return num;
    }
}
