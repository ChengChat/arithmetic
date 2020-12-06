package classice.question19;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxEnvelopes(array));
    }

    private static int maxEnvelopes(int[][] array) {
        insertSort(array);
        int maxI = 0;
        int maxJ = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i][0] > maxI && array[i][1] > maxJ){
                count++;
                maxI = array[i][0];
                maxJ = array[i][1];
            }
        }
        return count;
    }

    private static void insertSort(int[][] array) {
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] <= array[i - 1][0]) {
                int tempI = array[i][0];
                int tempJ = array[i][1];
                for (j = i - 1; j >= 0; j--) {
                     if(array[j][0] > tempI || (array[j][0] == tempI && array[j][1] > tempJ)){
                        array[j + 1][0] = array[j][0];
                        array[j + 1][1] = array[j][1];
                    }else {
                         break;
                     }
                }
                array[j + 1][0] = tempI;
                array[j + 1][1] = tempJ;
            }
        }
    }
}
