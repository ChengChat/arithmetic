package offer.quality.question19;

/**
 * 面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 */
public class Main {
    public static void main(String[] args) {
        boolean expected = match("aaa", "ab*ac*a");
        System.out.println(expected);
    }

    private static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str.toCharArray(), 0, pattern.toCharArray(), 0);

    }

    private static boolean matchCore(char[] target, int tIndex, char[] pattern, int pIndex) {
        int tLen = target.length;
        int pLen = pattern.length;
        if (pIndex >= pLen) {
            return tIndex >= tLen;
        }
        if (pIndex + 1 < pLen && pattern[pIndex + 1] == '*') {
            if (tIndex < tLen && (pattern[pIndex] == target[tIndex] || pattern[pIndex] == '.')) {
                return matchCore(target, tIndex, pattern, pIndex + 2)
                        || matchCore(target, tIndex + 1, pattern, pIndex + 2)
                        || matchCore(target, tIndex + 1, pattern, pIndex);
            } else {
                return matchCore(target, tIndex, pattern, pIndex + 2);
            }
        }
        if (tIndex < tLen
                && (pattern[pIndex] == target[tIndex] || pattern[pIndex] == '.')) {
            return matchCore(target, tIndex + 1, pattern, pIndex + 1);
        }
        return false;
    }
}
