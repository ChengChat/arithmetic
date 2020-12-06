package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 把中文类型的数字表示形式转换成数字串，
 * 类似“伍拾叁”转换为“53”，“玖拾捌亿柒仟陆佰伍拾肆万叁仟贰佰零壹”转换为“9876543201”。
 * 示例：
 *
 * 输入（从标准输入读取）：
 * 玖拾捌亿柒仟陆佰伍拾肆万叁仟贰佰零壹
 *
 * 输出（打印到标准输出）：
 * 9876543201
 */
public class Question3 {


    private static final String[] BEFORE_SCALE = { "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "" };

    private static final Map<String, String> NUMBER_MAPPING = new HashMap<String, String>();
    static {
        NUMBER_MAPPING.put("0", "零");
        NUMBER_MAPPING.put("1", "壹");
        NUMBER_MAPPING.put("2", "贰");
        NUMBER_MAPPING.put("3", "叁");
        NUMBER_MAPPING.put("4", "肆");
        NUMBER_MAPPING.put("5", "伍");
        NUMBER_MAPPING.put("6", "陆");
        NUMBER_MAPPING.put("7", "柒");
        NUMBER_MAPPING.put("8", "捌");
        NUMBER_MAPPING.put("9", "玖");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

    }


}

