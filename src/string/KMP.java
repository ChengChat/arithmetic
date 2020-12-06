package string;

public class KMP {
    public static void main(String[] args) {

        String mainStr = "sdfsfddfgasdfasdf";
        String pattern = "asdfasdf";
        int[] next = getNext(pattern.toCharArray());
        for (int i : next) {
            System.out.println(i);
        }
        int kmp = kmp(mainStr.toCharArray(), pattern.toCharArray(), next);
        System.out.println(kmp);
    }
    /*
        写出求next数组的函数。
        其实也相当于做KMP算法，只是主字符串和模式串都是模式串
        next数组是模式串每个位置的最大匹配前缀，即主字符串每个位置的最大匹配子串，这里的子串指模式串，其实和主字符串一样。
     */

    public static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        //i是主字符串数组的角标
        int i = 0;
        //第一个next放上-1，表示第一个数没有最大匹配前缀
        next[0] = -1;
        //模式串数组的角标,同时也相当于主字符串目前匹配了多长模式串
        int j = -1;
        while (i < pattern.length-1) {
            if (j == -1 || pattern[i] == pattern[j]) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static int kmp(char[] mainStr,char[] pattern,int[] next){
        int i = 0;
        int j = 0;
        while (i < mainStr.length && j < pattern.length){
            if(j == -1 || mainStr[i] == pattern[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j == pattern.length){
            return i-j;
        }
        return -1;

    }
}
