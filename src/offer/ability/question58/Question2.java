package offer.ability.question58;

import sort.SortUtlis;

/**
 * 面试题58（二）：左旋转字符串
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */
public class Question2 {
    public static void main(String[] args) {
        String str = "abcdefg";
        String leftStr = leftRotateString(str,3);
        System.out.println(leftStr);
    }

    private static String leftRotateString(String str, int n) {
        if(str == null || str.length() == 0){
            return null;
        }
        if(n >= str.length()){
            throw new IllegalArgumentException();
        }
        char[] chars = str.toCharArray();
        reverseCharacter(chars,0,n-1);
        reverseCharacter(chars,n,chars.length-1);
        reverseCharacter(chars,0,chars.length-1);
        return new String(chars);
    }

    private static void reverseCharacter(char[] chars, int low, int high) {
        while (low < high){
            SortUtlis.swap(chars,low,high);
            low++;
            high--;
        }
    }
}
