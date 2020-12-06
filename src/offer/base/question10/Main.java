package offer.base.question10;

/**
 * 面试题10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
public class Main {
    public static void main(String[] args) {
        int fib1 = fibonacci1(5);
        int fib2 = fibonacci2(5);

        System.out.println(fib1);
        System.out.println(fib2);
    }

    private static int fibonacci2(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        int minusTwo = 0;
        int minusOne = 1;
        int fib = 0;
        for (int j = 2; j <= i; j++) {
            fib = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = fib;
        }
        return fib;
    }

    private static int fibonacci1(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fibonacci1(i - 1) + fibonacci1(i - 2);
    }
}
