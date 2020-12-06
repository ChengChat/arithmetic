package test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * “特殊数字”是指只能被分解为2，3，7的乘积的数字。
 * “特殊数字”序列为1, 2, 3, 4, 6, 7, 8, 9, 12, 14, ...
 * 展示了前10个“特殊数字”。按照惯例，1也是“特殊数字”。
 * 给定整数n，写一个程序，找到序列中，第n个“特殊数字”。
 * 如：n=9，找到“特殊数字”序列中第9位数字，也就是输出12。（30分）
 * <p>
 * 输入：
 * 每一行包含一个正整数，n (n <= 1500)。如果输入的一行为0，则输入终止。
 * <p>
 * 输出：
 * 对于每一行输入，输出“特殊数字”。注意不要解析输入为0的行
 * <p>
 * 示例：
 * <p>
 * 输入：
 * 1
 * 2
 * 9
 * 0
 * <p>
 * 输出：
 * 1
 * 2
 * 12
 */
public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (true) {
            int next = scanner.nextInt();
            if (next != 0) {
                set.add(next);
            } else {
                break;
            }
        }
        getSpecialWord(set);

    }

    private static void getSpecialWord(TreeSet<Integer> set) {
        int count = 0;
        for (int i = 0; !set.isEmpty(); i++) {
            if (isSpecialWord(i)) {
                count++;
                if (count == set.first()) {
                    set.remove(set.first());
                    System.out.println(i);
                }
            }
        }
    }

    private static boolean isSpecialWord(int number) {

        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }

        while (number % 7 == 0) {
            number /= 7;
        }

        return number == 1;
    }
}
