package offer.thinking.question29;

/**
 * 面试题29：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        printMatrix(matrix, matrix.length, matrix[0].length);

    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        int start = 0;
        while (rows > start * 2 && cols > start * 2) {
            printMatrixInCircle(matrix, rows, cols, start);
            start++;
        }
    }

    private static void printMatrixInCircle(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        for (int i = start; i <= endX; i++) {
            System.out.println(matrix[start][i]);
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(matrix[i][endX]);
            }
        }

        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.println(matrix[endY][i]);
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                System.out.println(matrix[i][start]);
            }
        }
    }
}
