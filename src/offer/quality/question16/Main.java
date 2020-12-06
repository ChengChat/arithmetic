package offer.quality.question16;

/**
 *  面试题16：数值的整数次方
 *  题目：实现函数double Power(double base, int exponent)，求base的exponent次方。
 *  不得使用库函数，同时不需要考虑大数问题。
 */
public class Main {
    public static void main(String[] args) {
        double result = power(0,-4);
        double result2 = power(-2,3);
        System.out.println(result);
        System.out.println(result2);

    }

    private static double power(double base, int exponent) {
        if(Math.abs(base - 0.0) <= 0 && exponent < 0){
            throw new IllegalArgumentException();
        }
        double result = powerWithUnsignedExponent(base,Math.abs(exponent));
        if(exponent < 0 ){
            result = 1.0/result;
        }
        return result;

    }

    private static double powerWithUnsignedExponent(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        double result = powerWithUnsignedExponent(base,exponent >> 1);
        result *= result;
        if((exponent & 1) == 1){
            result *= base;
        }
        return result;
    }
}
