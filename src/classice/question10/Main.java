    package classice.question10;

    import java.util.Arrays;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String p = in.nextLine();
            String t = in.nextLine();
            boolean flag = isMatch(p.toCharArray(), t.toCharArray(), 0, 0);
            System.out.println(flag?1:0);

        }

        private static boolean isMatch(char[] pattern, char[] target, int p, int t) {
            if (p < pattern.length && t < target.length) {
                if (pattern[p] == target[t] || pattern[p] == '?') {
                    return isMatch(pattern, target, p + 1, t + 1);
                } else {
                    if (pattern[p] == '*') {
                        return isMatch(pattern, target, p + 1, t + 1)
                                || isMatch(pattern, target, p, t + 1)
                                || isMatch(pattern, target, p + 1, t);
                    }
                }
            }
            if (p == pattern.length && t == target.length) {
                return true;
            }else if(p == pattern.length){
                return false;
            }
            return p == pattern.length - 1 && pattern[p] == '*';
        }
    }
