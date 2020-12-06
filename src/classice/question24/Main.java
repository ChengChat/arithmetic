package classice.question24;


import java.util.Scanner;

/**
 * 有一对兔子，从出生到第5个月 每月生一对兔子，n月后，有几对兔子。
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] dp = new long[n+1];
        if(n < 5){
            System.out.println(1);
        }else{
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 1;
            for (int i = 5; i < dp.length; i++) {
                dp[i] = dp[i-1] + dp[i-4];
            }
            System.out.println(dp[n]);
        }
    }
}
