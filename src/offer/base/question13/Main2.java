package offer.base.question13;

import offer.thinking.question35.LinkedList;

public class Main2 {

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 10000; i++) {
             count = movingCount(36, 100, 34);
        }
        long l2 = System.currentTimeMillis();

        System.out.println(count);
        System.out.println(l2 - l1);

    }

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row][col]) {
            visited[row][col] = true;
            if (getSum(row) + getSum(col) <= threshold) {
                count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                        + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                        + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                        + movingCountCore(threshold, rows, cols, row, col - 1, visited);
            }
        }
        return count;
    }

    private static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
