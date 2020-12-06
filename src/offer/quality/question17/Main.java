package offer.quality.question17;

import java.math.BigInteger;

/**
 *  面试题17：打印1到最大的n位数
 *  题目：输入数字n，按顺序打印出从1最大的n位十进制数。
 *  比如输入3，则打印出1、2、3一直到最大的3位数即999。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        BigInteger number = new BigInteger("3");
        BigInteger add = number.add(new BigInteger("1"));
        System.out.println(add);
        BigInteger multiply = number.multiply(new BigInteger("3"));
        System.out.println(multiply);
        BigInteger subtract = multiply.subtract(new BigInteger("3"));
        System.out.println(subtract);
    }
}
