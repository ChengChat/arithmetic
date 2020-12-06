package offer.base.question13;

/**
 * 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它每一次可以向左、右、上、下移动一格，
 * 但不能进入行坐标和列坐标的数位之和大于k的格子。
 *
 * 例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Main {

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
        if(threshold < 0 || rows <= 0 || cols <= 0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if(check(threshold,rows,cols,row,col,visited)){
            visited[row][col] = true;
            return 1 + movingCountCore(threshold,rows,cols,row + 1,col,visited)
                    + movingCountCore(threshold,rows,cols,row - 1,col,visited)
                    + movingCountCore(threshold,rows,cols,row,col + 1,visited)
                    + movingCountCore(threshold,rows,cols,row,col - 1,visited);
        }
        return 0;


    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {

        return row < rows && row >= 0 && col < cols && col >= 0
                && !visited[row][col] && getDigitSum(row) + getDigitSum(col) <= threshold;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0 ){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
