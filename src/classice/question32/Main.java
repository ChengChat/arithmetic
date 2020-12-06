package classice.question32;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right && chars[left] != '2'){
            left++;
        }
        while (left < right && chars[right] != '5'){
            right--;
        }
        if(right <= left){
            System.out.println(0);
        }else{
            System.out.println(right - left + 1);
        }
    }
}
