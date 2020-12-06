package offer.ability.question58;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;
import com.sun.deploy.util.ArrayUtil;
import com.sun.deploy.util.StringUtils;
import sort.SortUtlis;

import java.util.Collections;
import java.util.Set;

/**
 * 面试题58（一）：翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Question1 {
    public static void main(String[] args) {
        String sentence = "I am a student.";
        String reverseSentence = reverseSentence(sentence);
        System.out.println(reverseSentence);
    }

    private static String reverseSentence(String sentence) {
        if(sentence == null || sentence.length() == 0 || sentence.trim().length() == 0){
            return null;
        }
        String reverseStr = reverseCharacter(sentence);
        char[] chars = reverseStr.toCharArray();
        int low = 0;
        int high = 0;
        while (low < chars.length){
            if(chars[low] == ' '){
                 low++;
                 high++;
            }else if(high == chars.length || chars[high] == ' '){
                reverseCharacter(chars,low,high - 1);
                low = high;
            }else {
                high++;
            }
        }
        return new String(chars);
    }

    private static void reverseCharacter(char[] chars, int low, int high) {
        while (low < high){
            SortUtlis.swap(chars,low,high);
            low++;
            high--;
        }
    }


    private static String reverseCharacter(String str) {
        if(str == null || str.length() == 0 || str.trim().length() == 0){
            return null;
        }
        char[] c = str.toCharArray();
        int low = 0;
        int high = c.length - 1;
        reverseCharacter(c,low,high);
        return new String(c);
    }
}
