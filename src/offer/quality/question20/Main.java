package offer.quality.question20;

/**
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        boolean flag1 = main.isNumeric_1("123.45e+6");
        boolean flag2 = main.isNumeric_2("1.E+308");
        System.out.println(flag1);
        System.out.println(flag2);
    }

    /**
     * 方法一：用正则表达式
     */
    public boolean isNumeric_1(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    int index = 0;

    private boolean isNumeric_2(String numeric) {
        if (numeric == null || numeric.length() == 0) {
            return false;
        }
        return isNumeric(numeric.toCharArray());
    }

    private boolean isNumeric(char[] target) {
        // 先判断整数部分
        index = 0;
        boolean flag = scanInteger(target);
        // 再判断小数部分
        if (index < target.length && target[index] == '.') {
            index++;
            flag = scanUnsignedInteger(target) || flag;
        }
        // 再判断指数部分
        if (index < target.length && (target[index] == 'e' || target[index] == 'E')) {
            index++;
            flag = scanInteger(target) && flag;
        }
        return index >= target.length && flag;
    }

    private boolean scanInteger(char[] target) {
        if (index < target.length && (target[index] == '+' || target[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(target);
    }

    private boolean scanUnsignedInteger(char[] target) {
        int temp = index;
        while (index < target.length && target[index] >= '0' && target[index] <= '9') {
            index++;
        }
        return temp < index;
    }
}
