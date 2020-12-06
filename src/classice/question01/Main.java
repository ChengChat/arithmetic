package classice.question01;
import java.util.*;

/**
 * 给定两个版本号，只有在版本号更高的时候，才可以升级。「.」号作为分割符使用，版本号中只有数和.号。
 *
 * 例如：0.1<1.1
 * 1.2<13.37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] versions = new String[n][2];
        for (int i = 0; i < n; i++) {
            versions[i][0] = sc.next();
            versions[i][1] = sc.next();
        }
        String[] oldVersion;
        String[] newVersion;
        for (int i = 0; i < n; i++) {
            oldVersion = versions[i][0].split("\\.");
            newVersion = versions[i][1].split("\\.");
            System.out.println(updateCore(oldVersion, newVersion, 0));
        }
    }

    private static boolean updateCore(String[] oldVersion, String[] newVersion, int n) {
        if (n >= newVersion.length) {
            return false;
        }
        if (n >= oldVersion.length) {
            while (n < newVersion.length) {
                if (Integer.parseInt(newVersion[n]) != 0) {
                    return true;
                }
                n++;
            }
            return false;
        }
        int newVer = Integer.parseInt(newVersion[n]);
        int oldVer = Integer.parseInt(oldVersion[n]);
        if (newVer == oldVer) {
            return updateCore(oldVersion, newVersion, n + 1);
        } else if (newVer < oldVer) {
            return false;
        } else {
            return true;
        }
    }
}