package classice.question02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 现在你的班级刚刚参加了一个只有单选题的考试。班级一共n个学生，考试有m个问题。每个题目都有5个可选答案（A，B，C，D，E）。并且每个题目只有一个正确答案。每个题目的分数并不一样，第i个题目的分数用a[i]表示。如果题目没答对该题会获得0分。
 * 考试结束后，每个学生都记得自己的答案，但是他们还不知道正确答案是什么。如果非常乐观的考虑，他们班级最多可能得到多少分呢？
 *
 * 输入描述:
 * 第一行包含2个正整数，n和m。(1 <= n, m <= 1000，n是班级中学生数量，m是题目的数量)
 *
 * 下面n行数据每行包含一个string si，表示第i个学生的答案。si的第j个字符表示该学生第j个题目的答案。
 *
 * 输出描述:
 * 一个正整数，全班学生最大的可能获得的分数总和。
 *
 * 输入例子1:
 * 2 4
 * ABCD
 * ABCE
 * 1 2 3 4
 *
 * 输出例子1:
 * 16
 *
 * 例子说明1:
 * 最优的答案是ABCD，这样2个学生的总分是16。
 */


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] students = new String[n];
        int[] grades = new int[m];
        for(int i = 0 ;i < n;i++){
            students[i] = sc.next();
        }
         for(int i = 0 ;i < m;i++){
            grades[i] = sc.nextInt();
        }
        int grade = getMaxGrade(students,grades);
        System.out.println(grade);
    }
    public static int getMaxGrade(String[] students,int[] arr){
        int count = 0;
        for(int i = 0;i < arr.length; i++){
            count += (arr[i] * getMaxCount(students,i));
        }
        return count;
    }
    public static int getMaxCount(String[] students,int k){
        int max = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < students.length; i++){
            char c = students[i].toCharArray()[k];
            map.merge(c, 1, Integer::sum);
        }
        Set<Character> sets = map.keySet();
       for(Character set : sets){
           if(map.get(set) > max){
               max = map.get(set);
           }
       }
        return max;
    }
}