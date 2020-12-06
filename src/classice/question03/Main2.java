package classice.question03;

import java.util.*;

/**
 * 也是0-1背包问题：
 * 给定一组石头，每个石头有一个正数的重量。每一轮开始的时候，选择两个石头一起碰撞，假定两个石头的重量为x，y，x<=y,碰撞结果为
 * 1. 如果x==y，碰撞结果为两个石头消失
 * 2. 如果x != y，碰撞结果两个石头消失，生成一个新的石头，新石头重量为y-x
 *
 * 最终最多剩下一个石头为结束。求解最小的剩余石头质量的可能性是多少。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), sum = 0, result = 0;
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);

        }
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[j]) {
                result = Math.abs(j - (sum - j));
                break;
            }
        }
        System.out.println(result);
    }
}

